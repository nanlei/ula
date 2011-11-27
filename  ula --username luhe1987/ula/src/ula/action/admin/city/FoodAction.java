package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 大连美食
 * 
 * @author Harry
 * 
 */
public class FoodAction extends CommonAction {
	private PagingList foodList;
	private String articleId;
	private Map<String, Object> foodInfo;
	private String at;
	private PagingList articleList;

	public PagingList getFoodList() {
		return foodList;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public Map<String, Object> getFoodInfo() {
		return foodInfo;
	}

	public PagingList getArticleList() {
		return articleList;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	/**
	 * 大连美食首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String food() throws Exception {
		foodList = getServiceManager().getArticleService().getFoodArticles();
		return "food";
	}

	/**
	 * 添加美食文章
	 * 
	 * @return
	 */
	public String addFood() {
		try {
			getServiceManager().getArticleService().addFood(
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
	 * 获取美食文章信息供修改
	 * 
	 * @return
	 */
	public String preUpdateFood() throws Exception {
		foodInfo = getServiceManager().getArticleService().getArticleById(
				articleId);
		return "preUpdateFood";
	}

	/**
	 * 更新美食文章
	 * 
	 * @return
	 */
	public String updateFood() {
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
	 * 删除美食文章
	 * 
	 * @return
	 */
	public String deleteFood() {
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
		this.setAt("food");
		articleList = getServiceManager().getArticleService().getFoodArticles();
		return "view";
	}
}
