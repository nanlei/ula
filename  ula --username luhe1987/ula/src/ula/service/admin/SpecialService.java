package ula.service.admin;

import java.util.List;
import java.util.Map;

import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 特色服务
 * 
 * @author Nanlei
 * 
 */
public class SpecialService extends BaseService {
	private static final String SQL_GET_ALL_SPECIAL = "select ID,TITLE,TAG,USERNAME,UPDATETIME from special";

	public List<Map<String, Object>> getAllSpecial() {
		return jt.queryForList(SQL_GET_ALL_SPECIAL);
	}

	private static final String SQL_GET_SPECIAL_BY_ID = "select * from special where ID=?";

	public Map<String, Object> getSpecialById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_SPECIAL_BY_ID, params);
	}

	private static final String SQL_UPDATE_SPECIAL_BY_ID = "update special set TITLE=?,CONTENT=?,USERNAME=?,UPDATETIME=now() where ID=?";

	public void updateSpecialById(Map<String, Object> parameters,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,id");
		jt.update(SQL_UPDATE_SPECIAL_BY_ID, params[0], params[1], userName,
				params[2]);
	}

}
