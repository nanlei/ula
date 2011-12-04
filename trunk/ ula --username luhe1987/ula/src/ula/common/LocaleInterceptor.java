package ula.common;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

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

	private Logger log = Logger.getLogger(getClass());

	public void destroy() {
	}

	public void init() {
		log.debug("Default Locale: " + Locale.getDefault());
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
