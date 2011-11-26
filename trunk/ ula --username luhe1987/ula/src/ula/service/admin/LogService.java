package ula.service.admin;

import java.util.Map;

import ula.service.BaseService;

public class LogService extends BaseService {
	private static final String SQL_LOGIN = "SELECT * FROM user WHERE username=? AND password =?";

	public Map<String, Object> logIn(String userName, String password) {
		return DB.queryForMap(SQL_LOGIN, userName, password);
	}

}
