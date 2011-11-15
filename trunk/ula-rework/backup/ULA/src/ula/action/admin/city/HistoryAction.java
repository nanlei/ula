package ula.action.admin.city;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;
import ula.constant.ErrorConstants;

/**
 * 大连历史
 * 
 * @author Harry
 * 
 */
public class HistoryAction extends FrameworkAction {

	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return super.getServiceManager().getCityServcie().addInfo(CommonConstants.ID_CITY_HISTORY, title, content, CommonConstants.TAG_CITY_HISTORY);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String admin() {
		super.setMapKeyName(CommonConstants.KEY_CITY_HISTORY);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie()
					.getInfo(CommonConstants.ID_CITY_HISTORY));
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.CITY_HISTORY_EMPTY);
			
			return super.admin();
			
		}
		return super.admin();
	}

	@Override
	public String edit() {
		super.setMapKeyName(CommonConstants.KEY_CITY_HISTORY);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie().getInfo(CommonConstants.ID_CITY_HISTORY));
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			
			return ERROR;
		}
		
		return super.edit();
	}

	@Override
	public String preAdd() {
		return super.preAdd();
	}

	@Override
	public String update() {
		return super.update();
	}

	@Override
	protected int updateToDB(String title2, String content2) {
		try {
			return super.getServiceManager().getCityServcie().updateInfo(CommonConstants.ID_CITY_HISTORY, title2, content2);
		} catch (Exception e) {
super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(ErrorConstants.UPDATE_ERROR);
			return 0;
		}
	}

	@Override
	public String view() {
		super.setMapKeyName(CommonConstants.VIEW);
		try {
			super.setInfoMap(this.getServiceManager().getCityServcie().getInfo(CommonConstants.ID_CITY_HISTORY));
		} catch (Exception e) {
			e.printStackTrace();
			return super.view();
		}	
		return super.view();
	}

}
