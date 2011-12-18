package ula.action.admin.tour;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.constant.AlertMessage;

/**
 * 行程分类管理
 * 
 * @author Nanlei
 * 
 */
public class CategoryAction extends CommonAction {
	private List<Map<String, Object>> categoryList;
	private List<Map<String, Object>> vacationTypeList;
	private Map<String, Object> category;
	private List<Map<String, Object>> categoryVTList;

	public List<Map<String, Object>> getCategoryList() {
		return categoryList;
	}

	public List<Map<String, Object>> getVacationTypeList() {
		return vacationTypeList;
	}

	public Map<String, Object> getCategory() {
		return category;
	}

	public List<Map<String, Object>> getCategoryVTList() {
		return categoryVTList;
	}

	public String categoryAdmin() throws Exception {
		categoryList = getServiceManager().getTourService()
				.getAllTourCategories();
		vacationTypeList = getServiceManager().getTourService()
				.getAllTourVacationTypes();
		return "categoryAdmin";
	}

	/**
	 * 添加行程分类
	 * 
	 * @return
	 */
	public String add() {
		try {
			getServiceManager().getTourService().addTourCategory(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.TOUR_CATEGORY_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR_CATEGORY);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.TOUR_CATEGORY_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	public String preUpdate() throws Exception {
		category = getServiceManager().getTourService().getTourCategoryByID(
				getParametersAsMap());
		vacationTypeList = getServiceManager().getTourService()
				.getAllTourVacationTypes();
		categoryVTList = getServiceManager().getTourService()
				.getVacationTypeByTourCategoryID(getParametersAsMap());
		return "preUpdate";
	}

	/**
	 * 更新行程分类
	 * 
	 * @return
	 */
	public String update() {
		try {
			getServiceManager().getTourService().updateTourCategoryByID(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.TOUR_CATEGORY_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR_CATEGORY);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.TOUR_CATEGORY_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 删除行程分类
	 * 
	 * @return
	 */
	public String delete() {
		try {
			getServiceManager().getTourService().deleteTourCategoryById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.TOUR_CATEGORY_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR_CATEGORY);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.TOUR_CATEGORY_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
