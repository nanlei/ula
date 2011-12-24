package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 展会信息
 * 
 * @author Nanlei
 * 
 */
public class ExhibitionAction extends CommonAction {
	private PagingList exhibitionList;
	private Map<String, Object> exhibitionInfo;
	private String articleId;
	private String at;
	private PagingList articleList;

	public PagingList getExhibitionList() {
		return exhibitionList;
	}

	public Map<String, Object> getExhibitionInfo() {
		return exhibitionInfo;
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
	 * 展会信息首页
	 * 
	 * @return
	 */
	public String exhibition() {
		exhibitionList = getServiceManager().getArticleService()
				.getExhibitionArticles();
		return "exhibition";
	}

	/**
	 * 添加展会信息文章
	 * 
	 * @return
	 */
	public String addExhibition() {
		try {
			getServiceManager().getArticleService().addExhibition(
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
	 * 查找展会信息文章供修改
	 * 
	 * @return
	 */
	public String preUpdateExhibition() {
		exhibitionInfo = getServiceManager().getArticleService()
				.getArticleById(getParametersAsMap());
		return "preUpdateExhibition";
	}

	/**
	 * 更新展会信息文章
	 * 
	 * @return
	 */
	public String updateExhibition() {
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
	 * 删除展会信息文章
	 * 
	 * @return
	 */
	public String deleteExhibition() {
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
		this.setAt("exhibition");
		articleList = getServiceManager().getArticleService()
				.getExhibitionArticles();
		return "view";
	}

}
