package ula.service.admin;

import ula.common.PagingList;
import ula.service.BaseService;

public class UserService extends BaseService {
	private static final String SQL_GET_ALL_USERS = "select * from user";

	public PagingList getAllUser() {
		return getPagingList(SQL_GET_ALL_USERS);
	}
}
