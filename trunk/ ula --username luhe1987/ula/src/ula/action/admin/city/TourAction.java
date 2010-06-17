package ula.action.admin.city;

import ula.action.CommonAction;
import ula.common.PagingList;

/**
 * 大连观光（景点，公园）
 * 
 * @author Harry
 * 
 */
public class TourAction extends CommonAction {
	private String type;// 栏目类别
	private PagingList articleList;

	public void setType(String type) {
		this.type = type;
	}

	public PagingList getArticleList() {
		return articleList;
	}

	/**
	 * 大连/旅顺/开发区首页
	 * 
	 * @return
	 */
	public String tour() {
		if ("dalian".equals(type)) {
			return "dalian";
		} else if ("lvshun".equals(type)) {
			return "lvshun";
		} else {
			return "devzone";
		}
	}
}
