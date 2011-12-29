package ula.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.constant.AlertMessage;

/**
 * 联系我们
 * 
 * @author Nanlei
 * 
 */
public class ContactAction extends BaseAction {
	private List<Map<String, Object>> contactList;
	private Map<String, Object> contact;

	public List<Map<String, Object>> getContactList() {
		return contactList;
	}

	public Map<String, Object> getContact() {
		return contact;
	}

	public String contactAdmin() throws Exception {
		contactList = getServiceManager().getContactService().getAllContact();
		return "contactAdmin";
	}

	public String preUpdate() throws Exception {
		contact = getServiceManager().getContactService().getContactById(
				getParametersAsMap());
		return "preUpdate";
	}

	public String update() {
		try {
			getServiceManager().getContactService().updateContactById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CONTACT);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
