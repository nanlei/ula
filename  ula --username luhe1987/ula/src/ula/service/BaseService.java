package ula.service;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import ula.common.BeanManager;
import ula.common.PagingList;
import ula.common.ServiceManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ognl.OgnlValueStack;
import com.opensymphony.xwork2.util.ValueStack;


public class BaseService {
	/*
	 * 1 . 需要获得JDBC Template，因为要进行数据库查询。 2.
	 * 需要ServiceManager,因为有可能需要其他Service的结果。\ 3. 需要PagingList做分页处理 4. 需要
	 */

	protected Logger log = Logger.getLogger(getClass());

	/* 设置JDBC Template */
	protected JdbcTemplate DB;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.DB = jdbcTemplate;
	}

	public ServiceManager getServiceManager() {
		return (ServiceManager) BeanManager.getBean("serviceManager");
	}

	/**
	 * Paging
	 */
	public PagingList getPagingList(String sql, Object[] params) {
		int pageNum = ((Integer) getValueStack().findValue("pageNum"))
				.intValue();
		int pageSize = ((Integer) getValueStack().findValue("pageSize"))
				.intValue();		
		return  new PagingList(sql, params, pageNum, pageSize, DB);
	}

	/** ValueStack */
	public OgnlValueStack getValueStack() {
		return (OgnlValueStack) ActionContext.getContext().getValueStack();
	}
}
