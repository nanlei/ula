package ula.service.admin;

import java.util.List;
import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;

public class ArticleService extends BaseService {
	// 获取关于大连:景点公园文章
	private static final String SQL_GET_TOURS = "select * from article where TYPE in('dalian','lvshun','devzone')";

	public List<Map<String, Object>> getTours() {
		return jt.queryForList(SQL_GET_TOURS);
	}

	// 根据ID获取article表文章
	public static final String SQL_GET_ARTICLE_BY_ID = "select * from article where ID=?";

	public Map<String, Object> getArticleById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return jt.queryForMap(SQL_GET_ARTICLE_BY_ID, params);
	}

	// 根据ID更新article表文章
	private static final String SQL_UPDATE_ARTICLE_BY_ID = "update article set TITLE=?, CONTENT=?, COVERLINK=?, PRICE=?, USERNAME=?, ADDTIME=now() where ID=?";

	public void updateArticleById(Map<String, Object> parameters,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price,id");
		jt.update(SQL_UPDATE_ARTICLE_BY_ID, params[0], params[1], params[2],
				params[3], userName, params[4]);
	}

	// 根据TYPE获取article表文章
	private static final String SQL_GET_FOOD_ARTICLES = "select ID, TYPE, TITLE, USERNAME, ADDTIME, COVERLINK, PRICE from article where TYPE=? order by ADDTIME desc";

	public PagingList getArticlesByType(String articleType) {
		return getPagingList(SQL_GET_FOOD_ARTICLES, articleType);
	}

	// 向Article表添加文章
	private static final String SQL_ADD_ARTICLE = "insert into article(TYPE, TITLE, CONTENT, ADDTIME, COVERLINK, USERNAME, PRICE) values(?,?,?,now(),?,?,?)";

	public void addArticle(Map<String, Object> parameters, String articleType,
			String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		jt.update(SQL_ADD_ARTICLE, articleType, params[0], params[1],
				params[2], userName, params[3]);
	}

	// 根据ID删除Article表文章
	private static final String SQL_DELETE_ARTICLE_BY_ID = "delete from article where ID=?";

	public void deleteArticleById(Map<String, Object> parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		jt.update(SQL_DELETE_ARTICLE_BY_ID, params);
	}

	private static final String SQL_GET_FESTIVAL_ARTICLES = "select * from article where TYPE='festival'";

	public PagingList getFestivalArticles() {
		return getPagingList(SQL_GET_FESTIVAL_ARTICLES);
	}

	public static final String SQL_ADD_FESTIVAL = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('festival',?,?,now(),?,?,?)";

	public void addFestival(Map<String, Object> parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		jt.update(SQL_ADD_FESTIVAL, params[0], params[1], "", userName, "");
	}

	private static final String SQL_GET_EXHIBITION_ARTICLES = "select * from article where TYPE='exhibition'";

	public PagingList getExhibitionArticles() {
		return getPagingList(SQL_GET_EXHIBITION_ARTICLES);
	}

	private static final String SQL_ADD_EXHIBITION = "insert into article(TYPE,TITLE,CONTENT,ADDTIME,COVERLINK,USERNAME,PRICE) values('exhibition',?,?,now(),?,?,?)";

	public void addExhibition(Map<String, Object> parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content,coverLink,price");
		jt.update(SQL_ADD_EXHIBITION, params[0], params[1], "", userName, "");
	}

	private static final String SQL_GET_FIRST_ARTICLE_BY_TYPE = "select title,content from article where TYPE=? order by ID asc limit 1";

	public Map<String, Object> getFirstArticleByType(String type) {
		try {
			return jt.queryForMap(SQL_GET_FIRST_ARTICLE_BY_TYPE, type);
		} catch (Exception e) {
			return null;
		}
	}
}
