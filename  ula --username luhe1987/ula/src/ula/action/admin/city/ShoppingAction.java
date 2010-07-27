package ula.action.admin.city;

import java.util.Map;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 大连购物
 * 
 * @author Harry
 * 
 */
public class ShoppingAction extends CommonAction {
	private PagingList shoppingList;
	private Map shoppingInfo;
	private String articleId;
	private String at;
	private PagingList articleList;

	public PagingList getShoppingList() {
		return shoppingList;
	}

	public Map getShoppingInfo() {
		return shoppingInfo;
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
	 * 大连购物首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String shopping() throws Exception {
		shoppingList = getServiceManager().getArticleService()
				.getShoppingArticles();
		return "shopping";
	}

	/**
	 * 添加大连购物文章
	 * 
	 * @return
	 */
	public String addShopping() {
		try {
			getServiceManager().getArticleService().addShopping(
					getParametersAsMap(), "admin");
			this.setAlertMessage(AlertMessage.ARTICLE_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	/**
	 * 获取购物文章信息供修改
	 * 
	 * @return
	 */
	public String preUpdateShopping() {
		shoppingInfo = getServiceManager().getArticleService().getArticleById(
				articleId);
		return "preUpdateShopping";
	}

	/**
	 * 更新大连购物文章
	 * 
	 * @return
	 */
	public String updateShopping() {
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
	 * 删除大连购物文章
	 * 
	 * @return
	 */
	public String deleteShopping() {
		try {
			getServiceManager().getArticleService()
					.deleteArticleById(articleId);
			this.setAlertMessage(AlertMessage.ARTICLE_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String view() {
		super.view();
		this.setAt("shopping");
		articleList = getServiceManager().getArticleService()
				.getShoppingArticles();
		return "view";
	}
}
