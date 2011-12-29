package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

/**
 * 友情链接管理Service
 * 
 * @author Nanlei
 * 
 */
public class LinkService extends BaseService {
	private static final String SQL_GET_ALL_LINKS = "select * from link order by ID desc";

	public PagingList getAllLinks() {
		return getPagingList(SQL_GET_ALL_LINKS);
	}

	private static final String SQL_GET_LINK_BY_ID = "select * from link where id=?";

	public Map<String, Object> getLinkById(Map<String, Object> parameters)
			throws Exception {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_LINK_BY_ID, params);
	}

	private static final String SQL_ADD_LINK = "insert into link(TITLE, URL, USERNAME, TAG, DATE) VALUES(?, ?, ?, ?, now())";

	public int addInfo(Map<String, Object> parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,url,tag");
		return jt.update(SQL_ADD_LINK, params[0], params[1], userName,
				params[2]);
	}

	private static final String SQL_UPDATE_LINK_BY_ID = "update link set TITLE=?, URL=?, USERNAME=?, TAG=?, DATE=now() where ID=?";

	public void updateLinkById(Map<String, Object> parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,url,tag,id");
		jt.update(SQL_UPDATE_LINK_BY_ID, params[0], params[1], userName,
				params[2], params[3]);
	}

	private static final String SQL_DELETE_LINK_BY_ID = "delete from link where ID=?";

	public void deleteLinkById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		jt.update(SQL_DELETE_LINK_BY_ID, params);
	}
}
