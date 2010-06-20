package ula.action.admin.city;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.MapUtil;

/**
 * 大连观光（景点，公园）
 * 
 * @author Harry
 * 
 */
public class TourAction extends CommonAction {
	private String articleType;// 栏目类别
	private PagingList articleList;
	private PagingList pictureList;

	private String title;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public PagingList getArticleList() {
		return articleList;
	}

	public PagingList getPictureList() {
		return pictureList;
	}

	/**
	 * 大连/旅顺/开发区首页
	 * 
	 * @return
	 */
	public String tour() {
		if ("dalian".equals(articleType)) {
			articleList = getServiceManager().getArticleService()
					.getToursByType("dalian");
			return "dalian";
		} else if ("lvshun".equals(articleType)) {
			articleList = getServiceManager().getArticleService()
					.getToursByType("lvshun");
			return "lvshun";
		} else {
			articleList = getServiceManager().getArticleService()
					.getToursByType("devzone");
			return "devzone";
		}
	}

	/**
	 * 选择封面图片
	 * 
	 * @return
	 */
	public String selectCoverLink() {
		pictureList = getServiceManager().getPicService().getPicsByType(
				articleType);
		return "selectCoverLink";
	}

	/**
	 * 添加文章
	 * 
	 * @return
	 */
	public String addTour() {
		try {
			getServiceManager().getArticleService().addTour(
					getParametersAsMap(), "admin");
			this.setAlertMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
