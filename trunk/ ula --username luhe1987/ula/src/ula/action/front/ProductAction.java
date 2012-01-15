package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.BaseAction;

/**
 * 前台-产品
 * 
 * @author Nanlei
 * 
 */
public class ProductAction extends BaseAction {
	private List<Map<String, Object>> tourList;

	public List<Map<String, Object>> getTourList() {
		return tourList;
	}

	public String product() throws Exception {
		return "product";
	}
}
