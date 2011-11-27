package ula.action.admin.payment;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 支付方式
 * 
 * @author Harry
 * 
 */
public class PaymentAction extends FrameworkAction {

	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return getServiceManager().getPaymentService().addInfo(
					CommonConstants.ID_PAYMENT, title, content,
					CommonConstants.TAG_PAYMENT);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String admin() {
		setMapKeyName(CommonConstants.KEY_SPECIAL_PAYMENT);
		try {
			setInfoMap(getServiceManager().getPaymentService().getInfo(
					CommonConstants.ID_PAYMENT));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.SPECIAL_PAYMENT);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
		setMapKeyName(CommonConstants.KEY_SPECIAL_PAYMENT);
		try {
			setInfoMap(getServiceManager().getPaymentService().getInfo(
					CommonConstants.ID_PAYMENT));
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
			return getServiceManager().getPaymentService().updateInfo(
					CommonConstants.ID_PAYMENT, title2, content2);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public String view() {
		setMapKeyName(CommonConstants.VIEW);
		try {
			setInfoMap(getServiceManager().getPaymentService().getInfo(
					CommonConstants.ID_PAYMENT));
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return super.view();
		}
		return super.view();
	}
}
