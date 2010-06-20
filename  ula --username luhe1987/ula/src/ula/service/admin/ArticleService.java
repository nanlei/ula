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

	public static final String SQL_GET_ARTICLE_BY_ID = "select * from article where ID=?";

	public Map getArticleById(String articleId) {
		return DB
				.queryForMap(SQL_GET_ARTICLE_BY_ID, new Object[] { articleId });
	}

	private static final String SQL_SET_ARTICLE_BY_ID = "update article set TITLE=?,CONTENT=?,COVERLINK=? where ID=?";

	public void updateArticleById(Map parameters, String articleId) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink");
		DB.update(SQL_SET_ARTICLE_BY_ID, new Object[] { params[0], params[1],
				params[2], articleId });
	}

	private static final String SQL_SET_TOUR_BY_ID = "update article set type=?,TITLE=?,CONTENT=?,COVERLINK=? where ID=?";

	public void updateTourById(Map parameters, String articleId) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"articleType,title,content,coverLink");
		DB.update(SQL_SET_TOUR_BY_ID, new Object[] { params[0], params[1],
				params[2], params[3], articleId });
	}

	private static final String SQL_DEL_ARTICLE_BY_ID = "delete from article where ID=?";

	public void deleteArticleById(String articleId) {
		DB.update(SQL_DEL_ARTICLE_BY_ID, new Object[] { articleId });
	}

	private static final String SQL_GET_FOOD_ARTICLES = "select * from article where TYPE='food'";

	public PagingList getFoodArticles() {
		return getPagingList(SQL_GET_FOOD_ARTICLES);
	}

	private static final String SQL_ADD_FOOD = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME) values('food',?,?,now(),?,?)";

	public void addFood(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink");
		DB.update(SQL_ADD_FOOD, new Object[] { params[0], params[1], params[2],
				userName });
	}

	private static final String SQL_GET_HOUSING_ARTICLES = "select * from article where TYPE='housing'";

	public PagingList getHousingArticles() {
		return getPagingList(SQL_GET_HOUSING_ARTICLES);
	}

	private static final String SQL_ADD_HOUSING = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME) values('housing',?,?,now(),?,?)";

	public void addHousing(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink");
		DB.update(SQL_ADD_HOUSING, new Object[] { params[0], params[1],
				params[2], userName });
	}

}
