package ula.action.admin.special;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 各项委托
 * 
 * @author Harry
 * 
 */
public class TicketCommissionAction extends FrameworkAction {
	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return getServiceManager().getSpecialService().addInfo(
					CommonConstants.ID_SPECIAL_COMMISSION_TICKET, title,
					content, CommonConstants.TAG_SPECIAL_COMMISION_TICKET);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String admin() {
		setMapKeyName(CommonConstants.KEY_SPECIAL_TICKET);
		try {
			setInfoMap(getServiceManager().getSpecialService().getInfo(
					CommonConstants.ID_SPECIAL_COMMISSION_TICKET));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.SPECIAL_TICKET);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
		setMapKeyName(CommonConstants.KEY_SPECIAL_TICKET);
		try {
			setInfoMap(getServiceManager().getSpecialService().getInfo(
					CommonConstants.ID_SPECIAL_COMMISSION_TICKET));
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
			return getServiceManager().getSpecialService().updateInfo(
					CommonConstants.ID_SPECIAL_COMMISSION_TICKET, title2,
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
			setInfoMap(getServiceManager().getSpecialService().getInfo(
					CommonConstants.ID_SPECIAL_COMMISSION_TICKET));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return super.view();
		}
		return super.view();
	}
}
