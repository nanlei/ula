package ula.service.front;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import ula.service.BaseService;
import ula.util.MapUtil;
import ula.util.QueryHelper;

/**
 * 前台功能Service
 * 
 * @author Nanlei
 * 
 */
public class FrontService extends BaseService {
	private static final String SQL_GET_CITY_INFO_BY_TAG = "select * from city where TAG=?";

	public Map<String, Object> getCityInfoByTag(String tag) {
		return jt.queryForMap(SQL_GET_CITY_INFO_BY_TAG, tag);
	}

	private static final String SQL_GET_CITY_TOUR_BY_TYPE = "select * from article where TYPE=?";

	public Map<String, Object> getCityTourByType(String type) {
		return jt.queryForMap(SQL_GET_CITY_TOUR_BY_TYPE, type);
	}

	private static final String SQL_GET_ARTICLES_BY_TYPE = "select ID,TITLE from article where TYPE=?";

	public List<Map<String, Object>> getArticleListByType(String type) {
		return jt.queryForList(SQL_GET_ARTICLES_BY_TYPE, type);
	}

	private static final String SQL_GET_ARTICLE_BY_ID = "select * from article where ID=?";

	public Map<String, Object> getArticleById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_ARTICLE_BY_ID, params);
	}

	private static final String SQL_GET_TOUR_BY_CATEGORY_TAG = "select t.ID, t.TITLE from tour t,tour_category tc where t.CATEGORY_ID=tc.ID and tc.TAG=?";

	public List<Map<String, Object>> getTourByCategoryTag(String tag) {
		return jt.queryForList(SQL_GET_TOUR_BY_CATEGORY_TAG, tag);
	}

	private static final String SQL_GET_TOUR_BY_ID = "select TITLE, DESCRIPTION, COVERLINK, CONTENT from tour where ID=?";

	public Map<String, Object> getTourById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_TOUR_BY_ID, params);
	}

	private static final String SQL_GET_SPECIAL_BY_TAG = "select * from special where TAG=?";

	public Map<String, Object> getSpecialByTag(String tag) {
		return jt.queryForMap(SQL_GET_SPECIAL_BY_TAG, tag);
	}

	// 预定酒店
	private static final String SQL_ADD_HOTE_RESERVATION = "insert into reservation_hotel(HOTEL_NAME,GUEST_TOTAL,ROOM_TOTAL,CHECK_IN_DATE,CHECK_OUT_DATE,CONTACT,PHONE_TYPE,PHONE_NUMBER,CONTACT_TYPE,CONTACT_VALUE,REMARKS,TAG,POST_TIME) values(?,?,?,?,?,?,?,?,?,?,?,0,now())";

	public void addHotelReservation(Map<String, Object> parameters) {
		Object[] params = MapUtil
				.getObjectArrayFromMap(
						parameters,
						"hotelName,guestTotal,roomTotal,checkinDate,checkoutDate,contact,phoneType,phoneNumber,contactType,contactValue,remarks");
		jt.update(SQL_ADD_HOTE_RESERVATION, params);
	}

	private static final String SQL_GET_CONTACT_BY_TAG = "select TITLE, CONTENT from contact where TAG=?";

	public Map<String, Object> getContactByTag(String tag) {
		return jt.queryForMap(SQL_GET_CONTACT_BY_TAG, tag);
	}

	public List<Map<String, Object>> getSearchHotel(
			Map<String, Object> parameters) {
		QueryHelper qh = new QueryHelper("select ID, NAME from hotel");
		String location = MapUtil.getStringFromMap(parameters, "location");
		String level = MapUtil.getStringFromMap(parameters, "level");
		String func = MapUtil.getStringFromMap(parameters, "func");
		qh.setParam(StringUtils.isNotEmpty(location), "LOCATION=?", location);
		qh.setParam(StringUtils.isNotEmpty(level), "LEVEL=?", level);
		qh.setParam(StringUtils.isNotEmpty(func), "FUNC=?", func);
		return jt.queryForList(qh.getQuerySql(), qh.getParams());
	}

	public List<Map<String, Object>> getSearchHotelByLevel(
			HttpServletRequest request) {
		StringBuffer sqlBuffer = new StringBuffer(
				"select ID,NAME from hotel where LEVEL in(");
		String sql = null;
		String[] levels = request.getParameterValues("level");
		if (levels == null) {
			sql = "select ID,NAME from hotel";
		} else {
			for (int i = 0; i < levels.length; i++) {
				sqlBuffer.append("'").append(levels[i]).append("',");
			}
			sql = sqlBuffer.substring(0, sqlBuffer.toString().length() - 1)
					+ ")";
		}
		return jt.queryForList(sql);
	}

	public List<Map<String, Object>> getTourCategoryByVacationType(
			HttpServletRequest request) {
		StringBuffer sqlBuffer = new StringBuffer(
				"select distinct CATEGORY_ID from tour_category_vacation_type where VACATION_TYPE_ID in(");
		String sql = null;
		String[] types = request.getParameterValues("travel_type");
		if (types == null) {
			sql = "select distinct CATEGORY_ID from tour_category_vacation_type";
		} else {
			for (int i = 0; i < types.length; i++) {
				sqlBuffer.append("'").append(types[i]).append("',");
			}
			sql = sqlBuffer.substring(0, sqlBuffer.toString().length() - 1)
					+ ")";
		}
		return jt.queryForList(sql);
	}

	public List<Map<String, Object>> getSearchTour(HttpServletRequest request) {
		List<Map<String, Object>> categoryIds = getTourCategoryByVacationType(request);
		StringBuffer sqlBuffer = new StringBuffer(
				"select ID,TITLE from tour where CATEGORY_ID in(");
		String sql = null;
		if (categoryIds.size() == 0) {
			sql = "select ID,TITLE from tour";
		} else {
			for (int i = 0; i < categoryIds.size(); i++) {
				sqlBuffer.append("'").append(
						categoryIds.get(i).get("CATEGORY_ID")).append("',");
			}
			sql = sqlBuffer.substring(0, sqlBuffer.toString().length() - 1)
					+ ")";
		}
		return jt.queryForList(sql);
	}
}
