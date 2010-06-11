package ula.action.admin.contact;

import ula.action.FrameworkAction;

/**
 * 个人客户入口
 * @author Harry
 *
 */
public class IndividualClientAction extends FrameworkAction {
	
	@Override
	public String add() {
		return super.add();
	}

	@Override
	protected int addToDB(String title, String content) {
		return super.addToDB(title, content);
	}

	@Override
	public String admin() {
		return super.admin();
	}

	@Override
	public String edit() {
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
		return super.updateToDB(title2, content2);
	}

	@Override
	public String view() {
		return super.view();
	}
	
}
