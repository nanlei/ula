
package ula.common;

import java.util.Locale;

import org.apache.commons.lang.ArrayUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 本地化拦截器，设置显示语言
 * 
 * @author Nanlei
 */
public class LocaleInterceptor implements Interceptor {
    private Locale default_locale;

    private String[] locale_languages;

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void destroy() {
    }

    public void init() {
        locale_languages = new String[] {
                "ru", "zh", "en"
        };
        default_locale = new Locale("ru");
        ActionContext.getContext().setLocale(default_locale);
        logger.debug("Default Locale: " + Locale.getDefault());
    }

    public String intercept(ActionInvocation invocation) throws Exception {
        String request_uri = ServletActionContext.getRequest().getRequestURI();
        if (request_uri.startsWith("/admin")) {
            return invocation.invoke();
        } else {
            Locale locale_request = ServletActionContext.getRequest().getLocale();
            Locale locale_session = (Locale)ActionContext.getContext().getSession()
                    .get("locale_session");
            if (locale_request == null && locale_session == null) {
                ActionContext.getContext().setLocale(default_locale);
            } else if (locale_session == null) {
                ActionContext.getContext().setLocale(default_locale);
            } else {
                ActionContext.getContext().setLocale(locale_session);
            }
            String language = ActionContext.getContext().getLocale().getLanguage();
            if (ArrayUtils.contains(locale_languages, language)) {
                return invocation.invoke();
            } else {
                return Action.LOGIN;
            }
        }
    }
}
