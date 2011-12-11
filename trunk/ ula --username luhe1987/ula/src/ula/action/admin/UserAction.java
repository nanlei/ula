package ula.action.admin;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

public class UserAction extends CommonAction {
	private static final String NOT_EXISTS = "该用户不存在";// 用户不存在
	private static final String WRONG_PASS = "密码错误";// 密码错误

	private PagingList userList;
	private Map<String, Object> userInfo;
	private String userId;
	private String userName;
	private String password;
	private String errorInfo;

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

	public String getErrorInfo() {
		return errorInfo;
	}

	/**
	 * 后台登录
	 * 
	 * @return
	 */
	public String loginAdmin() {
		Map<String, Object> dbUser = getServiceManager().getUserService()
				.getUserByUserName(userName);
		if (dbUser != null && password.equals(dbUser.get("PASSWORD"))) {
			getHttpSessionAsMap().clear();
			getHttpSessionAsMap().put(CommonConstants.LOGIN_USER, dbUser);
			return "loginAdmin";
		}
		// 以下是登录不成功的情况
		if (dbUser == null) {
			errorInfo = NOT_EXISTS;
			return ERROR;
		}
		if (!password.equals((String) dbUser.get("PASSWORD"))) {
			errorInfo = WRONG_PASS;
			return ERROR;
		}
		return ERROR;
	}

	/**
	 * 后台退出
	 * 
	 * @return
	 */
	public String logoutAdmin() {
		getHttpServletRequest().getSession().removeAttribute(
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
				setAlertMessage(AlertMessage.USER_DELETE_SUCCESS);
				return SUCCESS;
			} else {
				setAlertMessage(AlertMessage.USER_DELETE_DENY);
				return ERROR;
			}
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
			setAlertMessage(AlertMessage.USER_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.USER_UPDATE_FAILURE);
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
			setAlertMessage(AlertMessage.USER_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.USER_ADD_FAILURE);
			return ERROR;
		}
	}
}
