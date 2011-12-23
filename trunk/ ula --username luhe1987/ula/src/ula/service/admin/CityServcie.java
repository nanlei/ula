package ula.service.admin;

import java.util.List;
import java.util.Map;

import ula.service.BaseService;
import ula.util.MapUtil;

public class CityServcie extends BaseService {
	private static final String SQL_ADD_INFO = "INSERT INTO "
			+ "city(id,title,content,tag,date) "
			+ "VALUES(?,?,?,?,(SELECT sysdate() FROM DUAL))";

	private static final String SQL_GET_INFO_BY_ID = "select * " + "from city "
			+ "where id =?";

	private static final String SQL_UPDATE_INFO = "UPDATE city "
			+ "SET title = ?,content =?,date = (SELECT SYSDATE()FROM dual)"
			+ "WHERE id = ?";

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
		return this.addInfo(id, title, content, "");
	}

	public int updateInfo(int id, String title, String content)
			throws Exception {
		return jt.update(SQL_UPDATE_INFO, title, content, id);
	}

	private static final String SQL_GET_ALL_CITY = "select ID,TITLE,TAG,DATE from city";

	public List<Map<String, Object>> getAllCity() {
		return jt.queryForList(SQL_GET_ALL_CITY);
	}

	private static final String SQL_GET_CITY_BY_ID = "select * from city where ID=?";

	public Map<String, Object> getCityById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_CITY_BY_ID, params);
	}

	private static final String SQL_UPDATE_CITY_BY_TAG = "update city set TITLE=?, CONTENT=?,DATE=now() WHERE ID=?";

	public void updateCityInfoByTag(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,id");
		jt.update(SQL_UPDATE_CITY_BY_TAG, params);
	}
}
