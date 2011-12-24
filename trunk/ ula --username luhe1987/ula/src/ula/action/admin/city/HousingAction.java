package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 大连居住
 * 
 * @author Harry
 * 
 */
public class HousingAction extends BaseAction {
	private PagingList housingList;
	private Map<String, Object> housing;

	public PagingList getHousingList() {
		return housingList;
	}

	public Map<String, Object> getHousing() {
		return housing;
	}

	/**
	 * 大连居住首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String housingAdmin() throws Exception {
		housingList = getServiceManager().getArticleService()
				.getArticlesByType(CommonConstants.TAG_CITY_HOUSING);
		return "housingAdmin";
	}

	/**
	 * 添加大连居住文章
	 * 
	 * @return
	 */
	public String add() {
		try {
			getServiceManager().getArticleService().addArticle(
					getParametersAsMap(), CommonConstants.TAG_CITY_HOUSING,
					getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_HOUSING);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 获取大连居住文章信息供修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception {
		housing = getServiceManager().getArticleService().getArticleById(
				getParametersAsMap());
		return "preUpdate";
	}

	/**
	 * 更新大连居住文章
	 * 
	 * @return
	 */
	public String update() {
		try {
			getServiceManager().getArticleService().updateArticleById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_HOUSING);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 删除大连居住文章
	 * 
	 * @return
	 */
	public String delete() {
		try {
			getServiceManager().getArticleService().deleteArticleById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_HOUSING);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			addMessage(AlertMessage.ARTICLE_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
