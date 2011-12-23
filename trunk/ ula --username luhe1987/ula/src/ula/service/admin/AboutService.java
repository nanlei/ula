package ula.service.admin;

import java.util.Map;

import ula.service.BaseService;

public class AboutService extends BaseService {
	private static final String SQL_ADD_INFO = "INSERT INTO "
			+ "aboutinfo(id,title,content,date) "
			+ "VALUES(?,?,?,(SELECT sysdate() FROM DUAL))";

	private static final String SQL_GET_INFO = "SELECT * " + "FROM aboutinfo "
			+ "WHERE id =?";

	private static final String SQL_UPDATE_INFO = "UPDATE aboutinfo "
			+ "SET title = ?,content =?,date = (SELECT SYSDATE()FROM dual)"
			+ "WHERE id = ?";

	public Map<String, Object> getBizInfo() throws Exception {
		return jt.queryForMap(SQL_GET_INFO, 2);
	}

	public int updateBizInfo(String title, String content) throws Exception {
		return jt.update(SQL_UPDATE_INFO, title, content, 2);
	}

	public Map<String, Object> getCompanyInfo() throws Exception {
		return jt.queryForMap(SQL_GET_INFO, 1);
	}

	public int updateCompanyInfo(String title, String content) throws Exception {
		return jt.update(SQL_UPDATE_INFO, title, content, 1);
	}

	public Map<String, Object> getTeamInfo() {
		return jt.queryForMap(SQL_GET_INFO, 3);
	}

	public int updateTeamInfo(String title, String content) {
		return jt.update(SQL_UPDATE_INFO, title, content, 3);
	}

	public Map<String, Object> getMemoryInfo() {
		return jt.queryForMap(SQL_GET_INFO, 4);
	}

	public int updateMemoryInfo(String title, String content) {
		return jt.update(SQL_UPDATE_INFO, title, content, 4);
	}

	public int addCompanyInfo(String companyTitle, String companyContent)
			throws Exception {
		return jt.update(SQL_ADD_INFO, 1, companyTitle, companyContent);
	}

	public int addBizInfo(String bizTitle, String bizContent) {
		return jt.update(SQL_ADD_INFO, 2, bizTitle, bizContent);
	}

	public int addTeamInfo(String teamTitle, String teamContent) {
		return jt.update(SQL_ADD_INFO, 3, teamTitle, teamContent);
	}

	public int addMemoryInfo(String memoryTitle, String memoryContent) {
		return jt.update(SQL_ADD_INFO, 4, memoryTitle, memoryContent);
	}

	public Map<String, Object> getInfo(int id) throws Exception {
		return jt.queryForMap(SQL_GET_INFO, id);
	}
}
