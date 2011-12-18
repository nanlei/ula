package ula.common;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ula.constant.CommonConstants;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ExceptionInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			invocation.getInvocationContext();
			return invocation.invoke();
		} catch (Exception e) {
			handleException(invocation, e);
			return CommonConstants.EXCEPTION;
		}

	}

	private void handleException(ActionInvocation invocation, Exception e) {
		String message = "Caught exception while invoking action: "
				+ invocation.getAction();
		logger.error(message, e);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		invocation.getInvocationContext().put(
				CommonConstants.CONTEXT_EXCEPTION, e.toString());
		invocation.getInvocationContext().put(
				CommonConstants.CONTEXT_EXCEPTION_INFO, sw.toString());
	}

}
