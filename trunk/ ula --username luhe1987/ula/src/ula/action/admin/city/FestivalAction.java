package ula.action.admin.city;

import java.util.Map;

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
	private Map festivalInfo;
	private String articleId;

	public PagingList getFestivalList() {
		return festivalList;
	}

	public Map getFestivalInfo() {
		return festivalInfo;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
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
				articleId);
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
					.deleteArticleById(articleId);
			this.setAlertMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
