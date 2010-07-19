package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;

/**
 * 2010-7-18 9:23:37
 * @author Harry
 *
 */
public class ReservationService extends BaseService {

	private static final String SQL_HOTEL_RESERVATION = "INSERT INTO reservation_hotel(name,tel,email,hotelName,roomCategory,checkinDate,checkoutDate,men,women,kids,remarks,order_date) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,(select sysdate()from dual))";
	
	private static final String SQL_HOTEL_RESERVATION_BACKUP = "INSERT INTO reservation_hotel_backup(name,tel,email,hotelName,roomCategory,checkinDate,checkoutDate,men,women,kids,remarks,order_date) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,(select sysdate()from dual))";
	
	private static final String SQL_HOTEL_RESERVLIST = "SELECT * FROM reservation_hotel ORDER BY order_date desc";
	
	private static final String SQL_TRAVEL_RESERVLIST = "SELECT * FROM reservation_travel ORDER BY order_date desc";
	
	private static final String SQL_REMOVE_HOTELRESERV = "DELETE FROM reservation_hotel "
			+ "WHERE Id = ?";
	
	private static final String SQL_HOTEL_RESERVATION_DETAIL = "SELECT * FROM reservation_hotel WHERE Id =?";
	
	private static final String SQL_TRAVEL_RESERVATION_DETAIL = "SELECT * FROM reservation_travel WHERE Id =?";

	private static final String SQL_TRAVEL_RESERVATION = "INSERT INTO reservation_travel"
			+ "(touristNum,startDate,returnDate,replyDeadline,requirement,contactName,contactGender,contactPhone,contactEmail,order_date) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,(SELECT sysdate() FROM dual))";
	private static final String SQL_TRAVEL_RESERVATION_BACKUP = "INSERT INTO reservation_travel_backup"
		+ "(touristNum,startDate,returnDate,replyDeadline,requirement,contactName,contactGender,contactPhone,contactEmail,order_date) "
		+ "VALUES(?,?,?,?,?,?,?,?,?,(SELECT sysdate() FROM dual))";
	
	private static final String SQL_REMOVE_TRAVELRESERV = "DELETE FROM reservation_travel WHERE Id=?";

	private static final String SQL_HOTEL_ORDER_DONE_MARK = "UPDATE reservation_hotel "
			+ "SET done ='yes'" + " WHERE Id =?";

	private static final String SQL_HOTEL_ORDER_UNDONE_MARK = "UPDATE reservation_hotel "
			+ "SET done ='no'" + " WHERE Id =?";

	private static final String SQL_TRAVEL_ORDER_DONE_MARK = "UPDATE reservation_travel "
			+ "SET done ='yes'" + " WHERE Id =?";

	private static final String SQL_TRAVEL_ORDER_UNDONE_MARK = "UPDATE reservation_travel"
			+ " SET done ='no'" + " WHERE Id =?";

	/**
	 * 酒店预订
	 * 
	 * @param name
	 *            客户姓名
	 * @param tel
	 *            客户电话
	 * @param email
	 *            客户邮件地址
	 * @param hotelName
	 *            酒店名称
	 * @param roomCategory
	 *            客房类型
	 * @param checkinDate
	 *            入住时间
	 * @param checkoutDate
	 *            离开时间
	 * @param numberOfMen
	 *            男性数量
	 * @param numberOfWomen
	 *            女性数量
	 * @param numberOfKids
	 *            儿童数量
	 * @param remarks
	 *            备注
	 * @return
	 * @throws Exception
	 */

	public int reserve_hotel(String name, String tel, String email,
			String hotelName, String roomCategory, String checkinDate,
			String checkoutDate, String numberOfMen, String numberOfWomen,
			String numberOfKids, String remarks) throws Exception {
		// 备份
		super.DB.update(SQL_HOTEL_RESERVATION_BACKUP, new Object[] { name, tel,
				email, hotelName, roomCategory, checkinDate, checkoutDate,
				numberOfMen, numberOfWomen, numberOfKids, remarks });
		// 保存
		return super.DB.update(SQL_HOTEL_RESERVATION, new Object[] { name, tel,
				email, hotelName, roomCategory, checkinDate, checkoutDate,
				numberOfMen, numberOfWomen, numberOfKids, remarks });
	}

