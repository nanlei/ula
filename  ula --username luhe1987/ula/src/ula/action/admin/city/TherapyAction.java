package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 关于大连:大连治疗
 * 
 * @author Nanlei
 * 
 */
public class TherapyAction extends BaseAction {
	private PagingList therapyList;
	private Map<String, Object> therapy;

	public PagingList getTherapyList() {
		return therapyList;
	}

	public Map<String, Object> getTherapy() {
		return therapy;
	}

	/**
	 * 大连治疗首页
	 * 
	 * @return
	 */
	public String therapyAdmin() {
		therapyList = getServiceManager().getArticleService()
				.getArticlesByType(CommonConstants.TAG_CITY_THERAPY);
		return "therapyAdmin";
	}

	/**
	 * 添加大连治疗文章
	 * 
	 * @return
	 */
	public String add() {
		try {
			getServiceManager().getArticleService().addArticle(
					getParametersAsMap(), CommonConstants.TAG_CITY_THERAPY,
					getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_THERAPY);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 查询大连治疗文章供修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception {
		therapy = getServiceManager().getArticleService().getArticleById(
				getParametersAsMap());
		return "preUpdate";
	}

	/**
	 * 修改大连治疗文章
	 * 
	 * @return
	 */
	public String update() {
		try {
			getServiceManager().getArticleService().updateArticleById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_THERAPY);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 删除大连治疗文章
	 * 
	 * @return
	 */
	public String delete() {
		try {
			getServiceManager().getArticleService().deleteArticleById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_THERAPY);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			addMessage(AlertMessage.ARTICLE_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

}
