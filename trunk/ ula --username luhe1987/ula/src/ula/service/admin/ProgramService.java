package ula.service.admin;

import java.util.Map;

import ula.service.BaseService;

public class ProgramService extends BaseService {
	public static final String SQL_ADD_INFO = "INSERT INTO "
		+ "program(id,title,content,tag,date) "
		+ "VALUES(?,?,?,?,(SELECT sysdate() FROM DUAL))";

public static final String SQL_GET_INFO_BY_ID = "select * "
		+ "from program " 
		+ "where id =?";

public static final String SQL_UPDATE_INFO = "UPDATE program "
		+ "SET title = ?,content =?,date = (SELECT SYSDATE()FROM dual)"
		+ "WHERE id = ?";

public Map<String, Object> getInfo(int id) throws Exception {
	return DB.queryForMap(this.SQL_GET_INFO_BY_ID, new Object[] { id });
}

public Map<String, Object> getInfo(String tag) throws Exception {
	return DB.queryForMap(this.SQL_GET_INFO_BY_ID, new Object[] { tag });
}

public int addInfo(int id, String title, String content, String tag)throws Exception {
	return DB
			.update(SQL_ADD_INFO, new Object[] { id, title, content, tag });
}

public int addInfo(int id, String title, String content)throws Exception {
	return this.addInfo(id, title, content, "");
}

public int updateInfo(int id, String title, String content)throws Exception {
	return DB.update(this.SQL_UPDATE_INFO, new Object[]{title,content,id});
}

}

