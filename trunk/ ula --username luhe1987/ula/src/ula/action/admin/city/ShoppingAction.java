package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 大连购物
 * 
 * @author Harry
 * 
 */
public class ShoppingAction extends BaseAction {
	private PagingList shoppingList;
	private Map<String, Object> shopping;

	public PagingList getShoppingList() {
		return shoppingList;
	}

	public Map<String, Object> getShopping() {
		return shopping;
	}

	/**
	 * 大连购物首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String shoppingAdmin() throws Exception {
		shoppingList = getServiceManager().getArticleService()
				.getArticlesByType(CommonConstants.TAG_CITY_SHOPPING);
		return "shoppingAdmin";
	}

	/**
	 * 添加大连购物文章
	 * 
	 * @return
	 */
	public String add() {
		try {
			getServiceManager().getArticleService().addArticle(
					getParametersAsMap(), CommonConstants.TAG_CITY_SHOPPING,
					getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_SHOPPING);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 获取购物文章信息供修改
	 * 
	 * @return
	 */
	public String preUpdate() throws Exception {
		shopping = getServiceManager().getArticleService().getArticleById(
				getParametersAsMap());
		return "preUpdate";
	}

	/**
	 * 更新大连购物文章
	 * 
	 * @return
	 */
	public String update() {
		try {
			getServiceManager().getArticleService().updateArticleById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_SHOPPING);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 删除大连购物文章
	 * 
	 * @return
	 */
	public String delete() {
		try {
			getServiceManager().getArticleService().deleteArticleById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_SHOPPING);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			addMessage(AlertMessage.ARTICLE_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

}
