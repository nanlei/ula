package ula.action.admin.contact;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

/**
 * 中国团队客户入口
 * 
 * @author Harry
 * 
 */
public class GroupClientChineseAction extends FrameworkAction {

	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return super.getServiceManager().getContactService().addInfo(
					CommonConstants.ID_CONTACT_GROUP_CN, title, content);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String admin() {
		this.setMapKeyName(CommonConstants.KEY_CONTACT_GROUP_CN);
		try {
			super.setInfoMap(super.getServiceManager().getContactService()
					.getInfo(CommonConstants.ID_CONTACT_GROUP_CN));
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.COMPANYINFO_EMPTY);
			return super.admin();
		}

		return super.admin();
	}

	@Override
	public String edit() {
		super.setMapKeyName(CommonConstants.KEY_CONTACT_GROUP_CN);
		try {
			super.setInfoMap(super.getServiceManager().getContactService()
					.getInfo(CommonConstants.ID_CONTACT_GROUP_CN));
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
			return super.getServiceManager().getContactService().updateInfo(CommonConstants.ID_CONTACT_GROUP_CN, title2, content2);
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
			super.setInfoMap(this.getServiceManager().getContactService().getInfo(CommonConstants.ID_CONTACT_GROUP_CN));
		} catch (Exception e) {
			e.printStackTrace();
			return super.view();
		}	
		return super.view();
	}

}
