package ula.service.admin;

import java.util.List;
import java.util.Map;

import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 联系我们
 * 
 * @author Nanlei
 * 
 */
public class ContactService extends BaseService {
	private static final String SQL_GET_ALL_CONTACT = "select ID, TITLE, TAG, USERNAME, DATE from contact";

	public List<Map<String, Object>> getAllContact() {
		return jt.queryForList(SQL_GET_ALL_CONTACT);
	}

	private static final String SQL_GET_CONTACT_BY_ID = "select * from contact where ID=?";

	public Map<String, Object> getContactById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_CONTACT_BY_ID, params);
	}

	private static final String SQL_UPDATE_CONTACT_BY_ID = "update contact set TITLE=?, CONTENT=?, USERNAME=?, DATE=now() where ID=?";

	public void updateContactById(Map<String, Object> parameters,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,id");
		jt.update(SQL_UPDATE_CONTACT_BY_ID, params[0], params[1], userName,
				params[2]);
	}
}
