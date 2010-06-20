package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class ArticleService extends BaseService {
	private static final String SQL_GET_TOURS_BY_TYPE = "select * from article where TYPE=?";

	public PagingList getToursByType(String type) {
		return getPagingList(SQL_GET_TOURS_BY_TYPE, new Object[] { type });
	}

	public static final String SQL_ADD_TOUR = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME) values(?,?,?,now(),?,?)";

	public void addTour(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"articleType,title,content,coverLink");
		DB.update(SQL_ADD_TOUR, new Object[] { params[0], params[1], params[2],
				params[3], userName });
	}
}
