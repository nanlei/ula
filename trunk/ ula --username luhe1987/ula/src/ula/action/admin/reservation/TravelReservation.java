package ula.action.admin.reservation;

import java.util.Map;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.StringUtil;

public class TravelReservation extends CommonAction {
	private String numOfTourist;
	private String startDate;
	private String returnDate;
	private String replyDeadline;
	private String requirements;  //客户要求，旅游路线
	private String contactName;
	private String contactGender;
	private String contactPhone;
	private String contactEmail;
	
	private PagingList travelReservList =null;
	private Map travelReserv= null;
	
	
	public String getNumOfTourist() {
		return numOfTourist;
	}
	public void setNumOfTourist(String numOfTourist) {
		this.numOfTourist = numOfTourist;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getReplyDeadline() {
		return replyDeadline;
	}
	public void setReplyDeadline(String replyDeadline) {
		this.replyDeadline = replyDeadline;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactGender() {
		return contactGender;
	}
	public void setContactGender(String contactGender) {
		this.contactGender = contactGender;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public PagingList getTravelReservList() {
		return travelReservList;
	}
	public void setTravelReservList(PagingList travelReservList) {
		this.travelReservList = travelReservList;
	}
	public Map getTravelReserv() {
		return travelReserv;
	}
	public void setTravelReserv(Map travelReserv) {
		this.travelReserv = travelReserv;
	}
	
	
	/**
	 * 保存用户订单
	 * @return
	 */
	public String reserve(){
		super.debug(this.toString());
		try {
			super.getServiceManager().getReservationService().reserve_travel(this.numOfTourist,this.startDate,this.returnDate,this.replyDeadline,this.requirements,this.contactName,this.contactGender,this.contactPhone,this.contactEmail);
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 订单管理页面
	 * @return
	 */
	public String admin(){
		try {
			this.travelReservList  = super.getServiceManager().getReservationService().getTravelReservList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin";
	}
	
	/**
	 * 移除订单
	 * @return
	 */
	public String remove(){
		String Id = super.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(Id)){
			super.debug("订单id: " + Id +"是一个无效id" );
			return ERROR;
		}
		
		super.getServiceManager().getReservationService().removeTravelReserv(Id);
		super.setAlertMessage(AlertMessage.DELTE_SUCCESS);
		return this.admin();
	}
	
	/**
	 * 订单详细信息
	 * @return
	 */
	public String detail(){
		String Id = this.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(Id)){
			super.debug("订单Id:"+Id+" 是无效Id");
			return ERROR;
		}
		
		try {
			this.travelReserv = super.getServiceManager().getReservationService().detail_travel(Id);
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
		return "detail";
	}
	
	
	/**
	 * 标记为“已处理”
	 * @return
	 */
	public String done(){
		String Id = this.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(Id)){
			super.debug("订单Id:"+Id+" 是无效Id");
			return ERROR;
		}
		
		try {
			super.getServiceManager().getReservationService().travelOrderDoneMark(Id);
			super.setAlertMessage(AlertMessage.DONE_MARK);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return this.admin();
	}
	
	/**
	 * 标记为“未处理”
	 * @return
	 */
	public String undone(){
		String Id = this.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(Id)){
			super.debug("订单Id:"+Id+" 是无效Id");
			return ERROR;
		}
		
		try {
			super.getServiceManager().getReservationService().travelOrderUndoneMark(Id);
			super.setAlertMessage(AlertMessage.UNDONE_MARK);
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
		return this.admin();
	}
	
	
	@Override
	public String view() {
		super.view();
		return "view";
	}
	
	@Override
	public String toString() {
		return "TravelReservation [contactEmail=" + contactEmail
				+ ", contactGender=" + contactGender + ", contactName="
				+ contactName + ", contactPhone=" + contactPhone
				+ ", numOfTourist=" + numOfTourist + ", replyDeadline="
				+ replyDeadline + ", requirements=" + requirements
				+ ", returnDate=" + returnDate + ", startDate=" + startDate
				+ "]";
	}
}
