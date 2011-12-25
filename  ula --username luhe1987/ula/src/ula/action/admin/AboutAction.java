package ula.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.constant.AlertMessage;

/**
 * 关于我们
 * 
 * @author Nanlei
 * 
 */
public class AboutAction extends BaseAction {
	private List<Map<String, Object>> aboutList;
	private Map<String, Object> about;

	public List<Map<String, Object>> getAboutList() {
		return aboutList;
	}

	public Map<String, Object> getAbout() {
		return about;
	}

	public String aboutAdmin() throws Exception {
		aboutList = getServiceManager().getAboutService().getAllAbout();
		return "aboutAdmin";
	}

	public String preUpdate() throws Exception {
		about = getServiceManager().getAboutService().getAboutById(
				getParametersAsMap());
		return "preUpdate";
	}

	public String update() {
		try {
			getServiceManager().getAboutService().updateAboutById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_ABOUT);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

}
