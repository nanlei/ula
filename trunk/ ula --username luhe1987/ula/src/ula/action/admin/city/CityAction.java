package ula.action.admin.city;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.constant.AlertMessage;

/**
 * 关于大连
 * 
 * @author Nanlei
 * 
 */
public class CityAction extends BaseAction {
	private List<Map<String, Object>> cityList;
	private Map<String, Object> city;

	public List<Map<String, Object>> getCityList() {
		return cityList;
	}

	public Map<String, Object> getCity() {
		return city;
	}

	public String cityAdmin() throws Exception {
		cityList = getServiceManager().getCityServcie().getAllCity();
		return "cityAdmin";
	}

	public String preUpdate() throws Exception {
		city = getServiceManager().getCityServcie().getCityById(
				getParametersAsMap());
		return "preUpdate";
	}

	public String update() {
		try {
			getServiceManager().getCityServcie().updateCityInfoByTag(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.CITY_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.cITY_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
