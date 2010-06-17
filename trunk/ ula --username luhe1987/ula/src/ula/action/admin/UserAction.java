package ula.action.admin;

import java.util.Map;

import ula.action.FrameworkAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

public class UserAction extends FrameworkAction {
	private PagingList userList;
	private Map userInfo;
	private String userId;

	public PagingList getUserList() {
		return userList;
	}

	public Map getUserInfo() {
		return userInfo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
			return ERROR;
		}
	}
}
