package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;
import ula.constant.CommonConstants;

/**
 * 前台-特色服务
 * 
 * @author Nanlei
 * 
 */
public class SpecialAction extends AnonymousAction {
	private List<Map<String, Object>> recommendList;
	private List<Map<String, Object>> linkList;
	private Map<String, Object> weather;

	private Map<String, Object> special;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	public List<Map<String, Object>> getLinkList() {
		return linkList;
	}

	public Map<String, Object> getWeather() {
		return weather;
	}

	public Map<String, Object> getSpecial() {
		return special;
	}

	private void baseInfo() throws Exception {
		weather = getServiceManager().getIndexService().getWeather();
		recommendList = getServiceManager().getIndexService()
				.getRecommendList();
		linkList = getServiceManager().getIndexService().getLinkList();
	}

	/**
	 * 特色服务首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String special() throws Exception {
		special = getServiceManager().getFrontService().getSpecialByTag(
				CommonConstants.TAG_SPECIAL_VISA);
		baseInfo();
		return SUCCESS;
	}

	/**
	 * 签证
	 * 
	 * @return
	 * @throws Exception
	 */
	public String visa() throws Exception {
		special = getServiceManager().getFrontService().getSpecialByTag(
				CommonConstants.TAG_SPECIAL_VISA);
		baseInfo();
		return "visa";
	}

	/**
	 * 酒店预定
	 * 
	 * @return
	 * @throws Exception
	 */
	public String hotel() throws Exception {
		baseInfo();
		return "hotel";
	}

	/**
	 * 供货者搜索
	 * 
	 * @return
	 * @throws Exception
	 */
	public String supplier() throws Exception {
		special = getServiceManager().getFrontService().getSpecialByTag(
				CommonConstants.TAG_SPECIAL_SUPPLIER);
		baseInfo();
		return "supplier";
	}

	/**
	 * 租车服务
	 * 
	 * @return
	 * @throws Exception
	 */
	public String carrental() throws Exception {
		special = getServiceManager().getFrontService().getSpecialByTag(
				CommonConstants.TAG_SPECIAL_COMMISION_CARRENTAL);
		baseInfo();
		return "carrental";
	}

	/**
	 * 订票服务
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ticketbooking() throws Exception {
		special = getServiceManager().getFrontService().getSpecialByTag(
				CommonConstants.TAG_SPECIAL_COMMISION_TICKETBOOKING);
		baseInfo();
		return "ticketbooking";
	}

	/**
	 * 翻译服务
	 * 
	 * @return
	 * @throws Exception
	 */
	public String translation() throws Exception {
		special = getServiceManager().getFrontService().getSpecialByTag(
				CommonConstants.TAG_SPECIAL_COMMISION_TRANSLATION);
		baseInfo();
		return "translation";
	}

	/**
	 * 代邮寄服务
	 * 
	 * @return
	 * @throws Exception
	 */
	public String shipping() throws Exception {
		special = getServiceManager().getFrontService().getSpecialByTag(
				CommonConstants.TAG_SPECIAL_COMMISION_SOUVENIR);
		baseInfo();
		return "shipping";
	}
}
