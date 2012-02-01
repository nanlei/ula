package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;

/**
 * 前台-搜索
 * 
 * @author Nanlei
 * 
 */
public class SearchAction extends AnonymousAction {
	private List<Map<String, Object>> recommendList;
	private List<Map<String, Object>> linkList;
	private Map<String, Object> weather;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	public List<Map<String, Object>> getLinkList() {
		return linkList;
	}

	public Map<String, Object> getWeather() {
		return weather;
	}

	private void baseInfo() throws Exception {
		weather = getServiceManager().getIndexService().getWeather();
		recommendList = getServiceManager().getIndexService()
				.getRecommendList();
		linkList = getServiceManager().getIndexService().getLinkList();
	}

	public String hotel() throws Exception {
		baseInfo();
		return "hotel";
	}

	public String tour() throws Exception {
		baseInfo();
		return "tour";
	}
}
