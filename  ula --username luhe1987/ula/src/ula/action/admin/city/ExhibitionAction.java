package ula.action.admin.city;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 展会信息
 * 
 * @author Nanlei
 * 
 */
public class ExhibitionAction extends CommonAction {
	private PagingList exhibitionList;
	private Map<String, Object> exhibition;

	public PagingList getExhibitionList() {
		return exhibitionList;
	}

	public Map<String, Object> getExhibition() {
		return exhibition;
	}

	/**
	 * 展会信息首页
	 * 
	 * @return
	 */
	public String exhibitionAdmin() {
		exhibitionList = getServiceManager().getArticleService()
				.getArticlesByType(CommonConstants.TAG_CITY_EXHIBITION);
		return "exhibitionAdmin";
	}

	/**
	 * 添加展会信息文章
	 * 
	 * @return
	 */
	public String add() {
		try {
			getServiceManager().getArticleService().addArticle(
					getParametersAsMap(), CommonConstants.TAG_CITY_EXHIBITION,
					getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_EXHIBITION);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 查找展会信息文章供修改
	 * 
	 * @return
	 */
	public String preUpdate() throws Exception {
		exhibition = getServiceManager().getArticleService().getArticleById(
				getParametersAsMap());
		return "preUpdate";
	}

	/**
	 * 更新展会信息文章
	 * 
	 * @return
	 */
	public String update() {
		try {
			getServiceManager().getArticleService().updateArticleById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_EXHIBITION);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 删除展会信息文章
	 * 
	 * @return
	 */
	public String delete() {
		try {
			getServiceManager().getArticleService().deleteArticleById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_EXHIBITION);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			addMessage(AlertMessage.ARTICLE_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

}
