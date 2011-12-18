package ula.action.admin;

import ula.action.BaseAction;
import ula.common.PagingList;

/**
 * 产品管理Action
 * 
 * @author Nanlei
 * 
 */
public class ProductAction extends BaseAction {
	private PagingList productList;

	public PagingList getProductList() {
		return productList;
	}

	public String productAdmin() throws Exception {
		productList = getServiceManager().getProductService().getAllProducts();
		return "productAdmin";
	}
}
