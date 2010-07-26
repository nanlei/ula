package ula.action.admin.program;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 温泉游
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
			return super.getServiceManager().getProgramService().addInfo(CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR, title, content,CommonConstants.TAG_PROGRAM_HOT_SPRING);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String admin() {
		super.setMapKeyName(CommonConstants.KEY_PROGRAM_HOT_SPRING);
		try {
			super.setInfoMap(super.getServiceManager().getProgramService().getInfo(CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR));
		} catch (Exception e) {
		super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.PROGRAM_HOT_SPRING);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
	super.setMapKeyName(CommonConstants.KEY_PROGRAM_HOT_SPRING);
	try {
		super.setInfoMap(super.getServiceManager().getProgramService().getInfo(CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR));
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
			return super.getServiceManager().getProgramService().updateInfo(CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR, title2, content2);
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
			super.setInfoMap(this.getServiceManager().getProgramService().getInfo(CommonConstants.ID_PROGRAM_HOT_SPRING_TOUR));
		} catch (Exception e) {
			e.printStackTrace();
			return super.view();
		}	
		return super.view();
	}
}
