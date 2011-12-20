package ula.common;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BeanManager {
	private static final String WAC_IS_NULL = "WebApplicationContext is Null!";
	private static final String INIT_SUCCESSFUL = "BeanManager Init Successfully!";

	protected static final Logger logger;
	private static WebApplicationContext wac;

	static {
		logger = LoggerFactory.getLogger(ula.common.BeanManager.class);
	}

	public BeanManager() {
	}

	public static void init(ServletContext context) {
		wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		if (wac != null) {
			logger.info(INIT_SUCCESSFUL);
		} else {
			logger.error(WAC_IS_NULL);
		}
	}

	public static Object getBean(String beanName) {
		if (wac != null)
			return wac.getBean(beanName);
		else {
			logger.error(WAC_IS_NULL);
			return null;
		}
	}

}
