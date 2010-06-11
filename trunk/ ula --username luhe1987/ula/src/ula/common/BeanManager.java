package ula.common;

import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ula.constant.ErrorConstants;


public class BeanManager {
	protected static final Log log;
	private static WebApplicationContext wac;

	static {
		log = LogFactory.getLog(ula.common.BeanManager.class);
	}

	public BeanManager() {
	}

	public static void init(ServletContext context) {
		wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		if (wac != null) {
			log.info("BeanManager init finished successfully.");
		} else {
			log.error(ErrorConstants.WAC_IS_NULL);
		}
	}

	public static Object getBean(String beanName) {
		log.info(wac);
		if (wac != null)
			return wac.getBean(beanName);
		else {
			log.error(ErrorConstants.WAC_IS_NULL);
			return null;
		}
	}

	public static void refresh() {
		((AbstractApplicationContext) wac).refresh();
	}

}
