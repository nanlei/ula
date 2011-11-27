package ula.action.admin.program;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 治疗行程
 * 
 * @author Harry
 * 
 */
public class TherapyScheduleAction extends FrameworkAction {
	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return getServiceManager().getProgramService().addInfo(
					CommonConstants.ID_PROGRAM_THERAPY_SCHEDULE, title,
					content, CommonConstants.TAG_PROGRAM_THERAPY);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String admin() {
		setMapKeyName(CommonConstants.KEY_PROGRAM_THERAPY);
		try {
			setInfoMap(getServiceManager().getProgramService().getInfo(
					CommonConstants.ID_PROGRAM_THERAPY_SCHEDULE));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.PROGRAM_THERAPY);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
		setMapKeyName(CommonConstants.KEY_PROGRAM_THERAPY);
		try {
			setInfoMap(getServiceManager().getProgramService().getInfo(
					CommonConstants.ID_PROGRAM_THERAPY_SCHEDULE));
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
					CommonConstants.ID_PROGRAM_THERAPY_SCHEDULE, title2,
					content2);
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
					CommonConstants.ID_PROGRAM_THERAPY_SCHEDULE));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return super.view();
		}
		return super.view();
	}
}
