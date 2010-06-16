package ula.action.admin;

import ula.action.FrameworkAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

public class UserAction extends FrameworkAction {
	private PagingList userList;
	private String userId;

	public PagingList getUserList() {
		return userList;
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
}
