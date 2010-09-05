package ula.service.admin;

import java.util.Map;

import ula.service.BaseService;

public class AboutService extends BaseService {
	private static final String SQL_ADD_INFO = "INSERT INTO " +
			"aboutinfo(id,title,content,date) " +
			"VALUES(?,?,?,(SELECT sysdate() FROM DUAL))";
	
	private static final String SQL_GET_INFO ="select * " +
			"from aboutinfo " +
			"where id =?";
	
	private static final String SQL_UPDATE_INFO ="UPDATE aboutinfo " +
			"SET title = ?,content =?,date = (SELECT SYSDATE()FROM dual)" +
			"WHERE id = ?";

	public Map<String,Object> getBizInfo() throws Exception {
		return DB.queryForMap(SQL_GET_INFO, new Object[]{2});
	}

	public int updateBizInfo(String title, String content) throws Exception{
		return DB.update(SQL_UPDATE_INFO, new Object[]{title,content,2});
	}

	public Map<String,Object> getCompanyInfo() throws Exception{
		return DB.queryForMap(SQL_GET_INFO, new Object[]{1});
	}

	public int updateCompanyInfo(String title, String content) throws Exception {
		return DB.update(SQL_UPDATE_INFO, new Object[]{title,content,1});
	}

	public Map<String, Object> getTeamInfo() {
		return DB.queryForMap(SQL_GET_INFO, new Object[]{3});
	}
	
	public int updateTeamInfo(String title, String content) {
		return DB.update(SQL_UPDATE_INFO, new Object[]{title,content,3});
	}

	public Map<String,Object> getMemoryInfo() {
		return DB.queryForMap(SQL_GET_INFO, new Object[]{4});
	}
	
	public int updateMemoryInfo(String title, String content) {
		return DB.update(SQL_UPDATE_INFO, new Object[]{title,content,4});
	}

	public int addCompanyInfo(String companyTitle, String companyContent) throws Exception {
		return DB.update(SQL_ADD_INFO, new Object[]{1,companyTitle,companyContent});
	}

	public int addBizInfo(String bizTitle, String bizContent) {
		return DB.update(SQL_ADD_INFO, new Object[]{2,bizTitle,bizContent});
	}

	public int addTeamInfo(String teamTitle, String teamContent) {
		return DB.update(SQL_ADD_INFO, new Object[]{3,teamTitle,teamContent});
	}

	public int addMemoryInfo(String memoryTitle, String memoryContent) {
		return DB.update(SQL_ADD_INFO, new Object[]{4,memoryTitle,memoryContent});
	}
	
	public Map<String,Object> getInfo(int id) throws Exception{
		return DB.queryForMap(this.SQL_GET_INFO, new Object[]{id});
	}
}
