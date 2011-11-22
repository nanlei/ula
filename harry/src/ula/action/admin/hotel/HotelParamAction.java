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

	/**
	 * 酒店参数列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String hotelparam() throws Exception {
		hotelParams = getServiceManager().getHotelService().getAllHotelParams();
		return "hotelparam";
	}

	/**
	 * 添加参数
	 * 
	 * @return
	 */
	public String addParam() {
		try {
			// 检查参数名称是否已经存在
			int flag = getServiceManager().getHotelService().getCheckNameExist(
					getParametersAsMap());
			if (flag > 0) {
				this.setAlertMessage(AlertMessage.HOTEL_PARAM_NAME_EXIST);
				return SUCCESS;
			} else {
				getServiceManager().getHotelService().addHotelParam(
						getParametersAsMap());
				this.setAlertMessage(AlertMessage.HOTEL_PARAM_ADD_SUCCESS);
				return SUCCESS;
			}
		} catch (Exception e) {
			this.setAlertMessage(AlertMessage.HOTEL_PARAM_ADD_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 获取参数信息供更新
	 * 
	 * @return
	 * @throws Exception
	 */
	public String hotelParamPreUpdate() throws Exception {
		hotelParam = getServiceManager().getHotelService().getHotelParamById(
				getParametersAsMap());
		return "hotelParamPreUpdate";
	}

	/**
	 * 更新参数
	 * 
	 * @return
	 */
	public String updateParam() {
		try {
			getServiceManager().getHotelService().updateHotelParam(
					getParametersAsMap());
			this.setAlertMessage(AlertMessage.HOTEL_PARAM_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			this.setAlertMessage(AlertMessage.HOTEL_PARAM_UPDATE_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 删除参数
	 * 
	 * @return
	 */
	public String hotelParamDelete() {
		try {
			getServiceManager().getHotelService().deleteHotelParam(
					getParametersAsMap());
			this.setAlertMessage(AlertMessage.HOTL_PARAM_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			this.setAlertMessage(AlertMessage.HOTL_PARAM_DELETE_FAILURE);
			return ERROR;
		}
	}
}
