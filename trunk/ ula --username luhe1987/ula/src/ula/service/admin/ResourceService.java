package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class ResourceService extends BaseService {
	private static final String SQL_GET_ALL_RESOURCE = "select * from resource order by ID desc";

	public PagingList getAllResource() {
		return getPagingList(SQL_GET_ALL_RESOURCE);
	}

	private static final String SQL_ADD_RESOURCE = "insert into resource(TITLE,CONTENT,UPDATETIME,TAG,COUNTER,USERNAME) values(?,?,now(),0,0,?)";

	public void addResource(Map<String, Object> parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content");
		jt.update(SQL_ADD_RESOURCE, params[0], params[1], userName);
	}

	private static final String SQL_GET_RESOURCE_BY_ID = "select * from resource where ID=?";

	public Map<String, Object> getResourceById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_RESOURCE_BY_ID, params);
	}

	private static final String SQL_UPDATE_RESOURCE_BY_ID = "update resource set TITLE=?, CONTENT=?, USERNAME=? where ID=?";

	public void updateResourceById(Map<String, Object> parameters,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,id");
		jt.update(SQL_UPDATE_RESOURCE_BY_ID, params[0], params[1], userName,
				params[2]);
	}

	private static final String SQL_DELETE_RESOURCE_BY_ID = "delete from resource where ID=?";

	public void deleteResourceById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		jt.update(SQL_DELETE_RESOURCE_BY_ID, params);
	}
}
