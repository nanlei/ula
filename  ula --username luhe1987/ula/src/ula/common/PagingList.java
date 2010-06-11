package ula.common;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import ula.constant.CommonConstants;

public class PagingList {
	
	private int rowCount = 0; // 记录总数
	private int pageCount = 1; // 分页总数
	private int pageSize = ula.constant.CommonConstants.DEFAULT_PAGE_SIZE; // 每页记录数
	private int pageNum = 1; // 当前页数
	private int startIndex = 1; // 起始记录数
	private int endIndex = 1; // 结束记录数
	private String srcSqlForCount;// 用于计算记录总量的SQL语句
	private String srcSql;// 源SQL语句
	private List list;// 记录列表

	
	public PagingList(String srcSql, Object[] params, int pageNum, int pageSize, JdbcTemplate jdbcTemplate) {
		this(getCountSql(srcSql), srcSql, params, pageNum, pageSize, jdbcTemplate);
	}

	
	public PagingList(String srcSqlForCount, String srcSql, Object[] params, int pageNum, int pageSize,
			JdbcTemplate jdbcTemplate) {
		preProcessParams(srcSqlForCount, srcSql, pageNum, pageSize);
		execute(jdbcTemplate, params);
	}

	

	/**
	 * 预处理SQL语句和页面参数
	 */
	private void preProcessParams(String srcSqlForCount, String srcSql, int pageNum, int pageSize) {
		
		this.srcSqlForCount = srcSqlForCount;
		this.srcSql = srcSql;
		
		if (pageNum > 0) {
			this.pageNum = pageNum;
		}
		
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
		if (pageSize > CommonConstants.MAX_PAGE_SIZE) {
			this.pageSize = CommonConstants.MAX_PAGE_SIZE;
		}
	}

	/**
	 * 根据给定的数据计算相关分页信息
	 */
	private void execute(JdbcTemplate jdbcTemplate, Object[] params) {
		// 计算记录总数
		this.rowCount = jdbcTemplate.queryForInt(srcSqlForCount, params);

		//计算分页数及起止记录
		countPage();

		Object[] tmp = null;
		if (params != null) {
			int pLen = params.length;
			tmp = new Object[pLen + 2];
			System.arraycopy(params, 0, tmp, 0, pLen);
				tmp[pLen] = new Integer(getStartIndex() - 1);
				tmp[pLen + 1] = new Integer(pageSize);
		
		} else {
		
				tmp = new Object[] { new Integer(getStartIndex() - 1), new Integer(pageSize) };
		}
		
		this.list = jdbcTemplate.queryForList(getPagingSql(srcSql, CommonConstants.NORMAL_MARK, CommonConstants.NORMAL_MARK), tmp);
	}

	/**
	 * 计算分页数及起止记录
	 */
	private void countPage() {
		
		// 计算分页总数
		if ((rowCount % pageSize) == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = rowCount / pageSize + 1;
		}
		
		if (pageCount == 0) {
			pageCount = 1;
		}

		// 判断pageNum是否过界
		if (pageNum > pageCount && rowCount != 0) {
			pageNum = pageCount;
		}

		// 计算起止记录
		startIndex = (pageNum - 1) * pageSize + 1;
		endIndex = (pageNum) * pageSize;
	}

	/**
	 * 获得对象列表
	 */
	public List getList() {
		return list;
	}

	/* 获得起始记录数 */
	public int getStartIndex() {
		return startIndex;
	}

	public Integer getStartIndexInteger() {
		return new Integer(startIndex);
	}

	/* 获得结束记录数 */
	public int getEndIndex() {
		return endIndex;
	}

	public Integer getEndIndexInteger() {
		return new Integer(endIndex);
	}

	/* 获得分页其它信息 */
	public int getPageCount() {
		return pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getRowCount() {
		return rowCount;
	}

	/**
	 * 将源SQL语句增加分页功能
	 */
	private static String getPagingSql(String srcSql, String startMark, String endMark) {
		StringBuffer pagingSql = new StringBuffer();
		
			pagingSql.append(srcSql);
			pagingSql.append(" LIMIT ");
			pagingSql.append(startMark);
			pagingSql.append(", ");
			pagingSql.append(endMark);
			return pagingSql.toString();
	}

	/**
	 * 将源SQL语句增加计算记录总数功能
	 */
	public static String getCountSql(String srcSql) {
		return "SELECT COUNT(*) FROM ( " + srcSql + " ) CTBL_";
	}

}