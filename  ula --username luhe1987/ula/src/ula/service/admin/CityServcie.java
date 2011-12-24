package ula.service.admin;

import java.util.List;
import java.util.Map;

import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 关于大连
 * 
 * @author Nanlei
 * 
 */
public class CityServcie extends BaseService {
	private static final String SQL_GET_ALL_CITY = "select ID, TITLE, TAG, USERNAME, DATE from city";

	public List<Map<String, Object>> getAllCity() {
		return jt.queryForList(SQL_GET_ALL_CITY);
	}

	private static final String SQL_GET_CITY_BY_ID = "select * from city where ID=?";

	public Map<String, Object> getCityById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_CITY_BY_ID, params);
	}

	private static final String SQL_UPDATE_CITY_BY_TAG = "update city set TITLE=?, CONTENT=?, USERNAME=?, DATE=now() WHERE ID=?";

	public void updateCityInfoByTag(Map<String, Object> parameters,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,id");
		jt.update(SQL_UPDATE_CITY_BY_TAG, params[0], params[1], userName,
				params[2]);
	}
}
