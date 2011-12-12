package ula.service.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import ula.service.BaseService;
import ula.util.MapUtil;

public class TourService extends BaseService {
	private static final String SQL_GET_ALL_TOUR_VACATION_TYPES = "select * from tour_vacation_type";

	public List<Map<String, Object>> getAllTourVacationTypes() {
		return DB.queryForList(SQL_GET_ALL_TOUR_VACATION_TYPES);
	}

	private static final String SQL_GET_ALL_TOUR_CATEGORIES = "select * from tour_category";

	public List<Map<String, Object>> getAllTourCategories() {
		return DB.queryForList(SQL_GET_ALL_TOUR_CATEGORIES);
	}

	private static final String SQL_ADD_TOUR_CATEGORY = "insert into tour_category(NAME,UPDATETIME,USERNAME) values(?,now(),?)";
	private static final String SQL_ADD_CATEGORY_AND_VACATION_TYPE = "insert into tour_category_vacation_type(CATEGORY_ID,VACATION_TYPE_ID) values(?,?)";

	public void addTourCategory(Map<String, Object> parameters,
			final String userName) {
		// 先插入到分类表，然后取出刚生成的主键ID
		final String param = MapUtil.getStringFromMap(parameters, "name");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		DB.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(
						SQL_ADD_TOUR_CATEGORY, new String[] { "NAME",
								"USERNAME" });
				ps.setString(1, (String) param);
				ps.setString(2, (String) userName);
				return ps;
			}
		}, keyHolder);
		// 获取分类ID
		final int cid = keyHolder.getKey().intValue();
		// 插入关联
		final String[] vacationTypes = (String[]) parameters
				.get("vacationType");
		DB.batchUpdate(SQL_ADD_CATEGORY_AND_VACATION_TYPE,
				new BatchPreparedStatementSetter() {

					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						ps.setObject(1, cid);
						ps.setObject(2, vacationTypes[i]);
					}

					public int getBatchSize() {
						return vacationTypes.length;
					}
				});
	}

	private static final String SQL_GET_TOUR_CATEGORY_BY_ID = "select * from tour_category where ID=?";

	public Map<String, Object> getTourCategoryByID(
			Map<String, Object> parameters) {
		Object param = MapUtil.getObjectFromMap(parameters, "id");
		return DB.queryForMap(SQL_GET_TOUR_CATEGORY_BY_ID, param);
	}

	private static final String SQL_GET_VACATION_TYPE_BY_TOUR_CATEGORY_ID = "select * from tour_category_vacation_type where CATEGORY_ID=?";

	public List<Map<String, Object>> getVacationTypeByTourCategoryID(
			Map<String, Object> parameters) {
		Object param = MapUtil.getObjectFromMap(parameters, "id");
		return DB
				.queryForList(SQL_GET_VACATION_TYPE_BY_TOUR_CATEGORY_ID, param);
	}

	private static final String SQL_UPDATE_TOUR_CATEGORY_BY_ID = "update tour_category set NAME=?, UPDATETIME=now(), USERNAME=? where ID=?";
	private static final String SQL_DELETE_VACATION_TYPE_BY_TOUR_CATEGOURY_ID = "delete from tour_category_vacation_type where CATEGORY_ID=?";

	public void updateTourCategoryByID(Map<String, Object> parameters,
			String userName) {
		final Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"name,id");
		// 先更新category表
		DB.update(SQL_UPDATE_TOUR_CATEGORY_BY_ID, params[0], userName,
				params[1]);
		// 删除已有关联
		DB.update(SQL_DELETE_VACATION_TYPE_BY_TOUR_CATEGOURY_ID, params[1]);
		// 批量设置新的关联
		final String[] vacationTypes = (String[]) parameters
				.get("vacationType");
		DB.batchUpdate(SQL_ADD_CATEGORY_AND_VACATION_TYPE,
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						ps.setObject(1, params[1]);
						ps.setObject(2, vacationTypes[i]);
					}

					public int getBatchSize() {
						return vacationTypes.length;
					}
				});

	}
}
