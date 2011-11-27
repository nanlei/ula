package ula.action.admin.program;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 夏令营
 * 
 * @author Harry
 * 
 */
public class SummerCampAction extends FrameworkAction {
	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return getServiceManager().getProgramService().addInfo(
					CommonConstants.ID_PROGRAM_SUMMER_CAMP, title, content,
					CommonConstants.TAG_PROGRAM_SUMMER_CAMP);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String admin() {
		setMapKeyName(CommonConstants.KEY_PROGRAM_SUMMER_CAMP);
		try {
			setInfoMap(getServiceManager().getProgramService().getInfo(
					CommonConstants.ID_PROGRAM_SUMMER_CAMP));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.PROGRAM_SUMMER_CAMP);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
		setMapKeyName(CommonConstants.KEY_PROGRAM_SUMMER_CAMP);
		try {
			setInfoMap(getServiceManager().getProgramService().getInfo(
					CommonConstants.ID_PROGRAM_SUMMER_CAMP));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
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
			return getServiceManager().getProgramService().updateInfo(
					CommonConstants.ID_PROGRAM_SUMMER_CAMP, title2, content2);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String view() {
		setMapKeyName(CommonConstants.VIEW);
		try {
			setInfoMap(getServiceManager().getProgramService().getInfo(
					CommonConstants.ID_PROGRAM_SUMMER_CAMP));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return super.view();
		}
		return super.view();
	}
}
