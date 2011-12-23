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

	public void addRecommend(Map<String, Object> parameters, String filePath,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,tag,content");
		jt.update(SQL_ADD_RECOMMEND, params[0], filePath, params[2], params[1],
				userName);
	}

	private static final String SQL_GET_RECOMMEND_BY_ID = "select * from recommend where ID=?";

	public Map<String, Object> getRecommendById(Map<String, Object> parameters) {
		String id = MapUtil.getStringFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_RECOMMEND_BY_ID, id);
	}

	private static final String SQL_UPDATE_RECOMMEND_NO_COVER = "update recommend set TITLE=?, CONTENT=?, UPDATETIME=now(), TAG=?, USERNAME=? where ID=?";

	public void updateRecommend(Map<String, Object> parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,tag,id");
		jt.update(SQL_UPDATE_RECOMMEND_NO_COVER, params[0], params[1],
				params[2], userName, params[3]);
	}

	private static final String SQL_UPDATE_RECOMMEND = "update recommend set TITLE=?, CONTENT=?, COVER=?, UPDATETIME=now(), TAG=?, USERNAME=? where ID=?";

	public void updateRecommend(Map<String, Object> parameters,
			String filePath, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,tag,id");
		jt.update(SQL_UPDATE_RECOMMEND, params[0], params[1], filePath,
				params[2], userName, params[3]);
	}

	private static final String SQL_DELETE_RECOMMEND = "delete from recommend where ID=?";

	public void deleteRecommendById(Map<String, Object> parameters) {
		String id = MapUtil.getStringFromMap(parameters, "id");
		jt.update(SQL_DELETE_RECOMMEND, id);
	}

}
