package ula.action.admin.reservation;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.StringUtil;

public class TravelReservation extends CommonAction {
	private String numOfTourist;
	private String startDate;
	private String returnDate;
	private String replyDeadline;
	private String requirements; // 客户要求，旅游路线
	private String contactName;
	private String contactGender;
	private String contactPhone;
	private String contactEmail;

	private PagingList travelReservList = null;
	private Map<String, Object> travelReserv = null;

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

	public Map<String, Object> getTravelReserv() {
		return travelReserv;
	}

	public void setTravelReserv(Map<String, Object> travelReserv) {
		this.travelReserv = travelReserv;
	}

	/**
	 * 保存用户订单
	 * 
	 * @return
	 */
	public String reserve() {
		try {
			getServiceManager().getReservationService().reserve_travel(
					numOfTourist, startDate, returnDate, replyDeadline,
					requirements, contactName, contactGender, contactPhone,
					contactEmail);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 订单管理页面
	 * 
	 * @return
	 */
	public String admin() {
		try {
			travelReservList = getServiceManager().getReservationService()
					.getTravelReservList();
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}
		return "admin";
	}

	/**
	 * 移除订单
	 * 
	 * @return
	 */
	public String remove() {
		String Id = getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(Id)) {
			log.debug("订单id: " + Id + "是一个无效id");
			return ERROR;
		}
		getServiceManager().getReservationService().removeTravelReserv(Id);
		setAlertMessage(AlertMessage.DELTE_SUCCESS);
		return this.admin();
	}

	/**
	 * 订单详细信息
	 * 
	 * @return
	 */
	public String detail() {
		String Id = this.getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(Id)) {
			log.debug("订单Id:" + Id + " 是无效Id");
			return ERROR;
		}
		try {
			travelReserv = getServiceManager().getReservationService()
					.detail_travel(Id);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}
		return "detail";
	}

	/**
	 * 标记为“已处理”
	 * 
	 * @return
	 */
	public String done() {
		String Id = this.getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(Id)) {
			log.debug("订单Id:" + Id + " 是无效Id");
			return ERROR;
		}
		try {
			getServiceManager().getReservationService().travelOrderDoneMark(Id);
			setAlertMessage(AlertMessage.DONE_MARK);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return ERROR;
		}
		return this.admin();
	}

	/**
	 * 标记为“未处理”
	 * 
	 * @return
	 */
	public String undone() {
		String Id = this.getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(Id)) {
			log.debug("订单Id:" + Id + " 是无效Id");
			return ERROR;
		}
		try {
			getServiceManager().getReservationService().travelOrderUndoneMark(
					Id);
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
