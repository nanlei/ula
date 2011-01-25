package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class HotelService extends BaseService {
	private static final String GET_ALL_HOTEL_PARAMS = "select * from hotel_param order by TYPE,ID";

	public PagingList getAllHotelParams() {
		return getPagingList(GET_ALL_HOTEL_PARAMS);
	}

	private static final String ADD_HOTEL_PARAM = "insert into hotel_param(TYPE,NAME,VALUE) values(?,?,?)";

	public void addHotelParam(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"type,paramName,paramValue");
		DB.update(ADD_HOTEL_PARAM, params);
	}

	private static final String GET_HOTEL_PARAM_BY_ID = "select * from hotel_param where ID=?";

	public Map getHotelParamById(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return DB.queryForMap(GET_HOTEL_PARAM_BY_ID, params);
	}

	private static final String UPDATE_HOTEL_PARAM_BY_ID = "update hotel_param set TYPE=?, NAME=?, VALUE=? where ID=?";

	public void updateHotelParam(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"type,paramName,paramValue,id");
		DB.update(UPDATE_HOTEL_PARAM_BY_ID, params);
	}
}
