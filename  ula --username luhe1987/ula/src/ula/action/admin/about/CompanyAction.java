package ula.action.admin.about;

import ula.action.FrameworkAction;
import ula.constant.AlertMessage;
import ula.constant.CommonConstants;
import ula.constant.ErrorConstants;

/**
 * About us -> company introduction
 * 
 * @author Harry
 * 
 */
public class CompanyAction extends FrameworkAction{
	/**
	 * 添加。需要override addToDB()
	 */
		@Override
		public String add() {
			return super.add();
		}

		/**
		 * 管理页面。
		 * 需要调用setInfoMap(),因为super.admin中将这个map的值放入了Request里。
		 */
		@Override
		public String admin() {
//			设置存放信息的key。客户端用这个key取值
			super.setMapKeyName(CommonConstants.KEY_COMPANY_INFO);

			try {
				super.setInfoMap(this.getServiceManager().getAboutService().getCompanyInfo());
			} catch (Exception e) {
				super.debug(e.getMessage());
				e.printStackTrace();
//				如果在数据库中没有找到信息，那么给出提示；
				this.setAlertMessage(AlertMessage.COMPANYINFO_EMPTY);
				return super.admin();
			}	
			
			return super.admin();
		}

		@Override
		public String edit() {
			super.setMapKeyName(CommonConstants.KEY_COMPANY_INFO);
			
			try {
				this.setInfoMap(super.getServiceManager().getAboutService().getCompanyInfo());
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
		public String view() {
			super.setMapKeyName(CommonConstants.VIEW);
			try {
				super.setInfoMap(this.getServiceManager().getAboutService().getCompanyInfo());
			} catch (Exception e) {
				e.printStackTrace();
			}	
			return super.view();
		}

		@Override
		protected int addToDB(String title, String content) {
			try {
				return super.getServiceManager().getAboutService().addCompanyInfo(title, content);
			} catch (Exception e) {
				super.debug(ErrorConstants.INSERT_ERROR);
				return 0;
			}
		}
		
		@Override
		protected int updateToDB(String title2, String content2) {
			try {
				return this.getServiceManager().getAboutService().updateCompanyInfo(title2, content2);
			} catch (Exception e) {
				super.debug(ErrorConstants.UPDATE_ERROR);
				return 0;
			}
		}
		
}
