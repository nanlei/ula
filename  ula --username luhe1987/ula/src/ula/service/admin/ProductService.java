
package ula.service.admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 产品功能service
 * 
 * @author Nanlei
 */
public class ProductService extends BaseService {
    private static final String SQL_GET_PRODUCTS_DISPLAY_NUM = "select count(*) from product where TAG=1";

    public int getProductsDisplayNum() {
        return jt.queryForInt(SQL_GET_PRODUCTS_DISPLAY_NUM);
    }

    private static final String SQL_GET_ALL_PRODUCTS = "select ID, NAME, PRICE, TAG, UPDATETIME, USERNAME from product order by ID desc";

    public PagingList getAllProducts() {
        return getPagingList(SQL_GET_ALL_PRODUCTS);
    }

    private static final String SQL_ADD_PRODUCT = "insert into product(NAME, DESCRIPTION, PRICE, COVER, TAG, UPDATETIME, USERNAME,LINK) values(?, ?, ?, ?, ?, now(), ?,?)";

    public void addProduct(Map<String, Object> parameters, String filePath, String userName) {

        // price null pointer handling
        String price = MapUtil.getStringFromMap(parameters, "price");
        if (price == null || price.trim().equalsIgnoreCase("")) {
            price = "";
        }
        parameters.put("price", price);

        Object[] params = MapUtil.getObjectArrayFromMap(parameters,
                "name,description,price,tag,link");
        if (getProductsDisplayNum() >= 12) {
            params[3] = 0;
        }
        jt.update(SQL_ADD_PRODUCT, params[0], params[1], params[2], filePath, params[3], userName,
                params[4]);
    }

    private static final String SQL_GET_PRODUCT_BY_ID = "select * from product where ID=?";

    public Map<String, Object> getProductById(Map<String, Object> parameters) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
        return jt.queryForMap(SQL_GET_PRODUCT_BY_ID, params);
    }

    private static final String SQL_UPDATE_PRODUCT_NO_COVER = "update product set NAME=?, DESCRIPTION=?, PRICE=?, TAG=?, UPDATETIME=now(), USERNAME=?,LINK=? where ID=?";

    public void updateProduct(Map<String, Object> parameters, String userName) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters,
                "name,description,price,tag,link,id");
        if (getProductsDisplayNum() >= 12) {
            params[3] = 0;
        }
        jt.update(SQL_UPDATE_PRODUCT_NO_COVER, params[0], params[1], params[2], params[3],
                userName, params[4], params[5]);
    }

    private static final String SQL_UPDATE_PRODUCT = "update product set NAME=?, DESCRIPTION=?, PRICE=?, COVER=?, TAG=?, UPDATETIME=now(), USERNAME=?, LINK=? where ID=?";

    public void updateProduct(Map<String, Object> parameters, String filePath, String userName) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters,
                "name,description,price,tag,link,id");
        jt.update(SQL_UPDATE_PRODUCT, params[0], params[1], params[2], filePath, params[3],
                userName, params[4], params[5]);
    }

    private static final String SQL_DELETE_PRODUCT_TOUR_BY_PRODUCT_ID = "delete from product_tour where PRODUCT_ID=?";

    private static final String SQL_DELETE_PRODUCT_BY_ID = "delete from product where ID=?";

    public void deleteProductById(Map<String, Object> parameters) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
        jt.update(SQL_DELETE_PRODUCT_TOUR_BY_PRODUCT_ID, params);
        jt.update(SQL_DELETE_PRODUCT_BY_ID, params);
    }

    private static final String SQL_GET_PRODUCT_TOUR = "select * from product_tour where PRODUCT_ID=?";

    public List<Map<String, Object>> getProductTourByProductId(Map<String, Object> parameters) {
        Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
        return jt.queryForList(SQL_GET_PRODUCT_TOUR, params);
    }

    private static final String SQL_ADD_PRODUCT_TOUR = "insert into product_tour(PRODUCT_ID, TOUR_ID) values(?,?)";

    public void addProductTour(Map<String, Object> parameters) {
        final String pid = MapUtil.getStringFromMap(parameters, "id");
        final String[] tourIds = (String[])parameters.get("tourIds");
        // 删除已有关联
        jt.update(SQL_DELETE_PRODUCT_TOUR_BY_PRODUCT_ID, pid);
        // 批量设置新的关联
        jt.batchUpdate(SQL_ADD_PRODUCT_TOUR, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setObject(1, pid);
                ps.setObject(2, tourIds[i]);
            }

            public int getBatchSize() {
                return tourIds.length;
            }
        });
    }
}
