package ula.action.admin.city;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 城市地图
 * 
 * @author harry
 * 
 */
public class CityMapAction extends FrameworkAction {
	@Override
	protected int addToDB(String title, String content) {
		try {
			return super.getServiceManager().getCityServcie().addInfo(
					CommonConstants.ID_CITY_MAP, title, content,
					CommonConstants.TAG_CITY_MAP);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String admin() {
		super.setMapKeyName(CommonConstants.KEY_CITY_MAP);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie()
					.getInfo(CommonConstants.ID_CITY_MAP));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			super.setAlertMessage(AlertMessage.CITY_MAP);
		}
		return super.admin();
	}

	@Override
	public String edit() {
		super.setMapKeyName(CommonConstants.KEY_CITY_MAP);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie()
					.getInfo(CommonConstants.ID_CITY_MAP));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}
		return super.edit();
	}

	@Override
	protected int updateToDB(String title, String content) {
		try {
			return super.getServiceManager().getCityServcie().updateInfo(
					CommonConstants.ID_CITY_MAP, title, content);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String view() {
		super.setMapKeyName(CommonConstants.VIEW);
		try {
			super.setInfoMap(this.getServiceManager().getCityServcie().getInfo(
					CommonConstants.ID_CITY_MAP));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return super.view();
		}
		return super.view();
	}

}
