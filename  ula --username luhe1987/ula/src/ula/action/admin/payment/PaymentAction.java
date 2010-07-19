package ula.action.admin.payment;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 支付方式
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
			return super.getServiceManager().getPaymentService().addInfo(CommonConstants.ID_PAYMENT, title, content,CommonConstants.TAG_PAYMENT);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String admin() {
		super.setMapKeyName(CommonConstants.KEY_SPECIAL_PAYMENT);
		try {
			super.setInfoMap(super.getServiceManager().getPaymentService().getInfo(CommonConstants.ID_PAYMENT));
		} catch (Exception e) {
		super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.SPECIAL_PAYMENT);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
	super.setMapKeyName(CommonConstants.KEY_SPECIAL_PAYMENT);
	try {
		super.setInfoMap(super.getServiceManager().getPaymentService().getInfo(CommonConstants.ID_PAYMENT));
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
			return super.getServiceManager().getPaymentService().updateInfo(CommonConstants.ID_PAYMENT, title2, content2);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String view() {
		return super.view();
	}
}
