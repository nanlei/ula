package ula.action;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.common.Anonymous;
import ula.util.MapUtil;

/**
 * 首页请求处理Action
 * 
 * @author Nanlei
 * 
 */
public class IndexAction extends BaseAction implements Anonymous {
	private List<Map<String, Object>> recommendList;
	private Map<String, Object> weather;
	private HashMap<String, Object> jsonModel;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	public Map<String, Object> getWeather() {
		return weather;
	}

	public HashMap<String, Object> getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(HashMap<String, Object> jsonModel) {
		this.jsonModel = jsonModel;
	}

	/**
	 * 进入首页的方法
	 * 
	 * @return
	 */
	public String entry() {
		recommendList = getServiceManager().getRecommendService()
				.getRecommendListForIndexPage();
		weather = getServiceManager().getWeatherService()
				.getWeatherForIndexPage();
		return SUCCESS;
	}

	/**
	 * 订阅资源的方法
	 * 
	 * @return
	 */
	public String subscribe() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String email = MapUtil.getStringFromMap(getParametersAsMap(), "email");
		int flag = getServiceManager().getSubscriberService()
				.getCheckSubscriber(email);
		if (flag > 0) {
			// 邮件地址已经存在
			map.put("result", 2);
		} else {
			try {
				getServiceManager().getSubscriberService().addSubscriber(email,
						getIP());
				// 订阅成功
				map.put("result", 1);
			} catch (Exception e) {
				log.error(ExceptionUtils.getStackTrace(e));
				// 订阅失败
				map.put("result", 0);
			}
		}
		setJsonModel(map);
		return "subscribe";
	}

	/**
	 * 取消订阅资源的方法
	 * 
	 * @return
	 */
	public String cancelSubscribe() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String email = MapUtil.getStringFromMap(getParametersAsMap(), "email");
		int flag = getServiceManager().getSubscriberService()
				.getCheckSubscriber(email);
		if (flag > 0) {
			try {
				getServiceManager().getSubscriberService()
						.deleteSubscriberByEmail(email);
				// 取消订阅成功
				map.put("result", 1);
			} catch (Exception e) {
				log.error(ExceptionUtils.getStackTrace(e));
				// 取消订阅失败
				map.put("result", 0);
			}
		} else {
			// 邮件地址不存在
			map.put("result", 2);
		}
		setJsonModel(map);
		return "cancelSubscribe";
	}

	public String language() {
		String locale = MapUtil
				.getStringFromMap(getParametersAsMap(), "locale");
		getHttpServletRequest().getSession().setAttribute("locale_session",
				new Locale(locale));
		return SUCCESS;
	}
}
