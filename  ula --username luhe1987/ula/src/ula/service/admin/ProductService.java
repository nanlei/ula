package ula.service.admin;

import ula.common.PagingList;
import ula.service.BaseService;

/**
 * 产品功能service
 * 
 * @author Nanlei
 * 
 */
public class ProductService extends BaseService {
	private static final String SQL_GET_ALL_PRODUCTS = "select ID, NAME, PRICE, UPDATETIME, USERNAME from product";

	public PagingList getAllProducts() {
		return getPagingList(SQL_GET_ALL_PRODUCTS);
	}
	
}
