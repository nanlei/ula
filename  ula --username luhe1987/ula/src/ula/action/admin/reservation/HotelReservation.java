package ula.action.admin.reservation;

import java.util.Map;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.StringUtil;
/**
 * 2010-7-16 10:59:24
 * @author Harry
 *
 */
public class HotelReservation extends CommonAction {
	private String name;
	private String tel;
	private String email;
	private String hotelName;
	private String roomCategory;
	private String checkinDate;
	private String checkoutDate;
	private String numberOfMen = "0";
	private String numberOfWomen = "0";
	private String numberOfKids = "0";
	private String remarks;

	private PagingList hotelReservList = null;
	private Map reservation= null;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getNumberOfMen() {
		return numberOfMen;
	}

	public void setNumberOfMen(String numberOfMen) {
		this.numberOfMen = numberOfMen;
	}

	public String getNumberOfWomen() {
		return numberOfWomen;
	}

	public void setNumberOfWomen(String numberOfWomen) {
		this.numberOfWomen = numberOfWomen;
	}

	public String getNumberOfKids() {
		return numberOfKids;
	}

	public void setNumberOfKids(String numberOfKids) {
		this.numberOfKids = numberOfKids;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public PagingList getHotelReservList() {
		return hotelReservList;
	}

	public void setHotelReservList(PagingList hotelReservList) {
		this.hotelReservList = hotelReservList;
	}
	
	

	public Map getReservation() {
		return reservation;
	}

	public void setReservation(Map reservation) {
		this.reservation = reservation;
	}

	/**
	 * 预订酒店房间
	 * 
	 * @return 一个提示页面，提示操作结果是否成功
	 */
	public String reserve() {
		super.debug(this.toString());
		try {
			super.getServiceManager().getReservationService().reserve_hotel(
					this.name, this.tel, this.email, this.hotelName,
					this.roomCategory, this.checkinDate, this.checkoutDate,
					this.numberOfMen, this.numberOfWomen, this.numberOfKids,
					this.remarks);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 预订页面管理中心首页
	 * 
	 * @return
	 */
	public String admin() {
		try {
			this.hotelReservList  = super.getServiceManager().getReservationService().getHoteReservList();
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return "admin";
	}

	/**
	 * 删除用户订单
	 * @return
	 */
	public String remove() {
		String Id = this.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(Id)){
			super.debug("订单Id:"+Id+" 是无效Id");
			return ERROR;
		}
		try {
			super.getServiceManager().getReservationService().removeHotelReserv(Id);
			super.setAlertMessage(AlertMessage.DELTE_SUCCESS);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		return this.admin();
	}

	/**
	 * 酒店订单详情
	 * @return
	 */
	public String detail(){
		String Id = this.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(Id)){
			super.debug("订单Id:"+Id+" 是无效Id");
			return ERROR;
		}
		
		try {
			this.reservation = super.getServiceManager().getReservationService().detail_hotel(Id);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		return "detail";
	}
	
	/**
	 * 标记为 “已处理”
	 * @return
	 */
	public String done(){
			String Id = this.getHttpServletRequest().getParameter("id");
			if(StringUtil.isEmpty(Id)){
				super.debug("订单Id:"+Id+" 是无效Id");
				return ERROR;
			}
		try {
			super.getServiceManager().getReservationService().hotelOrderDoneMark(Id);
			super.setAlertMessage(AlertMessage.DONE_MARK);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		return this.admin();
	}
	
	/**
	 * 标记为 “未处理”
	 * @return
	 */
	public String undone(){
		String Id = this.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(Id)){
			super.debug("订单Id:"+Id+" 是无效Id");
			return ERROR;
		}
	try {
		super.getServiceManager().getReservationService().hotelOrderUndoneMark(Id);
		super.setAlertMessage(AlertMessage.UNDONE_MARK);
	} catch (Exception e) {
		super.debug(e.getMessage());
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
		return "HotelReservation [checkinDate=" + checkinDate
				+ ", checkoutDate=" + checkoutDate + ", email=" + email
				+ ", hotelName=" + hotelName + ", name=" + name
				+ ", numberOfKids=" + numberOfKids + ", numberOfMen="
				+ numberOfMen + ", numberOfWomen=" + numberOfWomen
				+ ", remarks=" + remarks + ", roomCategory=" + roomCategory
				+ ", tel=" + tel + "]";
	}
	
}
