package ula.service;

import java.util.Map;

import ula.common.PagingList;

public class SettingService extends BaseService {
	private static final String SQL_DELETE_BY_ID = "DELETE FROM interface "
		+ "WHERE Id =?";
private static final String SQL_GET_ALL = "select * " + "FROM " + " interface";

private static final String SQL_ADD_INFO = "INSERT INTO " +
		"interface(CN,RU,TAG) " +
		"VALUES(?,?,?)";

private static final String SQL_GET_INFO_BY_ID = "select * " + "from interface "
		+ "where id =?";
private static final String SQL_UPDATE_INFO = "UPDATE interface "
		+ "SET CN = ?, RU =?, TAG=? "
		+ "WHERE id = ?";

public Map<String, Object> getInfoById(String id) throws Exception {
	return DB.queryForMap(SQL_GET_INFO_BY_ID, new Object[] { id });
}

public int addInfo(String lang_CN, String lang_RU, String langTAG) throws Exception {
	return DB.update(SQL_ADD_INFO, new Object[] { lang_CN, lang_RU, langTAG });
}



public PagingList getAllInfo() {
	return super.getPagingList(SQL_GET_ALL);
}

public int deleteInfoById(String id) throws Exception {
	return DB.update(SQL_DELETE_BY_ID, new Object[] { id });
}

public int updateInfo(String langCN, String langRU, String langTAG, String id) {
	return DB.update(SQL_UPDATE_INFO, new Object[] { langCN, langRU, langTAG, id });
}
}
