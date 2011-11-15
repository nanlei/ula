package ula.action.admin.city;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

public class PracticalAdviceAction extends FrameworkAction {

	@Override
	protected int addToDB(String title, String content) {
		try {
			return super.getServiceManager().getCityServcie().addInfo(
					CommonConstants.ID_CITY_ADVICE, title, content,
					CommonConstants.TAG_CITY_ADVICE);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String admin() {
		super.setMapKeyName(CommonConstants.KEY_CITY_ADVICE);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie()
					.getInfo(CommonConstants.ID_CITY_ADVICE));
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.CITY_ADVICE);
		}
		return super.admin();
	}

	@Override
	public String edit() {
		super.setMapKeyName(CommonConstants.KEY_CITY_ADVICE);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie()
					.getInfo(CommonConstants.ID_CITY_ADVICE));
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return super.edit();
	}

	@Override
	protected int updateToDB(String title, String content) {
		try {
			return super.getServiceManager().getCityServcie().updateInfo(CommonConstants.ID_CITY_ADVICE, title, content);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String view() {
		super.setMapKeyName(CommonConstants.VIEW);
		try {
			super.setInfoMap(this.getServiceManager().getCityServcie().getInfo(CommonConstants.ID_CITY_ADVICE));
		} catch (Exception e) {
			e.printStackTrace();
			return super.view();
		}	
		return super.view();
	}
	
	

}
