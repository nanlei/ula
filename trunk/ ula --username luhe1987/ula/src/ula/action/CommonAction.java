package ula.action;

/**
 * 在BaseAction的基础上添加
 * 1. 操作结果提醒 alertMessage
 * 2. 错误提示 errorMessage
 * 3. 重定向URL
 * 
 * @author Harry
 *
 */
public class CommonAction extends BaseAction {
	
	private String alertMessage="";
	private String errorMessage="";
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
		this.alertMessage = alertMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setRedirctURL(String redirctURL) {
		this.redirctURL = redirctURL;
	}
	
}
