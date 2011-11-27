package ula.action.admin;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 订阅资源管理
 * 
 * @author Nanlei
 * 
 */
public class ResourceAction extends CommonAction {
	private PagingList resourceList;
	private Map<String, Object> resource;

	public PagingList getResourceList() {
		return resourceList;
	}

	public Map<String, Object> getResource() {
		return resource;
	}

	public String resourceAdmin() throws Exception {
		resourceList = getServiceManager().getResourceService()
				.getAllResource();
		return "resourceAdmin";
	}

	public String add() {
		try {
			getServiceManager().getResourceService().addResource(
					getParametersAsMap(), getLoginUserName());
			setAlertMessage(AlertMessage.RESOURCE_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.RESOURCE_ADD_FAILURE);
			return ERROR;
		}
	}

	public String preUpdate() throws Exception {
		resource = getServiceManager().getResourceService().getResourceById(
				getParametersAsMap());
		return "preUpdate";
	}

	public String update() {
		try {
			getServiceManager().getResourceService().updateResourceById(
					getParametersAsMap(), getLoginUserName());
			setAlertMessage(AlertMessage.RESOURCE_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.RESOURCE_UPDATE_FAILURE);
			return ERROR;
		}
	}

	public String delete() {
		try {
			getServiceManager().getResourceService().deleteResourceById(
					getParametersAsMap());
			setAlertMessage(AlertMessage.RESOURCE_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.RESOURCE_DELETE_FAILURE);
			return ERROR;
		}
	}
}
