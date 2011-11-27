package ula.action.admin;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts2.ServletActionContext;

import ula.action.FrameworkAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

public class UserAction extends FrameworkAction {
	private PagingList userList;
	private Map<String, Object> userInfo;
	private String userId;
	private String userName;
	private String password;

	public PagingList getUserList() {
		return userList;
	}

	public Map<String, Object> getUserInfo() {
		return userInfo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String loginAdmin() {
		Map<String, Object> dbUser = getServiceManager().getUserService()
				.getUserByUserName(userName);
		if (dbUser != null && password.equals(dbUser.get("PASSWORD"))) {
			ServletActionContext.getRequest().getSession().invalidate();
			ServletActionContext.getRequest().getSession().setAttribute(
					CommonConstants.LOGIN_USER, dbUser);
			return "loginAdmin";
		} else {
			return LOGIN;
		}
	}

	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute(
				CommonConstants.LOGIN_USER);
		return "logout";
	}

	/**
	 * 用户列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		userList = getServiceManager().getUserService().getAllUser();
		return "list";
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String deleteUser() {
		try {
			if (!"1".equals(userId)) {
				getServiceManager().getUserService().deleteUserById(userId);
				this.setAlertMessage(AlertMessage.USER_DELETE_SUCCESS);
			} else {
				this.setAlertMessage(AlertMessage.USER_DELETE_DENY);
			}
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.USER_DELETE_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 读取用户信息供更新
	 * 
	 * @return
	 */
	public String preUpdateUser() {
		userInfo = getServiceManager().getUserService().getUserInfoById(userId);
		return "preUpdateUser";
	}

	/**
	 * 更新用户信息
	 * 
	 * @return
	 */
	public String updateUser() {
		try {
			getServiceManager().getUserService().updateUserById(
					getParametersAsMap());
			this.setAlertMessage(AlertMessage.USER_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.USER_UPDATE_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	public String addUser() {
		try {
			getServiceManager().getUserService().addUser(getParametersAsMap());
			this.setAlertMessage(AlertMessage.USER_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.USER_ADD_FAILURE);
			return ERROR;
		}
	}
}
