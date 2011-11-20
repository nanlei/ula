package ula.service.admin;

import ula.common.PagingList;
import ula.service.BaseService;

public class WeatherService extends BaseService {
	public static final String SQL_GET_ALL_WEATHERS = "select * from weather";

	public PagingList getAllWeather() {
		return getPagingList(SQL_GET_ALL_WEATHERS);
	}
}
