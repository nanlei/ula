package ula.action.admin.hotel;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.MapUtil;

/**
 * 酒店相册Action
 * 
 * @author Nanlei
 * 
 */
public class HotelAlbumAction extends CommonAction {
	private PagingList hotelAlbums;
	private Map<String, Object> hotelAlbum;
	private List<Map<String, Object>> picsInAlbum;// 相册中的照片
	private PagingList picsNotInAlbum;// 不在相册中的照片

	public PagingList getHotelAlbums() {
		return hotelAlbums;
	}

	public Map<String, Object> getHotelAlbum() {
		return hotelAlbum;
	}

	public List<Map<String, Object>> getPicsInAlbum() {
		return picsInAlbum;
	}

	public PagingList getPicsNotInAlbum() {
		return picsNotInAlbum;
	}

	public String hotelalbum() {
		hotelAlbums = getServiceManager().getHotelService().getAllHotelAlbums();
		return "hotelalbum";
	}

	/**
	 * 添加酒店相册
	 * 
	 * @return
	 */
	public String addHotelAlbum() {
		try {
			getServiceManager().getHotelService().addHotelAlbum(
					getParametersAsMap(), getLoginUserName());
			this.setAlertMessage(AlertMessage.HOTEL_ALBUM_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.HOTEL_ALBUM_ADD_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 获取照片信息供修改
	 * 
	 * @return
	 */
	public String hotelAlbumPreUpdate() throws Exception {
		// 获取相册ID
		String albumId = MapUtil.getStringFromMap(getParametersAsMap(), "id");
		// 获取相册信息
		hotelAlbum = getServiceManager().getHotelService().getHotelAlbumById(
				albumId);
		// 获取相册内照片信息
		picsInAlbum = getServiceManager().getHotelService()
				.getPicsInAlbumByAlbumId(albumId);
		return "hotelAlbumPreUpdate";
	}

	/**
	 * 获取相册信息供添加照片
	 * 
	 * @return
	 */
	public String hotelAlbumPreAddPic() throws Exception {
		// 获取相册ID
		String albumId = MapUtil.getStringFromMap(getParametersAsMap(), "id");
		// 获取相册信息
		hotelAlbum = getServiceManager().getHotelService().getHotelAlbumById(
				albumId);
		// 获取剩余照片信息
		picsNotInAlbum = getServiceManager().getHotelService()
				.getPicsNotInAlbumByAlbumId(albumId);
		return "hotelAlbumPreAddPic";
	}

	/**
	 * 修改相册基本信息
	 * 
	 * @return
	 */
	public String updateAlbum() {
		try {
			getServiceManager().getHotelService().updateAlbumById(
					getParametersAsMap());
			this.setAlertMessage(AlertMessage.HOTEL_ALBUM_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.HOTEL_ALBUM_UPDATE_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 删除相册
	 * 
	 * @return
	 */
	public String hotelAlbumDelete() {
		String id = MapUtil.getStringFromMap(getParametersAsMap(), "id");
		try {
			getServiceManager().getHotelService().deleteAlbumById(id);
			this.setAlertMessage(AlertMessage.HOTEL_ALBUM_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.HOTEL_ALBUM_DELETE_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 添加照片到相册
	 * 
	 * @return
	 */
	public String hotelAlbumAddPic() {
		// 获取相册ID
		String albumId = MapUtil.getStringFromMap(getParametersAsMap(), "id");
		String[] picIds = getHttpServletRequest().getParameterValues("picIds");
		try {
			for (int i = 0; i < picIds.length; i++) {
				getServiceManager().getHotelService().addPicToAlbum(albumId,
						picIds[i]);
			}
			this.setAlertMessage(AlertMessage.HOTEL_ADD_PIC_TO_ALBUM_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this.setAlertMessage(AlertMessage.HOTEL_ADD_PIC_TO_ALBUM_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 从相册中删除照片
	 * 
	 * @return
	 */
	public String hotelAlbumDeletePic() {
		String albumId = MapUtil.getStringFromMap(getParametersAsMap(), "id");
		String[] picIds = getHttpServletRequest().getParameterValues("picIds");
		try {
			for (int i = 0; i < picIds.length; i++) {
				getServiceManager().getHotelService().deletePicFromAlbum(
						albumId, picIds[i]);
			}
			this
					.setAlertMessage(AlertMessage.HOTEL_DELETE_PIC_FROM_ALBUM_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			this
					.setAlertMessage(AlertMessage.HOTEL_DELETE_PIC_FROM_ALBUM_FALIURE);
			return ERROR;
		}
	}
}
