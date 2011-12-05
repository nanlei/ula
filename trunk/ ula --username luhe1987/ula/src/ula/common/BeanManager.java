package ula.common;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ula.constant.ErrorConstants;

public class BeanManager {
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
			logger.info("BeanManager init finished successfully.");
		} else {
			logger.error(ErrorConstants.WAC_IS_NULL);
		}
	}

	public static Object getBean(String beanName) {
		if (wac != null)
			return wac.getBean(beanName);
		else {
			logger.error(ErrorConstants.WAC_IS_NULL);
			return null;
		}
	}

	public static void refresh() {
		((AbstractApplicationContext) wac).refresh();
	}

}
