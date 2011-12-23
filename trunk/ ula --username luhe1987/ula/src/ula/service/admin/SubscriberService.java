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
		jt.update(SQL_DELETE_SUBSCRIBER_BY_ID, params);
	}

	private static final String SQL_GET_SUBSCRIBER_NUM = "select count(*) from resource_subscriber";

	public int getSubscriberNum() {
		return jt.queryForInt(SQL_GET_SUBSCRIBER_NUM);
	}

	private static final String SQL_GET_CHECK_SUBSCRIBER = "select count(*) from resource_subscriber where EMAIL=?";

	public int getCheckSubscriber(String email) {
		return jt.queryForInt(SQL_GET_CHECK_SUBSCRIBER, email);
	}

	private static final String SQL_ADD_SUBSCRIBER = "insert into resource_subscriber(EMAIL,REGTIME,REGIP) values(?,now(),?)";

	public void addSubscriber(String email, String ip) {
		jt.update(SQL_ADD_SUBSCRIBER, email, ip);
	}

	private static final String SQL_DELETE_SUBSCRIBER_BY_EMAIL = "delete from resource_subscriber where EMAIL=?";

	public void deleteSubscriberByEmail(String email) {
		jt.update(SQL_DELETE_SUBSCRIBER_BY_EMAIL, email);
	}
}
