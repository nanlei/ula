package ula.quartz.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ula.quartz.service.SendResourceService;

/**
 * 向订阅用户发送资源任务
 * 
 * @author Nanlei
 * 
 */
public class SendResourceJob {
	private static final Logger logger = LoggerFactory
			.getLogger(SendResourceJob.class);
	private SendResourceService sendResourceService;

	public void setSendResourceService(SendResourceService sendResourceService) {
		this.sendResourceService = sendResourceService;
	}

	public void execute() {
		logger.info("Run Quartz Job : " + this.getClass().getName());
		sendResourceService.sendResource();
	}

}
