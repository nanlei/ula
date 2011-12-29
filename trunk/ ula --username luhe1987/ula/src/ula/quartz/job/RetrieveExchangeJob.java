package ula.quartz.job;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ula.quartz.service.RetrieveExchangeService;

/**
 * 获取汇率并保存到数据库任务
 * 
 * @author Nanlei
 * 
 */
public class RetrieveExchangeJob {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private RetrieveExchangeService retrieveExchangeService;

	public void setRetrieveExchangeService(
			RetrieveExchangeService retrieveExchangeService) {
		this.retrieveExchangeService = retrieveExchangeService;
	}

	public void execute() {
		logger.info("Run Quartz Job : " + this.getClass().getName());
		try {
			retrieveExchangeService.retrieveExchange();
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
	}
}
