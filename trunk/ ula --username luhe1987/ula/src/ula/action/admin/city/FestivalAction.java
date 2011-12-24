package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 大连节日
 * 
 * @author Harry
 * 
 */
public class FestivalAction extends CommonAction {
	private PagingList festivalList;
	private Map<String, Object> festivalInfo;
	private String articleId;
	private String at;
	private PagingList articleList;

	public PagingList getFestivalList() {
		return festivalList;
	}

	public Map<String, Object> getFestivalInfo() {
		return festivalInfo;
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

	public PagingList getArticleList() {
		return articleList;
	}

	/**
	 * 大连节日首页
	 * 
	 * @return
	 */
	public String festival() {
		festivalList = getServiceManager().getArticleService()
				.getFestivalArticles();
		return "festival";
	}

	/**
	 * 添加大连节日
	 * 
	 * @return
	 */
	public String addFestival() {
		try {
			getServiceManager().getArticleService().addFestival(
					getParametersAsMap(), "admin");
			this.setAlertMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.ARTICLE_ADD_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 查找大连节日文章供修改
	 * 
	 * @return
	 */
	public String preUpdateFestival() {
		festivalInfo = getServiceManager().getArticleService().getArticleById(
				getParametersAsMap());
		return "preUpdateFestival";
	}

	/**
	 * 修改大连节日文章
	 * 
	 * @return
	 */
	public String updateFestival() {
		try {
			getServiceManager().getArticleService().updateArticleById(
					getParametersAsMap(), articleId);
			this.setAlertMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 删除大连节日文章
	 * 
	 * @return
	 */
	public String deleteFestival() {
		try {
			getServiceManager().getArticleService()
					.deleteArticleById(null);
			this.setAlertMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.ARTICLE_DELETE_FAILURE);
			return ERROR;
		}
	}

	public String view() {
		super.view();
		this.setAt("festival");
		articleList = getServiceManager().getArticleService()
				.getFestivalArticles();
		return "view";
	}
}
