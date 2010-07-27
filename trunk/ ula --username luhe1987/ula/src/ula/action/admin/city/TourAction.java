package ula.action.admin.city;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

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
	private Map articleInfo;
	private String articleId;
	private String at;

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

	public Map getArticleInfo() {
		return articleInfo;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
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

	/**
	 * 文章信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpdateTour() throws Exception {
		articleInfo = getServiceManager().getArticleService().getArticleById(
				articleId);
		return "preUpdateTour";
	}

	/**
	 * 更新文章信息
	 * 
	 * @return
	 */
	public String updateTour() {
		try {
			getServiceManager().getArticleService().updateTourById(
					getParametersAsMap(), articleId);
			this.setAlertMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	/**
	 * 删除文章
	 * 
	 * @return
	 */
	public String deleteTour() {
		try {
			getServiceManager().getArticleService()
					.deleteArticleById(articleId);
			this.setAlertMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String view() {
		super.view();
		articleList = getServiceManager().getArticleService()
				.getToursByType(at);
		return "view";
	}
}
