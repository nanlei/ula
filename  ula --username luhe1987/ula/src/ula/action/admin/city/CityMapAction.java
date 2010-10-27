package ula.action.admin.city;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 城市地图
 * @author harry
 *
 */
public class CityMapAction extends FrameworkAction {
	@Override
	protected int addToDB(String title, String content) {
		try {
			return super.getServiceManager().getCityServcie().addInfo(CommonConstants.ID_CITY_MAP, title, content, CommonConstants.TAG_CITY_MAP);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	

	@Override
	public String admin() {
		super.setMapKeyName(CommonConstants.KEY_CITY_MAP);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie().getInfo(CommonConstants.ID_CITY_MAP));
		} catch (Exception e) {
			super.debug(e.getLocalizedMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.CITY_MAP);
		}
		return super.admin();
	}

	@Override
	public String edit() {
		super.setMapKeyName(CommonConstants.KEY_CITY_MAP);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie().getInfo(CommonConstants.ID_CITY_MAP));
		} catch (Exception e) {
			super.debug(e.getLocalizedMessage());
			e.printStackTrace();
			return ERROR;
		}
		return super.edit();
	}

	@Override
	protected int updateToDB(String title, String content) {
		try {
			return super.getServiceManager().getCityServcie().updateInfo(CommonConstants.ID_CITY_MAP, title, content);
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
			super.setInfoMap(this.getServiceManager().getCityServcie().getInfo(CommonConstants.ID_CITY_MAP));
		} catch (Exception e) {
			e.printStackTrace();
			return super.view();
		}	
		return super.view();
	}
	
}
