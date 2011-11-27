package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 大连居住
 * 
 * @author Harry
 * 
 */
public class HousingAction extends CommonAction {
	private PagingList housingList;
	private Map<String, Object> housingInfo;
	private String articleId;
	private String at;
	private PagingList articleList;

	public PagingList getHousingList() {
		return housingList;
	}

	public Map<String, Object> getHousingInfo() {
		return housingInfo;
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
	 * 大连居住首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String housing() throws Exception {
		housingList = getServiceManager().getArticleService()
				.getHousingArticles();
		return "housing";
	}

	/**
	 * 添加大连居住文章
	 * 
	 * @return
	 */
	public String addHousing() {
		try {
			getServiceManager().getArticleService().addHousing(
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
	 * 获取大连居住文章信息供修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpdateHousing() throws Exception {
		housingInfo = getServiceManager().getArticleService().getArticleById(
				articleId);
		return "preUpdateHousing";
	}

	/**
	 * 更新大连居住文章
	 * 
	 * @return
	 */
	public String updateHousing() {
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
	 * 删除大连居住文章
	 * 
	 * @return
	 */
	public String deleteHousing() {
		try {
			getServiceManager().getArticleService()
					.deleteArticleById(articleId);
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
		this.setAt("housing");
		articleList = getServiceManager().getArticleService()
				.getHousingArticles();
		return "view";
	}

}
