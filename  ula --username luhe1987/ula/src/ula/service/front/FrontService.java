package ula.service.front;

import java.util.List;
import java.util.Map;

import ula.service.BaseService;
import ula.util.MapUtil;

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

	private static final String SQL_GET_SPECIAL_BY_TAG = "select * from special where TAG=?";

	public Map<String, Object> getSpecialByTag(String tag) {
		return jt.queryForMap(SQL_GET_SPECIAL_BY_TAG, tag);
	}

	// private static final String
	// SQL_GET_TOUR_BY_PRODUCT_ID="select from product_";
}
