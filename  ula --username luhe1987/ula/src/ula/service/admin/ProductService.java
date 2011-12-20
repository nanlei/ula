package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 产品功能service
 * 
 * @author Nanlei
 * 
 */
public class ProductService extends BaseService {
	private static final String SQL_GET_PRODUCTS_DISPLAY_NUM = "select count(*) from product where TAG=1";

	public int getProductsDisplayNum() {
		return DB.queryForInt(SQL_GET_PRODUCTS_DISPLAY_NUM);
	}

	private static final String SQL_GET_ALL_PRODUCTS = "select ID, NAME, PRICE, TAG, UPDATETIME, USERNAME from product order by ID desc";

	public PagingList getAllProducts() {
		return getPagingList(SQL_GET_ALL_PRODUCTS);
	}

	private static final String SQL_ADD_PRODUCT = "insert into product(NAME, DESCRIPTION, PRICE, COVER, TAG, UPDATETIME, USERNAME) values(?, ?, ?, ?, ?, now(), ?)";

	public void addProduct(Map<String, Object> parameters, String filePath,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"name,description,price,tag");
		if (getProductsDisplayNum() >= 12) {
			params[3] = 0;
		}
		DB.update(SQL_ADD_PRODUCT, params[0], params[1], params[2], filePath,
				params[3], userName);
	}

	private static final String SQL_GET_PRODUCT_BY_ID = "select * from product where ID=?";

	public Map<String, Object> getProductById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return DB.queryForMap(SQL_GET_PRODUCT_BY_ID, params);
	}

	private static final String SQL_UPDATE_PRODUCT_NO_COVER = "update product set NAME=?, DESCRIPTION=?, PRICE=?, TAG=?, UPDATETIME=now(), USERNAME=? where ID=?";

	public void updateProduct(Map<String, Object> parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"name,description,price,tag,id");
		if (getProductsDisplayNum() >= 12) {
			params[3] = 0;
		}
		DB.update(SQL_UPDATE_PRODUCT_NO_COVER, params[0], params[1], params[2],
				params[3], userName, params[4]);
	}

	private static final String SQL_UPDATE_PRODUCT = "update product set NAME=?, DESCRIPTION=?, PRICE=?, COVER=?, TAG=?, UPDATETIME=now(), USERNAME=? where ID=?";

	public void updateProduct(Map<String, Object> parameters, String filePath,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"name,description,price,tag,id");
		DB.update(SQL_UPDATE_PRODUCT, params[0], params[1], params[2],
				filePath, params[3], userName, params[4]);
	}

	private static final String SQL_DELETE_PRODUCT_BY_ID = "delete from product where ID=?";

	public void deleteProductById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		DB.update(SQL_DELETE_PRODUCT_BY_ID, params);
	}
}
