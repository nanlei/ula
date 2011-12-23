package ula.service.front;

import java.util.Map;

import ula.service.BaseService;

public class FrontService extends BaseService {
	private static final String SQL_GET_CITY_INFO_BY_TAG = "select * from city where TAG=?";

	public Map<String, Object> getCityInfoByTag(String tag) {
		return jt.queryForMap(SQL_GET_CITY_INFO_BY_TAG, tag);
	}
}
