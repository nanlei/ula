package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;

public class PicService extends BaseService {
	private static final String SQL_GET_ALL_PICS = "select * from pic where PICTAG='common'";

	public PagingList getAllPics() {
		return getPagingList(SQL_GET_ALL_PICS);
	}

	private static final String SQL_ADD_PIC = "insert into pic(PICNAME,PICPATH,PICTIME,PICUSER,PICTAG) values(?,?,now(),?,?)";

	public void addPic(String picName, String picPath, String picUser,
			String picTag) {
		DB.update(SQL_ADD_PIC,
				new Object[] { picName, picPath, picUser, picTag });
	}

	private static final String SQL_GET_PIC_BY_ID = "select * from pic where PICID=?";

	public Map getPicInfoById(String picId) {
		return DB.queryForMap(SQL_GET_PIC_BY_ID, new Object[] { picId });
	}

	private static final String SQL_DEL_PIC_BY_ID = "delete from pic where PICID=?";

	public void deletePicById(String picId) {
		DB.update(SQL_DEL_PIC_BY_ID, new Object[] { picId });
	}

	private static final String SQL_GET_ALL_EDITOR_PICS = "select * from pic where PICTAG='editor'";

	public PagingList getAllEditorPics() {
		return getPagingList(SQL_GET_ALL_EDITOR_PICS);
	}

	private static final String SQL_GET_PICS_BY_TYPE = "select * from pic where PICTAG=?";

	public PagingList getPicsByType(String type) {
		return getPagingList(SQL_GET_PICS_BY_TYPE, new Object[] { type });
	}
}
