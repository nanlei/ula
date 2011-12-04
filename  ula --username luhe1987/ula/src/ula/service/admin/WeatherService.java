package ula.service.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class WeatherService extends BaseService {
	private static final String SQL_GET_ALL_WEATHERS = "select * from weather";

	public PagingList getAllWeather() {
		return getPagingList(SQL_GET_ALL_WEATHERS);
	}

	private static final String SQL_GET_WEATHER_BY_ID = "select * from weather where ID=?";

	public Map<String, Object> getWeatherById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return DB.queryForMap(SQL_GET_WEATHER_BY_ID, params);
	}

	private static final String SQL_UPDATE_WEAHTER_BY_CITYCODE = "update weather set TEMP1=?, TEMP2=?, IMG1=?, IMG2=?, IMG3=?, IMG4=?, UPDATETIME=now() where CITYCODE=?";

	public void updateWeatherByCityCode(HashMap<String, String> weatherInfo,
			String cityCode) {
		Object[] params = MapUtil.getObjectArrayFromMap(weatherInfo,
				"temp1,temp2,img1,img2,img3,img4");
		DB.update(SQL_UPDATE_WEAHTER_BY_CITYCODE, ArrayUtils.add(params,
				cityCode));
	}

	private static final String SQL_REMOVE_DEFAULT_CITY = "update weather set TAG=0";

	private static final String SQL_SET_DEFAULT_CITY = "update weather set TAG=1 where ID=?";

	public void setDefaulyCity(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		DB.update(SQL_REMOVE_DEFAULT_CITY);
		DB.update(SQL_SET_DEFAULT_CITY, params);
	}

	private static final String SQL_GET_WEATHER_FOR_INDEX_PAGE = "select * from weather where CITYCODE='101070201'";

	public Map<String, Object> getWeatherForIndexPage() {
		return DB.queryForMap(SQL_GET_WEATHER_FOR_INDEX_PAGE);
	}
}
