package ula.action.admin.reservation;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.StringUtil;

/**
 * 2010-7-16 10:59:24
 * 
 * @author Harry
 * 
 */
public class HotelReservation extends CommonAction {

	private String name;
	private String hotelName;
	private String checkinDate;
	private String checkoutDate;
	private String remarks;
	private String guestTotal;
	private String roomTotal;
	private String phoneType;
	private String phoneNumber;
	private String contactType;
	private String contact;

	private PagingList hotelReservList = null;
	private Map<String, Object> reservation = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getGuestTotal() {
		return guestTotal;
	}

	public void setGuestTotal(String guestTotal) {
		this.guestTotal = guestTotal;
	}

	public String getRoomTotal() {
		return roomTotal;
	}

	public void setRoomTotal(String roomTotal) {
		this.roomTotal = roomTotal;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public PagingList getHotelReservList() {
		return hotelReservList;
	}

	public void setHotelReservList(PagingList hotelReservList) {
		this.hotelReservList = hotelReservList;
	}

	public Map<String, Object> getReservation() {
		return reservation;
	}

	public void setReservation(Map<String, Object> reservation) {
		this.reservation = reservation;
	}

	/**
	 * 预订酒店房间
	 * 
	 * @return 一个提示页面，提示操作结果是否成功
	 */
	public String reserve() {
		try {
			getServiceManager().getReservationService().reserve_hotel(
					hotelName, guestTotal, roomTotal, checkinDate,
					checkoutDate, name, phoneType, phoneNumber, contactType,
					contact, remarks);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
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
			hotelReservList = getServiceManager().getReservationService()
					.getHoteReservList();
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}
		return "admin";
	}

	/**
	 * 删除用户订单
	 * 
	 * @return
	 */
	public String remove() {
		String Id = getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(Id)) {
			log.debug("订单Id:" + Id + " 是无效Id");
			return ERROR;
		}
		try {
			getServiceManager().getReservationService().removeHotelReserv(Id);
			setAlertMessage(AlertMessage.DELTE_SUCCESS);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}
		return this.admin();
	}

	/**
	 * 酒店订单详情
	 * 
	 * @return
	 */
	public String detail() {
		String Id = getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(Id)) {
			log.debug("订单Id:" + Id + " 是无效Id");
			return ERROR;
		}
		try {
			reservation = getServiceManager().getReservationService()
					.detail_hotel(Id);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}

		return "detail";
	}

	/**
	 * 标记为 “已处理”
	 * 
	 * @return
	 */
	public String done() {
		String Id = getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(Id)) {
			log.debug("订单Id:" + Id + " 是无效Id");
			return ERROR;
		}
		try {
			getServiceManager().getReservationService().hotelOrderDoneMark(Id);
			setAlertMessage(AlertMessage.DONE_MARK);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}

		return this.admin();
	}

	/**
	 * 标记为 “未处理”
	 * 
	 * @return
	 */
	public String undone() {
		String Id = getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(Id)) {
			log.debug("订单Id:" + Id + " 是无效Id");
			return ERROR;
		}
		try {
			getServiceManager().getReservationService()
					.hotelOrderUndoneMark(Id);
			setAlertMessage(AlertMessage.UNDONE_MARK);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}
		return this.admin();
	}

	@Override
	public String view() {
		super.view();
		log.debug(this.toString());
		return "view";
	}

	@Override
	public String toString() {
		return "HotelReservation [name=" + name + ", hotelName=" + hotelName
				+ ", checkinDate=" + checkinDate + ", checkoutDate="
				+ checkoutDate + ", remarks=" + remarks + ", guestTotal="
				+ guestTotal + ", roomTotal=" + roomTotal + ", phoneType="
				+ phoneType + ", phoneNumber=" + phoneNumber + ", contactType="
				+ contactType + ", contact=" + contact + ", hotelReservList="
				+ hotelReservList + ", reservation=" + reservation + "]";
	}

}
