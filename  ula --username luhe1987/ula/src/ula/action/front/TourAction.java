package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;

public class TourAction extends AnonymousAction {
	private List<Map<String, Object>> recommendList;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	public String tour() throws Exception {
		recommendList = getServiceManager().getRecommendService()
				.getRecommendListForIndexPage();
		return SUCCESS;
	}
}
