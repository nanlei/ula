package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 大连交通
 * 
 * @author Harry
 * 
 */
public class TransportationAction extends BaseAction {
	private PagingList transportationList;
	private Map<String, Object> transportation;

	public PagingList getTransportationList() {
		return transportationList;
	}

	public Map<String, Object> getTransportation() {
		return transportation;
	}

	/**
	 * 大连交通首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String transportationAdmin() throws Exception {
		transportationList = getServiceManager().getArticleService()
				.getArticlesByType(CommonConstants.TAG_CITY_TRANSPORTATION);
		return "transportationAdmin";
	}

	/**
	 * 添加大连交通文章
	 * 
	 * @return
	 */
	public String add() {
		try {
			getServiceManager().getArticleService()
					.addArticle(getParametersAsMap(),
							CommonConstants.TAG_CITY_TRANSPORTATION,
							getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK,
					AlertMessage.URL_CITY_TRANSPORTATION);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 获取大连交通文章信息供修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception {
		transportation = getServiceManager().getArticleService()
				.getArticleById(getParametersAsMap());
		return "preUpdate";
	}

	/**
	 * 修改大连交通文章
	 * 
	 * @return
	 */
	public String update() {
		try {
			getServiceManager().getArticleService().updateArticleById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK,
					AlertMessage.URL_CITY_TRANSPORTATION);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 删除大连交通文章
	 * 
	 * @return
	 */
	public String delete() {
		try {
			getServiceManager().getArticleService().deleteArticleById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK,
					AlertMessage.URL_CITY_TRANSPORTATION);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			addMessage(AlertMessage.ARTICLE_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

}
