package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;
import ula.constant.CommonConstants;

/**
 * 前台-旅游行程
 * 
 * @author Nanlei
 * 
 */
public class TourAction extends AnonymousAction {
	private List<Map<String, Object>> tourList;
	private List<Map<String, Object>> recommendList;
	private List<Map<String, Object>> linkList;
	private Map<String, Object> weather;

	public List<Map<String, Object>> getTourList() {
		return tourList;
	}

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

	/**
	 * 行程首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String tour() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_BUSINESS);
		baseInfo();
		return SUCCESS;
	}

	/**
	 * 商务行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String business() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_BUSINESS);
		baseInfo();
		return "business";
	}

	/**
	 * 夏令营行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String camping() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_CAMPING);
		baseInfo();
		return "camping";
	}

	/**
	 * 美食家行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String foodie() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_FOODIE);
		baseInfo();
		return "foodie";
	}

	/**
	 * 家庭行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String family() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_FAMILY);
		baseInfo();
		return "family";
	}

	/**
	 * 治疗行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String therapy() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_THERAPY);
		baseInfo();
		return "therapy";
	}

	/**
	 * 新年行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String newyear() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_NEWYEAR);
		baseInfo();
		return "newyear";
	}

	/**
	 * 学习行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String learn() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_LEARN);
		baseInfo();
		return "learn";
	}

	/**
	 * 浪漫行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String romantic() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_ROMANTIC);
		baseInfo();
		return "romantic";
	}

	/**
	 * 乡村行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String rural() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_RURAL);
		baseInfo();
		return "rural";
	}

	/**
	 * 事件行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String event() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_EVENT);
		baseInfo();
		return "event";
	}

	/**
	 * 运动行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sport() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_SPORT);
		baseInfo();
		return "sport";
	}

	/**
	 * 温泉行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String hotspring() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_HOTSPRING);
		baseInfo();
		return "hotspring";
	}

	/**
	 * 展会行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exhibition() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_EXHIBITION);
		baseInfo();
		return "exhibition";
	}

	/**
	 * 奢华行程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String luxurious() throws Exception {
		tourList = getServiceManager().getFrontService().getTourByCategoryTag(
				CommonConstants.TAG_TOUR_LUXURIOUS);
		baseInfo();
		return "luxurious";
	}
}
