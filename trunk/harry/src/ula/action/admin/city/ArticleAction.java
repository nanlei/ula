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

	private String type;

	public void setId(String id) {
		this.id = id;
	}

	public Map getView() {
		return view;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String article() {
		super.view();
		view = getServiceManager().getArticleService().getArticleById(id);
		return "article";
	}

	public String view() {
		super.view();
		view = getServiceManager().getArticleService().getFirstArticleByType(
				type);
		return "view";
	}

}
