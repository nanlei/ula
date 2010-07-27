package ula.action.admin.city;

import java.util.Map;

import ula.action.CommonAction;

/**
 * 文章内容
 * 
 * @author Nanlei
 * 
 */
public class ArticleAction extends CommonAction {
	private String id;
	private Map view;

	public void setId(String id) {
		this.id = id;
	}

	public Map getView() {
		return view;
	}

	public String article() {
		super.view();
		view = getServiceManager().getArticleService().getArticleById(id);
		return "article";
	}

}
