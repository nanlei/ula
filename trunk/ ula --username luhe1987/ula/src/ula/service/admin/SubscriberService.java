package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class SubscriberService extends BaseService {
	private static final String SQL_GET_ALL_SUBSCRIBERS = "select * from resource_subscriber order by ID desc";

	public PagingList getAllSubscribers() {
		return getPagingList(SQL_GET_ALL_SUBSCRIBERS);
	}

	private static final String SQL_DELETE_SUBSCRIBER_BY_ID = "delete from resource_subscriber where ID=?";

	public void deleteSubscriberById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		DB.update(SQL_DELETE_SUBSCRIBER_BY_ID, params);
	}

	private static final String SQL_GET_SUBSCRIBER_NUM = "select count(*) from resource_subscriber";

	public int getSubscriberNum() {
		return DB.queryForInt(SQL_GET_SUBSCRIBER_NUM);
	}
}
