package ula.action.admin;

import ula.action.CommonAction;
import ula.common.PagingList;

/**
 * 天气预报
 * 
 * @author Nanlei
 * 
 */
public class WeatherAction extends CommonAction {
	private PagingList weatherList;

	public PagingList getWeatherList() {
		return weatherList;
	}

	public String admin() throws Exception {
		weatherList = getServiceManager().getWeatherService().getAllWeather();
		return "admin";
	}

}
