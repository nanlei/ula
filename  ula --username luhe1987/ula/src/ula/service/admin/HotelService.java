package ula.service.admin;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ula.common.PagingList;
import ula.service.BaseService;
import ula.util.MapUtil;
import ula.util.QueryHelper;

public class HotelService extends BaseService {
	private static final String GET_ALL_HOTEL_PARAMS = "select * from hotel_param order by TYPE,ID";

	public PagingList getAllHotelParams() {
		return getPagingList(GET_ALL_HOTEL_PARAMS);
	}

	private static final String GET_CHECK_NAME_EXIST = "select count(*) from hotel_param where name=?";

	public int getCheckNameExist(Map parameters) {
		Object[] params = MapUtil
				.getObjectArrayFromMap(parameters, "paramName");
		return DB.queryForInt(GET_CHECK_NAME_EXIST, params);
	}

	private static final String ADD_HOTEL_PARAM = "insert into hotel_param(TYPE,NAME,VALUE) values(?,?,?)";

	public void addHotelParam(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"type,paramName,paramValue");
		DB.update(ADD_HOTEL_PARAM, params);
	}

	private static final String GET_HOTEL_PARAM_BY_ID = "select * from hotel_param where ID=?";

	public Map getHotelParamById(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		return DB.queryForMap(GET_HOTEL_PARAM_BY_ID, params);
	}

	private static final String UPDATE_HOTEL_PARAM_BY_ID = "update hotel_param set TYPE=?, VALUE=? where ID=?";

	public void updateHotelParam(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"type,paramValue,id");
		DB.update(UPDATE_HOTEL_PARAM_BY_ID, params);
	}

	private static final String DELETE_HOTEL_PARAM_BY_ID = "delete from hotel_param where ID=?";

	public void deleteHotelParam(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters, "id");
		DB.update(DELETE_HOTEL_PARAM_BY_ID, params);
	}

	private static final String GET_ALL_HOTEL_ALBUMS = "select * from album";

	public PagingList getAllHotelAlbums() {
		return getPagingList(GET_ALL_HOTEL_ALBUMS);
	}

	private static final String ADD_HOTEL_ALBUM = "insert into album(NAME,CONTENT,POSTTIME,USERNAME) values(?,?,now(),?)";

	public void addHotelAlbum(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"name,content");
		DB.update(ADD_HOTEL_ALBUM, new Object[] { params[0], params[1],
				userName });
	}

	private static final String GET_HOTEL_ALBUM_BY_ID = "select * from album where ID=?";

	public Map getHotelAlbumById(String albumId) {
		return DB.queryForMap(GET_HOTEL_ALBUM_BY_ID, new Object[] { albumId });
	}

	private static final String GET_PICS_IN_ALBUM_BY_ALBUM_ID = "select p.* from album_pic ap join album a on ap.ALBUMID=a.ID join pic p on ap.PICID=p.PICID where ap.ALBUMID=?";

	public List getPicsInAlbumByAlbumId(String albumId) {
		return DB.queryForList(GET_PICS_IN_ALBUM_BY_ALBUM_ID,
				new Object[] { albumId });
	}

	private static final String GEL_PICS_NOT_IN_ALBUM_BY_ALBUM_ID = "select p.* from pic p where p.PICID not in (select PICID from album_pic ap where ap.ALBUMID=?)";

	public PagingList getPicsNotInAlbumByAlbumId(String albumId) {
		return getPagingList(GEL_PICS_NOT_IN_ALBUM_BY_ALBUM_ID,
				new Object[] { albumId });
	}

	private static final String ADD_PIC_TO_ALBUM = "insert into album_pic(ALBUMID,PICID) values(?,?)";

	public void addPicToAlbum(String albumId, String picId) {
		DB.update(ADD_PIC_TO_ALBUM, new Object[] { albumId, picId });
	}

	private static final String DELETE_PIC_FROM_ALBUM = "delete from album_pic where ALBUMID=? and PICID=?";

	public void deletePicFromAlbum(String albumId, String picId) {
		DB.update(DELETE_PIC_FROM_ALBUM, new Object[] { albumId, picId });
	}

	private static final String UPDATE_ALBUM_BY_ID = "update album set NAME=?, CONTENT=? where ID=?";

	public void updateAlbumById(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"name,content,id");
		DB.update(UPDATE_ALBUM_BY_ID, params);
	}

	private static final String DELETE_PIC_FORM_ALBUM_BY_ALBUM_ID = "delete from album_pic where ALBUMID=?";

	private static final String DELETE_ALBUM_BY_ID = "delete from album where ID=?";

	public void deleteAlbumById(String id) {
		DB.update(DELETE_PIC_FORM_ALBUM_BY_ALBUM_ID, new Object[] { id });
		DB.update(DELETE_ALBUM_BY_ID, new Object[] { id });
	}

	private static final String GET_ALL_HOTELS = "select h.ID as ID, h.NAME as NAME, h.LOCATION as LOCATION, h.LEVEL as LEVEL, h.FUNC as FUNC, h.POSTTIME as POSTTIME,h.USERNAME as USERNAME, a.NAME as ALBUMNAME from hotel h join album a on h.ALBUMID=h.ID order by h.ID desc";

	public PagingList getAllHotels() {
		return getPagingList(GET_ALL_HOTELS);
	}

	private static final String GET_HOTEL_PARAM_BY_TYPE = "select * from hotel_param where TYPE=?";

	public List getHotelParamByType(String type) {
		return DB.queryForList(GET_HOTEL_PARAM_BY_TYPE, new Object[] { type });
	}

	private static final String GET_ALBUM_FOR_LIST = "select ID,NAME from album";

	public List getAlbumForList() {
		return DB.queryForList(GET_ALBUM_FOR_LIST);
	}

	private static final String ADD_HOTEL = "insert into hotel(NAME,LOCATION,LEVEL,FUNC,CONTENT,ALBUMID,POSTTIME,USERNAME) values(?,?,?,?,?,?,now(),?)";

	public void addHotel(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"name,location,level,func,content,albumId");
		DB.update(ADD_HOTEL, new Object[] { params[0], params[1], params[2],
				params[3], params[4], params[5], userName });
	}

	private static final String GET_HOTEL_BY_ID = "select h.*,a.NAME as ALBUMNAME from hotel h join album a on h.ALBUMID=a.ID where h.ID=?";

	public Map getHotelById(String id) {
		return DB.queryForMap(GET_HOTEL_BY_ID, new Object[] { id });
	}

	private static final String UPDATE_HOTEL_BY_ID = "update hotel set NAME=?, LOCATION=?, LEVEL=?, FUNC=?, CONTENT=?, ALBUMID=? where ID=?";

	public void updateHotelById(Map parameters) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"name,location,level,func,content,albumId,id");
		DB.update(UPDATE_HOTEL_BY_ID, params);

	}

	private static final String DELETE_HOTEL_BY_ID = "delete from hotel where ID=?";

	public void deleteHotelById(String id) {
		DB.update(DELETE_HOTEL_BY_ID, new Object[] { id });
	}

	private static final String GET_HOTEL_RECOMMAND = "select * from hotel_recommand where ID=1";

	public Map getHotelRecommand() {
		return DB.queryForMap(GET_HOTEL_RECOMMAND);
	}

	private static final String UPDATE_HOTEL_RECOMMAND = "update hotel_recommand set TITLE=?, CONTENT=?, UPDATETIME=now(), UPDATEUSER=? where ID=1";

	public void updateHotelRecommand(Map parameters, String userName) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameters,
				"title,content");
		DB.update(UPDATE_HOTEL_RECOMMAND, new Object[] { params[0], params[1],
				userName });
	}

	// 以下为前台方法
	private static final String GET_HOTEL_LEVEL_LIST = "select NAME,VALUE from hotel_param where type='level'";

	public List getHotelLevelList() {
		return DB.queryForList(GET_HOTEL_LEVEL_LIST);
	}

	private static final String GET_RECOMMAND_HOTEL = "select * from hotel_recommand where ID=1";

	public Map getRecommandHotel() {
		return DB.queryForMap(GET_RECOMMAND_HOTEL);
	}

	private static final String GET_SEARCH_HOTEL = "select ID,NAME from hotel";

	public List getSearchHotel(Map parameters) {
		String location = MapUtil.getStringFromMap(parameters, "location");
		String level = MapUtil.getStringFromMap(parameters, "level");
		String func = MapUtil.getStringFromMap(parameters, "func");
		QueryHelper qh = new QueryHelper(GET_SEARCH_HOTEL);
		qh.setParam(StringUtils.isNotEmpty(location), "location='" + location
				+ "'");
		qh.setParam(StringUtils.isNotEmpty(level), "level='" + level + "'");
		qh.setParam(StringUtils.isNotEmpty(func), "func='" + func + "'");
		System.out.println(qh.getQuerySql());
		return DB.queryForList(qh.getQuerySql());
	}

	private static final String GET_HOTEL_ALBUM_PIC = "select p.PICID as PICID, p.PICNAME as PICNAME, p.PICPATH as PICPATH from hotel h join album_pic ap on h.ALBUMID=ap.ALBUMID join pic p on ap.PICID=p.PICID where h.ID=? order by p.PICID asc";

	public List getHotelAlbumPicByHotelId(String id) {
		return DB.queryForList(GET_HOTEL_ALBUM_PIC, new Object[] { id });
	}

	private static final String GET_PARAM_VALUE_BY_NAME = "select VALUE from hotel_param where NAME=?";

	public String getParamValueByName(String name) {
		return (String) DB.queryForObject(GET_PARAM_VALUE_BY_NAME,
				new Object[] { name }, String.class);
	}

	private static final String GET_HOTEL_BY_LEVEL = "select ID,NAME from hotel where LEVEL=?";

	public List getHotelByLevel(String level) {
		return DB.queryForList(GET_HOTEL_BY_LEVEL, new Object[] { level });
	}

}