	/**
	 * 获得所有酒店预订列表
	 * 
	 * @return
	 */
	public PagingList getHoteReservList() throws Exception {
		return super.getPagingList(SQL_HOTEL_RESERVLIST);
	}

	/**
	 * 移除一个酒店订单
	 * 
	 * @param id
	 *            订单ID
	 * @return
	 * @throws Exception
	 */
	public int removeHotelReserv(String id) throws Exception {
		return super.DB.update(SQL_REMOVE_HOTELRESERV, new Object[] { id });
	}

	public Map detail_hotel(String id) throws Exception {
		return super.DB.queryForMap(SQL_HOTEL_RESERVATION_DETAIL,
				new Object[] { id });
	}

	/**
	 * 预订行程
	 * 
	 * @param numOfTourist
	 *            游客数量
	 * @param startDate
	 *            开始时间
	 * @param returnDate
	 *            返回时间
	 * @param replyDeadline
	 *            最晚回复时间
	 * @param requirements
	 *            要求
	 * @param contactName
	 *            联系人姓名
	 * @param contactGender
	 *            联系人性别
	 * @param contactPhone
	 *            联系人电话
	 * @param contactEmail
	 *            联系人邮件
	 * @return
	 * @throws Exception
	 */
	public int reserve_travel(String numOfTourist, String startDate,
			String returnDate, String replyDeadline, String requirements,
			String contactName, String contactGender, String contactPhone,
			String contactEmail) throws Exception {
//		备份
		super.DB.update(SQL_TRAVEL_RESERVATION_BACKUP, new Object[] {
				numOfTourist, startDate, returnDate, replyDeadline,
				requirements, contactName, contactGender, contactPhone,
				contactEmail });
//		存储
		return super.DB.update(SQL_TRAVEL_RESERVATION, new Object[] {
				numOfTourist, startDate, returnDate, replyDeadline,
				requirements, contactName, contactGender, contactPhone,
				contactEmail });
	}

	/**
	 *取消一个旅游行程预订
	 * 
	 * @param id
	 *            订单ID
	 * @return
	 */
	public int removeTravelReserv(String id) {
		return super.DB.update(SQL_REMOVE_TRAVELRESERV, new Object[] { id });
	}

	/**
	 *标记一个酒店订单为“已处理”
	 * 
	 * @param id
	 *            酒店订单ID
	 * @return
	 * @throws Exception
	 */
	public int hotelOrderDoneMark(String id) throws Exception {
		return super.DB.update(SQL_HOTEL_ORDER_DONE_MARK, new Object[] { id });
	}

	/**
	 * 标记一个酒店订单为“未处理”
	 * 
	 * @param id
	 *            酒店订单ID
	 * @return
	 * @throws Exception
	 */
	public int hotelOrderUndoneMark(String id) throws Exception {
		return super.DB
				.update(SQL_HOTEL_ORDER_UNDONE_MARK, new Object[] { id });
	}

	/**
	 * 标记一个旅游行程订单为“未处理”
	 * 
	 * @param id
	 *            旅游行程订单ID
	 * @return
	 */
	public int travelOrderUndoneMark(String id) throws Exception {
		return super.DB.update(SQL_TRAVEL_ORDER_UNDONE_MARK,
				new Object[] { id });
	}

	/**
	 * 标记一个旅游行程订单为“已处理”
	 * 
	 * @param id
	 *            旅游行程订单ID
	 * @throws Exception
	 */
	public int travelOrderDoneMark(String id) throws Exception {
		return super.DB.update(SQL_TRAVEL_ORDER_DONE_MARK, new Object[] { id });
	}

	/**
	 * 旅游行程订单 详细信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Map detail_travel(String id) throws Exception {
		return super.DB
				.queryForMap(SQL_TRAVEL_RESERVATION_DETAIL, new Object[] { id });
	}

	/**
	 * 获取全部旅游行程订单
	 * @return
	 */
	public PagingList getTravelReservList() throws Exception{
		return super.getPagingList(SQL_TRAVEL_RESERVLIST);
	}
}
