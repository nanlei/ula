package ula.action.admin.city;

import java.util.Map;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 大连交通
 * 
 * @author Harry
 * 
 */
public class TransportationAction extends CommonAction {
	private PagingList transportationList;
	private Map transportationInfo;
	private String articleId;

	public PagingList getTransportationList() {
		return transportationList;
	}

	public Map getTransportationInfo() {
		return transportationInfo;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	/**
	 * 大连交通首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String transportation() throws Exception {
		transportationList = getServiceManager().getArticleService()
				.getTransportationArticles();
		return "transportation";
	}

	/**
	 * 添加大连交通文章
	 * 
	 * @return
	 */
	public String addTransportation() {
		try {
			getServiceManager().getArticleService().addTransportation(
					getParametersAsMap(), "admin");
			this.setAlertMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	/**
	 * 获取大连交通文章信息供修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpdateTransportation() throws Exception {
		transportationInfo = getServiceManager().getArticleService()
				.getArticleById(articleId);
		return "preUpdateTransportation";
	}

	/**
	 * 修改大连交通文章
	 * 
	 * @return
	 */
	public String updateTransportation() {
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
	 * 删除大连交通文章
	 * 
	 * @return
	 */
	public String deleteTransportation() {
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
