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

	private Map<String, Object> displayParameters;

	private List<Map<String, Object>> hotelList;
	private List<Map<String, Object>> tourList;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	public List<Map<String, Object>> getLinkList() {
		return linkList;
	}

	public Map<String, Object> getWeather() {
		return weather;
	}

	public Map<String, Object> getDisplayParameters() {
		return displayParameters;
	}

	public List<Map<String, Object>> getHotelList() {
		return hotelList;
	}

	public List<Map<String, Object>> getTourList() {
		return tourList;
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

	/**
	 * 酒店搜索
	 * 
	 * @return
	 * @throws Exception
	 */
	public String hotelSearch() throws Exception {
		displayParameters = getParametersAsMap();
		hotelList = getServiceManager().getFrontService().getSearchHotel(
				getParametersAsMap());
		baseInfo();
		return "hotelSearch";
	}

	public String tour() throws Exception {
		baseInfo();
		return "tour";
	}

	/**
	 * 行程搜索
	 * 
	 * @return
	 * @throws Exception
	 */
	public String tourSearch() throws Exception {
		displayParameters = getParametersAsMap();
		hotelList = getServiceManager().getFrontService()
				.getSearchHotelByLevel(getHttpServletRequest());
		tourList = getServiceManager().getFrontService().getSearchTour(
				getHttpServletRequest());
		baseInfo();
		return "tourSearch";
	}
}
