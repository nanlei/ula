package ula.common;

import org.apache.struts2.ServletActionContext;

import ula.constant.CommonConstants;
import ula.util.QueryUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 登录拦截器
 * 
 * @author Nanlei
 * 
 */
public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取当前的Action类的实例
		Action action = (Action) invocation.getAction();
		// 获取当前操作的方法名
		String actionName = invocation.getInvocationContext().getName();
		// 这里要求实现了Anonymous接口的Action以及固定的login/logoutAction可以跳过登录拦截
		if (action instanceof Anonymous || "login".equals(actionName)
				|| "logout".equals(actionName)) {
			// 放行当前操作
			return invocation.invoke();
		} else {
			// 用户的Session存在，即用户已经登录
			if (ActionContext.getContext().getSession().get(
					CommonConstants.LOGIN_USER) != null) {
				// 放行当前操作
				return invocation.invoke();
			}
		}
		// 拦截用户操作，返回登录页面
		ActionContext.getContext().getSession().put(
				CommonConstants.ORIGINAL_URL,
				QueryUtil.getRequestURL(ServletActionContext.getRequest()));
		return Action.LOGIN;
	}

}