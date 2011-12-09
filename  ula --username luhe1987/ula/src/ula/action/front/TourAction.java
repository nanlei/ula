package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.BaseAction;
import ula.common.Anonymous;

public class TourAction extends BaseAction implements Anonymous {
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
