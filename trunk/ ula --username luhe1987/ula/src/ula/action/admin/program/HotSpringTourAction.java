package ula.action.admin.program;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 温泉游
 * 
 * @author Harry
 * 
 */
public class HotSpringTourAction extends FrameworkAction {
	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return getServiceManager().getProgramService().addInfo(
					CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR, title, content,
					CommonConstants.TAG_PROGRAM_HOT_SPRING);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String admin() {
		setMapKeyName(CommonConstants.KEY_PROGRAM_HOT_SPRING);
		try {
			setInfoMap(getServiceManager().getProgramService().getInfo(
					CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.PROGRAM_HOT_SPRING);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
		setMapKeyName(CommonConstants.KEY_PROGRAM_HOT_SPRING);
		try {
			setInfoMap(getServiceManager().getProgramService().getInfo(
					CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR));
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
					CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR, title2,
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
					CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return super.view();
		}
		return super.view();
	}
}
