package ula.action.admin.city;

import ula.action.CommonAction;
import ula.common.PagingList;

/**
 * 展会信息
 * 
 * @author Nanlei
 * 
 */
public class ExhibitionAction extends CommonAction {
	private PagingList exhibitionList;

	public PagingList getExhibitionList() {
		return exhibitionList;
	}

	/**
	 * 展会信息首页
	 * 
	 * @return
	 */
	public String exhibition() {
		exhibitionList = getServiceManager().getArticleService()
				.getExhibitionArticles();
		return "exhibition";
	}
}
