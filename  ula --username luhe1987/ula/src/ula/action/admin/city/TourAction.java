package ula.action.admin.city;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 大连观光（景点，公园）
 * 
 * @author Harry
 * 
 */
public class TourAction extends BaseAction {
	private String articleType;// 栏目类别
	private List<Map<String, Object>> tourList;
	private PagingList pictureList;
	private Map<String, Object> tour;

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public List<Map<String, Object>> getTourList() {
		return tourList;
	}

	public PagingList getPictureList() {
		return pictureList;
	}

	public Map<String, Object> getTour() {
		return tour;
	}

	/**
	 * 大连/旅顺/开发区首页
	 * 
	 * @return
	 */
	public String tourAdmin() {
		tourList = getServiceManager().getArticleService().getTours();
		return "tourAdmin";
	}

	/**
	 * 选择封面图片
	 * 
	 * @return
	 */
	public String selectCoverLink() {
		pictureList = getServiceManager().getPicService().getPicsByType(
				articleType);
		return "selectCoverLink";
	}

	/**
	 * 文章信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception {
		tour = getServiceManager().getArticleService().getArticleById(
				getParametersAsMap());
		return "preUpdate";
	}

	/**
	 * 更新文章信息
	 * 
	 * @return
	 */
	public String update() {
		try {
			getServiceManager().getArticleService().updateArticleById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.ARTICLE_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_CITY_TOUR);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.ARTICLE_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
