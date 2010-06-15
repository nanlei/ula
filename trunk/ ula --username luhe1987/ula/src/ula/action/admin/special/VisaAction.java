package ula.action.admin.special;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;
/**
 * 签证服务
 * @author Harry
 *
 */
public class VisaAction extends FrameworkAction{
	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		try {
			return super.getServiceManager().getCityServcie().addInfo(CommonConstants.ID_SPECIAL_VISA, title, content,CommonConstants.TAG_CITY_INTRODUCTION);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String admin() {
		super.setMapKeyName(CommonConstants.KEY_CITY_INTRODUCTION);
		try {
			super.setInfoMap(super.getServiceManager().getCityServcie().getInfo(CommonConstants.ID_CITY_INTRODUCTION));
		} catch (Exception e) {
		super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.CITY_INTRO_EMPTY);
			return super.admin();
		}
		return super.admin();
	}

	@Override
	public String edit() {
	super.setMapKeyName(CommonConstants.KEY_CITY_INTRODUCTION);
	try {
		super.setInfoMap(super.getServiceManager().getCityServcie().getInfo(CommonConstants.ID_CITY_INTRODUCTION));
	} catch (Exception e) {
		super.debug(e.getMessage());
		e.printStackTrace();
		return ERROR;
	}
	
		return super.edit();
	}

	@Override
	public String preAdd() {
		// TODO Auto-generated method stub
		return super.preAdd();
	}

	@Override
	public String update() {
		return super.update();
	}

	@Override
	protected int updateToDB(String title2, String content2) {
		try {
			return super.getServiceManager().getCityServcie().updateInfo(CommonConstants.ID_CITY_INTRODUCTION, title2, content2);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			
			return 0;
		}
	}

	@Override
	public String view() {
		// TODO Auto-generated method stub
		return super.view();
	}
	
}
