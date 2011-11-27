package ula.quartz.job;

import org.apache.log4j.Logger;

import ula.quartz.service.SendResourceService;

/**
 * 向订阅用户发送资源任务
 * 
 * @author Nanlei
 * 
 */
public class SendResourceJob {
	private static final Logger log = Logger.getLogger(SendResourceJob.class);
	private SendResourceService sendResourceService;

	public void setSendResourceService(SendResourceService sendResourceService) {
		this.sendResourceService = sendResourceService;
	}
	
	public void execute() {
		log.info("Run Quartz Job : " + this.getClass().getName());
		sendResourceService.sendResource();
	}

}
