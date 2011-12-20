package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;

/**
 * 前台-关于大连
 * 
 * @author Nanlei
 * 
 */
public class CityAction extends AnonymousAction {
	private List<Map<String, Object>> recommendList;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	/**
	 * 关于大连首页
	 * 
	 * @return
	 */
	public String city() {
		recommendList = getServiceManager().getIndexService()
				.getRecommendList();
		return SUCCESS;
	}
}
