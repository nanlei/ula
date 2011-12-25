package ula.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.constant.AlertMessage;

/**
 * 特色服务管理
 * 
 * @author Nanlei
 * 
 */
public class SpecialAction extends BaseAction {
	private List<Map<String, Object>> specialList;
	private Map<String, Object> special;

	public List<Map<String, Object>> getSpecialList() {
		return specialList;
	}

	public Map<String, Object> getSpecial() {
		return special;
	}

	public String specialAdmin() throws Exception {
		specialList = getServiceManager().getSpecialService().getAllSpecial();
		return "specialAdmin";
	}

	public String preUpdate() throws Exception {
		special = getServiceManager().getSpecialService().getSpecialById(
				getParametersAsMap());
		return "preUpdate";
	}

	public String update() {
		try {
			getServiceManager().getSpecialService().updateSpecialById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_SPECIAL);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

}
