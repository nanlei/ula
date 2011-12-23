package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;

public class LinkService extends BaseService {
	private static final String SQL_DELETE_BY_ID = "DELETE FROM link WHERE Id =?";

	private static final String SQL_GET_ALL = "select * FROM link";

	private static final String SQL_ADD_INFO = "INSERT INTO link(title,url,date) VALUES(?,?,now())";

	private static final String SQL_GET_INFO_BY_ID = "select * from link where id =?";

	private static final String SQL_UPDATE_INFO = "UPDATE link SET title = ?,url =?,date =now() WHERE id = ?";

	public Map<String, Object> getInfoById(String id) throws Exception {
		return jt.queryForMap(SQL_GET_INFO_BY_ID, id);
	}

	public int addInfo(String title, String url) throws Exception {
		return jt.update(SQL_ADD_INFO, title, url);
	}

	public int updateInfo(String linkID, String title, String url)
			throws Exception {
		return jt.update(SQL_UPDATE_INFO, title, url, linkID);
	}

	public PagingList getAllInfo() {
		return super.getPagingList(SQL_GET_ALL);
	}

	public int deleteInfoById(String linkID) throws Exception {
		return jt.update(SQL_DELETE_BY_ID, linkID);
	}
}
