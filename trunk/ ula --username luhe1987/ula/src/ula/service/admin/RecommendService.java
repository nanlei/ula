package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class RecommendService extends BaseService {
	private static final String SQL_GET_ALL_RECOMMENDS = "select ID,TITLE,UPDATETIME,TAG,USERNAME from recommend";

	public PagingList getAllRecommends() {
		return getPagingList(SQL_GET_ALL_RECOMMENDS);
	}

	private static final String SQL_ADD_RECOMMEND = "insert into recommend(title,cover,content,updatetime,tag,username) values(?,?,?,now(),?,?)";

	public void addRecommend(Map parameters, String filePath, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,tag,content");
		DB.update(SQL_ADD_RECOMMEND, new Object[] { params[0], filePath,
				params[2], params[1], userName });
	}
}
