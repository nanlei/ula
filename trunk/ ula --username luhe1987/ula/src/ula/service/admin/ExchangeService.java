package ula.service.admin;

import java.util.List;
import java.util.Map;

import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 汇率管理Service
 * 
 * @author Nanlei
 * 
 */
public class ExchangeService extends BaseService {
	private static final String SQL_GET_ALL_EXCHANGE_RATE = "select ID, TITLE, PUB_DATE, VALUE, TAG from exchange_rate order by TAG desc,ID asc";

	public List<Map<String, Object>> getAllExchangeRate() {
		return jt.queryForList(SQL_GET_ALL_EXCHANGE_RATE);
	}

	private static final String SQL_GET_DISPLAY_COUNT = "select count(*) from exchange_rate where TAG=1";

	public int getDisplayCount() {
		return jt.queryForInt(SQL_GET_DISPLAY_COUNT);
	}

	private static final String SQL_UPDATE_TAG_BY_ID = "update exchange_rate set TAG=? where ID=?";

	public void updateTagById(Map<String, Object> parameters, int tag) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		if (tag == 1) {
			if (getDisplayCount() < 8) {
				jt.update(SQL_UPDATE_TAG_BY_ID, tag, params[0]);
			}
		} else {
			jt.update(SQL_UPDATE_TAG_BY_ID, tag, params[0]);
		}
	}
}
