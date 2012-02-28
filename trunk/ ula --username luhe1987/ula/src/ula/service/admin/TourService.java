
package ula.service.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class TourService extends BaseService {
    private static final String SQL_GET_ALL_TOUR_VACATION_TYPES = "select * from tour_vacation_type";

    public List<Map<String, Object>> getAllTourVacationTypes() {
        return jt.queryForList(SQL_GET_ALL_TOUR_VACATION_TYPES);
    }

    private static final String SQL_GET_TOUR_CATEGORY_BY_VACATION_TYPE = "select NAME from tour_category where ID in (select CATEGORY_ID from tour_category_vacation_type where VACATION_TYPE_ID=?)";

    public List<Map<String, Object>> getTourCategoryByVacationType(Map<String, Object> parameters) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
        return jt.queryForList(SQL_GET_TOUR_CATEGORY_BY_VACATION_TYPE, params);
    }

    private static final String SQL_GET_ALL_TOUR_CATEGORIES = "select * from tour_category";

    public List<Map<String, Object>> getAllTourCategories() {
        return jt.queryForList(SQL_GET_ALL_TOUR_CATEGORIES);
    }

    private static final String SQL_ADD_TOUR_CATEGORY = "insert into tour_category(NAME,UPDATETIME,USERNAME,DESCRIPTION) values(?,now(),?,?)";

    private static final String SQL_ADD_CATEGORY_AND_VACATION_TYPE = "insert into tour_category_vacation_type(CATEGORY_ID,VACATION_TYPE_ID) values(?,?)";

    public void addTourCategory(Map<String, Object> parameters, final String userName) {
        // 先插入到分类表，然后取出刚生成的主键ID
        final String param = MapUtil.getStringFromMap(parameters, "name");
        final String description = MapUtil.getStringFromMap(parameters, "description");

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jt.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(SQL_ADD_TOUR_CATEGORY, new String[] {
                        "NAME", "USERNAME", "DESCRIPTION"
                });
                ps.setString(1, (String)param);
                ps.setString(2, (String)userName);
                ps.setString(3, (String)description);
                return ps;
            }
        }, keyHolder);
        // 获取分类ID
        final int cid = keyHolder.getKey().intValue();
        // 获取关联的休假类型
        final String[] vacationTypes = (String[])parameters.get("vacationType");
        // 插入关联
        if (ArrayUtils.isNotEmpty(vacationTypes)) {
            jt.batchUpdate(SQL_ADD_CATEGORY_AND_VACATION_TYPE, new BatchPreparedStatementSetter() {

                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setObject(1, cid);
                    ps.setObject(2, vacationTypes[i]);
                }

                public int getBatchSize() {
                    return vacationTypes.length;
                }
            });
        }
    }

    private static final String SQL_GET_TOUR_CATEGORY_BY_ID = "select * from tour_category where ID=?";

    public Map<String, Object> getTourCategoryByID(Map<String, Object> parameters) {
        Object param = MapUtil.getObjectFromMap(parameters, "id");
        return jt.queryForMap(SQL_GET_TOUR_CATEGORY_BY_ID, param);
    }

    private static final String SQL_GET_VACATION_TYPE_BY_TOUR_CATEGORY_ID = "select * from tour_category_vacation_type where CATEGORY_ID=?";

    public List<Map<String, Object>> getVacationTypeByTourCategoryID(Map<String, Object> parameters) {
        Object param = MapUtil.getObjectFromMap(parameters, "id");
        return jt.queryForList(SQL_GET_VACATION_TYPE_BY_TOUR_CATEGORY_ID, param);
    }

    private static final String SQL_UPDATE_TOUR_CATEGORY_BY_ID = "update tour_category set NAME=?, UPDATETIME=now(), USERNAME=? where ID=?";

    private static final String SQL_DELETE_VACATION_TYPE_BY_TOUR_CATEGOURY_ID = "delete from tour_category_vacation_type where CATEGORY_ID=?";

    public void updateTourCategoryByID(Map<String, Object> parameters, String userName) {
        final Object[] params = MapUtil.getObjectArrayFromMap(parameters, "name,id");
        // 先更新category表
        jt.update(SQL_UPDATE_TOUR_CATEGORY_BY_ID, params[0], userName, params[1]);
        // 删除已有关联
        jt.update(SQL_DELETE_VACATION_TYPE_BY_TOUR_CATEGOURY_ID, params[1]);
        // 批量设置新的关联
        final String[] vacationTypes = (String[])parameters.get("vacationType");
        jt.batchUpdate(SQL_ADD_CATEGORY_AND_VACATION_TYPE, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setObject(1, params[1]);
                ps.setObject(2, vacationTypes[i]);
            }

            public int getBatchSize() {
                return vacationTypes.length;
            }
        });

    }

    private static final String SQL_DELETE_TOUR_BY_CATEGORY_ID = "delete from tour where CATEGORY_ID=?";

    private static final String SQL_DELETE_TOUR_CATEGORY_BY_ID = "delete from tour_category where ID=?";

    public void deleteTourCategoryById(Map<String, Object> parameters) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
        jt.update(SQL_DELETE_VACATION_TYPE_BY_TOUR_CATEGOURY_ID, params);
        jt.update(SQL_DELETE_TOUR_BY_CATEGORY_ID, params);
        jt.update(SQL_DELETE_TOUR_CATEGORY_BY_ID, params);
    }

    private static final String SQL_GET_ALL_TOURS = "select t.ID, t.TITLE, t.UPDATETIME, t.USERNAME, c.NAME  as CATEGORY_NAME from tour t, tour_category c where t.CATEGORY_ID=c.ID order by UPDATETIME desc";

    public PagingList getAllTours() {
        return getPagingList(SQL_GET_ALL_TOURS);
    }

    private static final String SQL_ADD_TOUR = "insert into tour(CATEGORY_ID, TITLE, DESCRIPTION, COVERLINK, CONTENT, UPDATETIME, USERNAME, SHOWINTABLE,ASCATEGORYINDEX) values(?, ?, ?, ?, ?,now(), ?,?,?)";

    private static final String SQL_RESET_TOUR_INDEX = "update tour set ASCATEGORYINDEX = 'N'";

    public void addTour(Map<String, Object> parameters, String filePath, String userName) {

        // Reset all tours as non-index tag
        String asCatetoryIndex = MapUtil.getStringFromMap(parameters, "as_index");
        if (asCatetoryIndex.equalsIgnoreCase(asCatetoryIndex)) {
            jt.update(SQL_RESET_TOUR_INDEX);
        }

        Object[] params = MapUtil.getObjectArrayFromMap(parameters,
                "cid,title,description,content,show_in_table,as_index");
        jt.update(SQL_ADD_TOUR, params[0], params[1], params[2], filePath, params[3], userName,
                params[4], params[5]);
    }

    private static final String SQL_GET_TOUR_BY_ID = "select * from tour where ID=?";

    public Map<String, Object> getTourById(Map<String, Object> parameters) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
        return jt.queryForMap(SQL_GET_TOUR_BY_ID, params);
    }

    private static final String SQL_UPDATE_TOUR_NO_COVERLINK_BY_ID = "update tour set CATEGORY_ID=?, TITLE=?, DESCRIPTION=?, CONTENT=?, UPDATETIME=now(), USERNAME=?,SHOWINTABLE=?, ASCATEGORYINDEX=? where ID=?";

    public void updateTourById(Map<String, Object> parameters, String userName) {
     
        // Reset all tours as non-index tag
        String asCatetoryIndex = MapUtil.getStringFromMap(parameters, "as_index");
        if (asCatetoryIndex.equalsIgnoreCase(asCatetoryIndex)) {
            jt.update(SQL_RESET_TOUR_INDEX);
        }
        
        Object[] params = MapUtil.getObjectArrayFromMap(parameters,
                "cid,title,description,content,show_in_table,as_index,id");
        jt.update(SQL_UPDATE_TOUR_NO_COVERLINK_BY_ID, params[0], params[1], params[2], params[3],
                userName, params[4], params[5], params[6]);
    }

    private static final String SQL_UPDATE_TOUR_BY_ID = "update tour set CATEGORY_ID=?, TITLE=?, COVERLINK=?,DESCRIPTION=?, CONTENT=?, UPDATETIME=now(), USERNAME=?, SHOWINTABLE=?, ASCATEGORYINDEX=? where ID=?";

    public void updateTourById(Map<String, Object> parameters, String filePath, String userName) {
       
        // Reset all tours as non-index tag
        String asCatetoryIndex = MapUtil.getStringFromMap(parameters, "as_index");
        if (asCatetoryIndex.equalsIgnoreCase(asCatetoryIndex)) {
            jt.update(SQL_RESET_TOUR_INDEX);
        }
        
        Object[] params = MapUtil.getObjectArrayFromMap(parameters,
                "cid,title,description,content,show_in_table,as_index,id");
        jt.update(SQL_UPDATE_TOUR_BY_ID, params[0], params[1], filePath, params[2], params[3],
                userName, params[4], params[5], params[6]);
    }

    private static final String SQL_DELETE_PRODUCT_TOUR_BY_ID = "delete from product_tour where TOUR_ID=?";

    private static final String SQL_DELETE_TOUR_BY_ID = "delete from tour where ID=?";

    public void deleteTourById(Map<String, Object> parameters) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
        jt.update(SQL_DELETE_PRODUCT_TOUR_BY_ID, params);
        jt.update(SQL_DELETE_TOUR_BY_ID, params);
    }
}
