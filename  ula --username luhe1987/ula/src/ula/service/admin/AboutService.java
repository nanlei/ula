package ula.service.admin;

import java.util.List;
import java.util.Map;

import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 关于我们
 * 
 * @author Nanlei
 * 
 */
public class AboutService extends BaseService {
	private static final String SQL_GET_ALL_ABOUT = "select ID, TITLE, TYPE, AUTHOR, DATE from aboutinfo";

	public List<Map<String, Object>> getAllAbout() {
		return jt.queryForList(SQL_GET_ALL_ABOUT);
	}

	private static final String SQL_GET_ABOUT_BY_ID = "select * from aboutinfo where ID=?";

	public Map<String, Object> getAboutById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_ABOUT_BY_ID, params);
	}

	private static final String SQL_UPDATE_ABOUT_BY_ID = "update aboutinfo set TITLE=?, CONTENT=?, DATE=now(), AUTHOR=? where ID=?";

	public void updateAboutById(Map<String, Object> parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,id");
		jt.update(SQL_UPDATE_ABOUT_BY_ID, params[0], params[1], userName,
				params[2]);
	}
}
