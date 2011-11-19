package ula.quartz.job;

import org.apache.log4j.Logger;

import ula.quartz.service.WeatherUpdateService;

/**
 * 天气预报更新任务
 * 
 * @author Nanlei
 * 
 */
public class WeatherUpdateJob {
	private static final Logger log = Logger.getLogger(WeatherUpdateJob.class);
	private WeatherUpdateService weatherUpdateService;

	public void setWeatherUpdateService(
			WeatherUpdateService weatherUpdateService) {
		this.weatherUpdateService = weatherUpdateService;
	}

	public void execute() {
		log.info("Run Quartz Job : " + this.getClass().getName());
		weatherUpdateService.updateWeather();
	}
}
