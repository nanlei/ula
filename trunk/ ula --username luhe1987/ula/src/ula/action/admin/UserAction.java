package ula.action.admin;

import ula.action.FrameworkAction;
import ula.common.PagingList;

public class UserAction extends FrameworkAction {
	private PagingList userList;

	public PagingList getUserList() {
		return userList;
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
}
