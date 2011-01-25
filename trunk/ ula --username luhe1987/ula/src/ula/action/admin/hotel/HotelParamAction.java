package ula.action.admin.hotel;

import java.util.Map;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 酒店参数管理
 * 
 * @author Nanlei
 * 
 */
public class HotelParamAction extends CommonAction {
	private PagingList hotelParams;
	private Map hotelParam;

	public PagingList getHotelParams() {
		return hotelParams;
	}

	public Map getHotelParam() {
		return hotelParam;
	}

	public String hotelparam() throws Exception {
		hotelParams = getServiceManager().getHotelService().getAllHotelParams();
		return "hotelparam";
	}

	public String addParam() {
		try {
			getServiceManager().getHotelService().addHotelParam(
					getParametersAsMap());
			this.setAlertMessage(AlertMessage.HOTEL_PARAM_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String hotelParamPreUpdate() throws Exception {
		hotelParam = getServiceManager().getHotelService().getHotelParamById(
				getParametersAsMap());
		return "hotelParamPreUpdate";
	}

	public String updateParam() {
		try {
			getServiceManager().getHotelService().updateHotelParam(
					getParametersAsMap());
			this.setAlertMessage(AlertMessage.HOTEL_PARAM_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
