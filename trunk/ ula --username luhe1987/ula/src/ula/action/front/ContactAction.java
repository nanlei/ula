package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;
import ula.constant.CommonConstants;

/**
 * 联系我们
 * 
 * @author Nanlei
 * 
 */
public class ContactAction extends AnonymousAction {
	private List<Map<String, Object>> recommendList;
	private List<Map<String, Object>> linkList;
	private Map<String, Object> weather;

	private Map<String, Object> contact;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	public List<Map<String, Object>> getLinkList() {
		return linkList;
	}

	public Map<String, Object> getWeather() {
		return weather;
	}

	public Map<String, Object> getContact() {
		return contact;
	}

	private void baseInfo() throws Exception {
		weather = getServiceManager().getIndexService().getWeather();
		recommendList = getServiceManager().getIndexService()
				.getRecommendList();
		linkList = getServiceManager().getIndexService().getLinkList();
	}

	/**
	 * 俄罗斯客户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String russian() throws Exception {
		contact = getServiceManager().getFrontService().getContactByTag(
				CommonConstants.TAG_CONTACT_RUSSIAN);
		baseInfo();
		return "russian";
	}

	/**
	 * 中国客户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String chinese() throws Exception {
		contact = getServiceManager().getFrontService().getContactByTag(
				CommonConstants.TAG_CONTACT_CHINESE);
		baseInfo();
		return "chinese";
	}

	/**
	 * 个人客户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String guest() throws Exception {
		contact = getServiceManager().getFrontService().getContactByTag(
				CommonConstants.TAG_CONTACT_GUEST);
		baseInfo();
		return "guest";
	}
}
