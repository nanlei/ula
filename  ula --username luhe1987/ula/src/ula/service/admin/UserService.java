package ula.service.admin;

import ula.common.PagingList;
import ula.service.BaseService;

public class UserService extends BaseService {
	private static final String SQL_GET_ALL_USERS = "select * from user";

	public PagingList getAllUser() {
		return getPagingList(SQL_GET_ALL_USERS);
	}

	private static final String SQL_DEL_USER_BY_ID = "delete from user where USERID=?";

	public void deleteUserById(String userId) {
		DB.update(SQL_DEL_USER_BY_ID, new Object[] { userId });
	}
}
