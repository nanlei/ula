package ula.action.admin.log;

import java.util.Map;

import ula.action.CommonAction;
import ula.constant.ErrorConstants;
import ula.util.StringUtil;

public class Log extends CommonAction {
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
//		获取参数
		String username = this.getHttpServletRequest().getParameter("username");
		String password = this.getHttpServletRequest().getParameter("password");
		
//		log
		String debugMsg = "username:"+ username+", password:"+password;
		this.debug(debugMsg);
		
//		检查参数都不为空
		if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
			this.setErrorMessage(ErrorConstants.USERNAME_PASSWORD_EMPTY);
			return ERROR;
		}
		
		Map<String,Object> userInfo = this.getServiceManager().getLogService().logIn(username,password);
		
		if(userInfo.isEmpty()){
			this.setErrorMessage(ErrorConstants.INVALID_USERACCOUNT);
			return ERROR;
		}

		this.getHttpSessionAsMap().put("userInfo", userInfo);
		
//		log
		this.debug(userInfo.toString());
		
		return SUCCESS;		
	}
	
	/**
	 * 用户登出
	 * @return
	 */
	public String logout(){
		
		this.getHttpSessionAsMap().remove("userInfo");
		return REDIRECT;	
	}
	
}
