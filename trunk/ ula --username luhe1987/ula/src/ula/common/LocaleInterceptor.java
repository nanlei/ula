package ula.common;

import java.util.Locale;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 本地化拦截器，设置显示语言
 * 
 * @author Nanlei
 * 
 */
public class LocaleInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public void destroy() {
	}

	public void init() {
		logger.debug("Default Locale: " + Locale.getDefault());
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Locale locale_request = ServletActionContext.getRequest().getLocale();
		Locale locale_session = (Locale) ActionContext.getContext()
				.getSession().get("locale_session");
		if (locale_session == null) {
			ActionContext.getContext().setLocale(locale_request);
		} else {
			ActionContext.getContext().setLocale(locale_session);
		}
		return invocation.invoke();
	}
}
