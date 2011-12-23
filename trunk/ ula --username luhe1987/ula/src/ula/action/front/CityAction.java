package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;
import ula.constant.CommonConstants;

/**
 * 前台-关于大连
 * 
 * @author Nanlei
 * 
 */
public class CityAction extends AnonymousAction {
	private List<Map<String, Object>> recommendList;
	private Map<String, Object> city;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	public Map<String, Object> getCity() {
		return city;
	}

	/**
	 * 关于大连首页
	 * 
	 * @return
	 */
	public String city() throws Exception {
		recommendList = getServiceManager().getIndexService()
				.getRecommendList();
		return SUCCESS;
	}

	public String intro() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_INTRODUCTION);
		return "intro";
	}
}
