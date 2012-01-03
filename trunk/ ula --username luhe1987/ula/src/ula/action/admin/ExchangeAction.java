package ula.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.constant.AlertMessage;

/**
 * 汇率管理
 * 
 * @author Nanlei
 * 
 */
public class ExchangeAction extends BaseAction {
	private List<Map<String, Object>> exchangeList;
	private int displayCount;

	public List<Map<String, Object>> getExchangeList() {
		return exchangeList;
	}

	public int getDisplayCount() {
		return displayCount;
	}

	public String exchangeAdmin() {
		exchangeList = getServiceManager().getExchangeService()
				.getAllExchangeRate();
		displayCount = getServiceManager().getExchangeService()
				.getDisplayCount();
		return "exchangeAdmin";
	}

	public String display() {
		try {
			getServiceManager().getExchangeService().updateTagById(
					getParametersAsMap(), 1);
			setResult(SUCCESS);
			addMessage(AlertMessage.UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_EXCHANGE);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	public String cancelDisplay() {
		try {
			getServiceManager().getExchangeService().updateTagById(
					getParametersAsMap(), 0);
			setResult(SUCCESS);
			addMessage(AlertMessage.UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_EXCHANGE);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
