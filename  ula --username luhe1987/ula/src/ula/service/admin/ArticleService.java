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

	public static final String SQL_ADD_TOUR = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values(?,?,?,now(),?,?,?)";

	public void addTour(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"articleType,title,content,coverLink,price");
		DB.update(SQL_ADD_TOUR, new Object[] { params[0], params[1], params[2],
				"", userName, "" });
	}

	public static final String SQL_GET_ARTICLE_BY_ID = "select * from article where ID=?";

	public Map getArticleById(String articleId) {
		return DB
				.queryForMap(SQL_GET_ARTICLE_BY_ID, new Object[] { articleId });
	}

	private static final String SQL_SET_ARTICLE_BY_ID = "update article set TITLE=?,CONTENT=?,COVERLINK=?,PRICE=? where ID=?";

	public void updateArticleById(Map parameters, String articleId) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		DB.update(SQL_SET_ARTICLE_BY_ID, new Object[] { params[0], params[1],
				"", "", articleId });
	}

	private static final String SQL_SET_TOUR_BY_ID = "update article set TYPE=?,TITLE=?,CONTENT=?,COVERLINK=?,PRICE=? where ID=?";

	public void updateTourById(Map parameters, String articleId) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"articleType,title,content,coverLink,price");
		DB.update(SQL_SET_TOUR_BY_ID, new Object[] { params[0], params[1],
				params[2], "", "", articleId });
	}

	private static final String SQL_DEL_ARTICLE_BY_ID = "delete from article where ID=?";

	public void deleteArticleById(String articleId) {
		DB.update(SQL_DEL_ARTICLE_BY_ID, new Object[] { articleId });
	}

	private static final String SQL_GET_FOOD_ARTICLES = "select * from article where TYPE='food'";

	public PagingList getFoodArticles() {
		return getPagingList(SQL_GET_FOOD_ARTICLES);
	}

	private static final String SQL_ADD_FOOD = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('food',?,?,now(),?,?,?)";

	public void addFood(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		DB.update(SQL_ADD_FOOD, new Object[] { params[0], params[1], "",
				userName, "" });
	}

	private static final String SQL_GET_HOUSING_ARTICLES = "select * from article where TYPE='housing'";

	public PagingList getHousingArticles() {
		return getPagingList(SQL_GET_HOUSING_ARTICLES);
	}

	private static final String SQL_ADD_HOUSING = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('housing',?,?,now(),?,?,?)";

	public void addHousing(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		DB.update(SQL_ADD_HOUSING, new Object[] { params[0], params[1], "",
				userName, "" });
	}

	private static final String SQL_GET_SHOPPING_ARTICLES = "select * from article where TYPE='shopping'";

	public PagingList getShoppingArticles() {
		return getPagingList(SQL_GET_SHOPPING_ARTICLES);
	}

	private static final String SQL_ADD_SHOPPING = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('shopping',?,?,now(),?,?,?)";

	public void addShopping(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		DB.update(SQL_ADD_SHOPPING, new Object[] { params[0], params[1], "",
				userName, "" });
	}

	private static final String SQL_GET_TRANSPORTATION_ARTICLES = "select * from article where TYPE='transportation'";

	public PagingList getTransportationArticles() {
		return getPagingList(SQL_GET_TRANSPORTATION_ARTICLES);
	}

	private static final String SQL_ADD_TRANSPORTATION = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('transportation',?,?,now(),?,?,?)";

	public void addTransportation(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		DB.update(SQL_ADD_TRANSPORTATION, new Object[] { params[0], params[1],
				"", userName, "" });
	}

	private static final String SQL_GET_THERAPY_ARTICLES = "select * from article where TYPE='therapy'";

	public PagingList getTherapyArticles() {
		return getPagingList(SQL_GET_THERAPY_ARTICLES);
	}

	private static final String SQL_ADD_THERAPY = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('therapy',?,?,now(),?,?,?)";

	public void addTherapy(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		DB.update(SQL_ADD_THERAPY, new Object[] { params[0], params[1], "",
				userName, "" });
	}

	private static final String SQL_GET_FESTIVAL_ARTICLES = "select * from article where TYPE='festival'";

	public PagingList getFestivalArticles() {
		return getPagingList(SQL_GET_FESTIVAL_ARTICLES);
	}

	public static final String SQL_ADD_FESTIVAL = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('festival',?,?,now(),?,?,?)";

	public void addFestival(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		DB.update(SQL_ADD_FESTIVAL, new Object[] { params[0], params[1], "",
				userName, "" });
	}

	private static final String SQL_GET_EXHIBITION_ARTICLES = "select * from article where TYPE='exhibition'";

	public PagingList getExhibitionArticles() {
		return getPagingList(SQL_GET_EXHIBITION_ARTICLES);
	}

	private static final String SQL_ADD_EXHIBITION = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('exhibition',?,?,now(),?,?,?)";

	public void addExhibition(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		DB.update(SQL_ADD_EXHIBITION, new Object[] { params[0], params[1], "",
				userName, "" });
	}

	private static final String SQL_GET_FIRST_ARTICLE_BY_TYPE = "select title,content from article where TYPE=? order by ID asc limit 1";

	public Map getFirstArticleByType(String type) {
		try {
			return DB.queryForMap(SQL_GET_FIRST_ARTICLE_BY_TYPE,
					new Object[] { type });
		} catch (Exception e) {
			return null;
		}
	}
}
