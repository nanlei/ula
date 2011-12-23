package ula.quartz.job;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ula.quartz.service.WeatherUpdateService;

/**
 * 天气预报更新任务
 * 
 * @author Nanlei
 * 
 */
public class WeatherUpdateJob {
	private static final Logger logger = LoggerFactory
			.getLogger(WeatherUpdateJob.class);
	private WeatherUpdateService weatherUpdateService;

	public void setWeatherUpdateService(
			WeatherUpdateService weatherUpdateService) {
		this.weatherUpdateService = weatherUpdateService;
	}

	public void execute() {
		logger.info("Run Quartz Job : " + this.getClass().getName());
		try {
			weatherUpdateService.updateWeather();
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
	}
}
