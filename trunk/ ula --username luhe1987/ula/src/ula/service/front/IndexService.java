package ula.service.front;

import java.util.List;
import java.util.Map;

import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 首页Service
 * 
 * @author Nanlei
 * 
 */
public class IndexService extends BaseService {
	private static final String SQL_GET_RECOMMENDS = "select ID, COVER, TITLE,LINK from recommend where TAG=1 order by UPDATETIME desc";

	public List<Map<String, Object>> getRecommendList() {
		return jt.queryForList(SQL_GET_RECOMMENDS);
	}

	private static final String SQL_GET_PRODUCTS = "select ID, NAME, PRICE, COVER, LINK from product where TAG=1 order by ID desc limit 12";

	public List<Map<String, Object>> getProductList() {
		return jt.queryForList(SQL_GET_PRODUCTS);
	}

	private static final String SQL_GET_WEATHER = "select * from weather where CITYCODE='101070201'";

	public Map<String, Object> getWeather() {
		return jt.queryForMap(SQL_GET_WEATHER);
	}

	private static final String SQL_GET_LINKS = "select TITLE,URL from link where TAG=1";

	public List<Map<String, Object>> getLinkList() {
		return jt.queryForList(SQL_GET_LINKS);
	}

	private static final String SQL_GET_EXCHANGE_RATE = "select * from exchange_rate where TAG=1 order by ID asc";

	public List<Map<String, Object>> getExchangeRate() {
		return jt.queryForList(SQL_GET_EXCHANGE_RATE);
	}

	private static final String SQL_GET_RECOMMEND_BY_ID = "select COVER, TITLE, CONTENT,LINK from recommend where TAG=1 and ID=?";

	public Map<String, Object> getRecommendById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_RECOMMEND_BY_ID, params);
	}

	private static final String SQL_GET_PRODUCT_TAG_BY_ID = "select TAG from product where ID=?";

	private static final String SQL_GET_PRODUCT_BY_ID = "select t.ID as ID, t.TITLE as TITLE, t.COVERLINK as COVERLINK, t.DESCRIPTION as DESCRIPTION, t.COVERLINK as LINK from tour t, product_tour pt where t.ID=pt.TOUR_ID and pt.PRODUCT_ID=?";

	public List<Map<String, Object>> getProductById(
			Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		int tag = (Integer) jt.queryForObject(SQL_GET_PRODUCT_TAG_BY_ID,
				Integer.class, params);
		if (tag == 1) {
			return jt.queryForList(SQL_GET_PRODUCT_BY_ID, params);
		} else {
			return null;
		}
	}

	private static final String SQL_GET_HOTEL_BY_ID = "select * from hotel where ID=?";

	public Map<String, Object> getHotelById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_HOTEL_BY_ID, params);
	}
}
