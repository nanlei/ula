package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 大连美食
 * 
 * @author Harry
 * 
 */
public class FoodAction extends BaseAction {
	private PagingList foodList;
	private Map<String, Object> food;

	public PagingList getFoodList() {
		return foodList;
	}

	public Map<String, Object> getFood() {
		return food;
	}

	/**
	 * 大连美食首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String foodAdmin() throws Exception {
		foodList = getServiceManager().getArticleService().getArticlesByType(
				CommonConstants.TAG_CITY_FOOD);
		return "foodAdmin";
	}

	/**
	 * 添加美食文章
	 * 
	 * @return
	 */
	public String add() {
		try {
			getServiceManager().getArticleService().addArticle(
					getParametersAsMap(), CommonConstants.TAG_CITY_FOOD,
					getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_FOOD);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 获取美食文章信息供修改
	 * 
	 * @return
	 */
	public String preUpdate() throws Exception {
		food = getServiceManager().getArticleService().getArticleById(
				getParametersAsMap());
		return "preUpdate";
	}

	/**
	 * 更新美食文章
	 * 
	 * @return
	 */
	public String update() {
		try {
			getServiceManager().getArticleService().updateArticleById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_FOOD);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 删除美食文章
	 * 
	 * @return
	 */
	public String delete() {
		try {
			getServiceManager().getArticleService().deleteArticleById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_FOOD);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			addMessage(AlertMessage.ARTICLE_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

}
