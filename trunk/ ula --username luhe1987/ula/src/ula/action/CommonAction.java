package ula.action;

import java.util.Map;

import ula.common.PagingList;
import ula.constant.CommonConstants;

/**
 * 在BaseAction的基础上添加 1. 操作结果提醒 alertMessage 2. 错误提示 errorMessage 3. 重定向URL
 * 
 * @author Harry
 * 
 */
public class CommonAction extends BaseAction {

	private String alertMessage;
	private String errorMessage = "";
	private String redirctURL = "/";

	public String getAlertMessage() {
		return alertMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getRedirctURL() {
		return redirctURL;
	}

	public void setAlertMessage(String alertMessage) {
		getHttpServletRequest().setAttribute("alertMessage", alertMessage);
		this.alertMessage = alertMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setRedirctURL(String redirctURL) {
		this.redirctURL = redirctURL;
	}

	/**
	 * 公有的view方法，用来存放页面的公用信息 如友情链接、本月推荐标题
	 * 
	 * @return
	 */
	public String view() {
		PagingList linksFromSession = (PagingList) super.getHttpSessionAsMap()
				.get(CommonConstants.LINK);

		// 如果Session不为空，log
		if (linksFromSession != null && !linksFromSession.getList().isEmpty()) {
			super.debug("从Session读取内容：" + linksFromSession.getList());
		}

		if (linksFromSession == null || linksFromSession.getList().isEmpty()) {
			super.debug("从数据库读取 友情链接 信息");
			// 友情链接
			PagingList link = super.getServiceManager().getLinkService()
					.getAllInfo();
			// 返回给页面的是一个List对象。没有分页信息
			super.getHttpSessionAsMap().put(CommonConstants.LINK, link);
		}

		// 本月推荐
		try {
			String recomTitle = ""; // 显示在主页的本月推荐标题
			// 检查Session中是否已过期，如果可以去到信息，则session没有过期
			Map recommendation = (Map) super.getHttpSessionAsMap().get(
					CommonConstants.RECOMMENDATION);
			if (recommendation == null || recommendation.isEmpty()) {
				// 获得本月推荐的所有内容
				recommendation = super
						.getServiceManager()
						.getProgramService()
						.getInfo(
								CommonConstants.ID_PROGRAM_MONTH_RECOMMENDATION);
				// 获取title
				recomTitle = (String) recommendation.get("title");
				super.debug("推荐标题：" + recomTitle);
				// 放入Session
				super.getHttpSessionAsMap().put(CommonConstants.RECOMMENDATION,
						recomTitle);
			} else {
				super.debug("本月推荐:" + recommendation);
			}
		} catch (Exception e) {
		}
		return SUCCESS;
	}
}
