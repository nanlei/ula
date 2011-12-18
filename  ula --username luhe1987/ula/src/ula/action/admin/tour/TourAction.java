package ula.action.admin.tour;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

public class TourAction extends BaseAction {
	private PagingList tourList;
	private List<Map<String, Object>> categoryList;
	private Map<String, Object> tour;

	public PagingList getTourList() {
		return tourList;
	}

	public List<Map<String, Object>> getCategoryList() {
		return categoryList;
	}

	public Map<String, Object> getTour() {
		return tour;
	}

	public String tourAdmin() throws Exception {
		tourList = getServiceManager().getTourService().getAllTours();
		categoryList = getServiceManager().getTourService()
				.getAllTourCategories();
		return "tourAdmin";
	}

	public String add() {
		try {
			getServiceManager().getTourService().addTour(getParametersAsMap(),
					getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.TOUR_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.TOUR_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	public String preUpdate() throws Exception {
		tour = getServiceManager().getTourService().getTourById(
				getParametersAsMap());
		categoryList = getServiceManager().getTourService()
				.getAllTourCategories();
		return "preUpdate";
	}

	public String update() {
		try {
			getServiceManager().getTourService().updateTourById(
					getParametersAsMap(), getLoginUserName());
			setResult(SUCCESS);
			addMessage(AlertMessage.TOUR_UPDATE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.TOUR_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	public String delete() {
		try {
			getServiceManager().getTourService().deleteTourById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.TOUR_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.TOUR_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
