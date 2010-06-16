package ula.action.admin.link;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;

public class LinkAction extends FrameworkAction {
	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return super.getServiceManager().getLinkService().addInfo(CommonConstants.ID_LINK, title, content,CommonConstants.TAG_LINK);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String admin() {
		super.setMapKeyName(CommonConstants.KEY_LINK);
		try {
			super.setInfoMap(super.getServiceManager().getLinkService().getInfo(CommonConstants.ID_LINK));
		} catch (Exception e) {
		super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.LINK);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
	super.setMapKeyName(CommonConstants.KEY_LINK);
	try {
		super.setInfoMap(super.getServiceManager().getLinkService().getInfo(CommonConstants.ID_LINK));
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
			return super.getServiceManager().getLinkService().updateInfo(CommonConstants.ID_LINK, title2, content2);
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
