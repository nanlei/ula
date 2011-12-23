package ula.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import ula.common.PagingList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class BaseService {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/* 设置JDBC Template */
	protected JdbcTemplate jt;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}

	public PagingList getPagingList(String sql) {
		int pageNum = ((Integer) getValueStack().findValue("pageNum"))
				.intValue();
		int pageSize = ((Integer) getValueStack().findValue("pageSize"))
				.intValue();
		return new PagingList(sql, pageNum, pageSize, jt);
	}

	public PagingList getPagingList(String sql, Object... params) {
		int pageNum = ((Integer) getValueStack().findValue("pageNum"))
				.intValue();
		int pageSize = ((Integer) getValueStack().findValue("pageSize"))
				.intValue();
		return new PagingList(sql, pageNum, pageSize, jt, params);
	}

	/** ValueStack */
	public ValueStack getValueStack() {
		return ActionContext.getContext().getValueStack();
	}
}
