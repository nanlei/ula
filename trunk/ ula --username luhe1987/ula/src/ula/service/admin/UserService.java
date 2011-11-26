package ula.service.admin;

import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class UserService extends BaseService {
	private static final String SQL_GET_USER_BY_NAME = "select * from user where USERNAME=?";

	public Map<String, Object> getUserByUserName(String userName) {
		try {
			return DB.queryForMap(SQL_GET_USER_BY_NAME,
					new Object[] { userName });
		} catch (EmptyResultDataAccessException e) {// 如果用户不存在，则要抛出该异常
			return null;
		}
	}

	private static final String SQL_GET_ALL_USERS = "select * from user";

	public PagingList getAllUser() {
		return getPagingList(SQL_GET_ALL_USERS);
	}

	private static final String SQL_DEL_USER_BY_ID = "delete from user where USERID=?";

	public void deleteUserById(String userId) {
		DB.update(SQL_DEL_USER_BY_ID, new Object[] { userId });
	}

	private static final String SQL_GET_USER_BY_ID = "select * from user where USERID=?";

	public Map<String, Object> getUserInfoById(String userId) {
		return DB.queryForMap(SQL_GET_USER_BY_ID, new Object[] { userId });
	}

	private static final String SQL_SET_USER_BY_ID = "update user set REALNAME=?,PASSWORD=?,USERROLE=? where USERID=?";

	public void updateUserById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"realName,password,userRole,userId");
		DB.update(SQL_SET_USER_BY_ID, params);
	}

	private static final String SQL_ADD_USER = "insert into user(USERNAME,REALNAME,PASSWORD,USERROLE) values(?,?,?,?)";

	public void addUser(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"userName,realName,password,userRole");
		DB.update(SQL_ADD_USER, params);
	}
}
