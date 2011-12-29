package ula.action.admin;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 友情链接管理
 * 
 * @author Nanlei
 * 
 */
public class LinkAction extends BaseAction {
	private PagingList linkList;
	private Map<String, Object> link;

	public PagingList getLinkList() {
		return linkList;
	}

	public Map<String, Object> getLink() {
		return link;
	}

	public String linkAdmin() throws Exception {
		linkList = getServiceManager().getLinkService().getAllLinks();
		return "linkAdmin";
	}

	public String preUpdate() throws Exception {
		link = getServiceManager().getLinkService().getLinkById(
				getParametersAsMap());
		return "preUpdate";
	}

	public String add() {
		try {
			getServiceManager().getLinkService().addInfo(getParametersAsMap(),
					getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.LINK_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_LINK);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.LINK_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	public String update() {
		try {
			getServiceManager().getLinkService().updateLinkById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.LINK_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_LINK);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.LINK_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	public String delete() {
		try {
			getServiceManager().getLinkService().deleteLinkById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.LINK_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_LINK);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.LINK_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
