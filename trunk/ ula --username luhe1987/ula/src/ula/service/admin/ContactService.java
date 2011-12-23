package ula.service.admin;

import java.util.Map;

import ula.service.BaseService;

public class ContactService extends BaseService {
	private static final String SQL_ADD_INFO = "INSERT INTO contact(id,title,content,tag,date) VALUES(?,?,?,?,now())";

	private static final String SQL_GET_INFO_BY_ID = "select * from contact where id =?";

	private static final String SQL_UPDATE_INFO = "UPDATE contact SET title = ?,content =?,date =now() WHERE id = ?";

	public Map<String, Object> getInfo(int id) throws Exception {
		return jt.queryForMap(SQL_GET_INFO_BY_ID, id);
	}

	public Map<String, Object> getInfo(String tag) throws Exception {
		return jt.queryForMap(SQL_GET_INFO_BY_ID, tag);
	}

	public int addInfo(int id, String title, String content, String tag)
			throws Exception {
		return jt.update(SQL_ADD_INFO, id, title, content, tag);
	}

	public int addInfo(int id, String title, String content) throws Exception {
		return addInfo(id, title, content, "");
	}

	public int updateInfo(int id, String title, String content)
			throws Exception {
		return jt.update(SQL_UPDATE_INFO, title, content, id);
	}

}
