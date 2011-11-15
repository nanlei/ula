package ula.action.admin.hotel;

import java.util.List;
import java.util.Map;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.MapUtil;

/**
 * 酒店文章管理Action
 * 
 * @author Nanlei
 * 
 */
public class HotelArticleAction extends CommonAction {
	private PagingList hotelList;
	private Map hotelInfo;
	private List locationList;// 酒店位置
	private List levelList;// 酒店星级
	private List funcList;// 酒店功能
	private List albumList;// 酒店相册

	private Map recommandInfo;// 酒店推荐信息

	public PagingList getHotelList() {
		return hotelList;
	}

	public Map getHotelInfo() {
		return hotelInfo;
	}

	public List getLocationList() {
		return locationList;
	}

	public List getLevelList() {
		return levelList;
	}

	public List getFuncList() {
		return funcList;
	}

	public List getAlbumList() {
		return albumList;
	}

	public Map getRecommandInfo() {
		return recommandInfo;
	}

	/**
	 * 获取所有酒店文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String hotelarticle() throws Exception {
		hotelList = getServiceManager().getHotelService().getAllHotels();
		locationList = getServiceManager().getHotelService()
				.getHotelParamByType("location");
		levelList = getServiceManager().getHotelService().getHotelParamByType(
				"level");
		funcList = getServiceManager().getHotelService().getHotelParamByType(
				"func");
		albumList = getServiceManager().getHotelService().getAlbumForList();
		return "hotelarticle";
	}

	/**
	 * 添加酒店文章
	 * 
	 * @return
	 */
	public String hotelArticleAdd() {
		try {
			getServiceManager().getHotelService().addHotel(
					getParametersAsMap(), getLoginUserName());
			this.setAlertMessage(AlertMessage.HOTEL_ADD_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			this.setAlertMessage(AlertMessage.HOTEL_ADD_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 获取酒店信息供修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String hotelArticlePreUpdate() throws Exception {
		String id = MapUtil.getStringFromMap(getParametersAsMap(), "id");
		hotelInfo = getServiceManager().getHotelService().getHotelById(id);
		locationList = getServiceManager().getHotelService()
				.getHotelParamByType("location");
		levelList = getServiceManager().getHotelService().getHotelParamByType(
				"level");
		funcList = getServiceManager().getHotelService().getHotelParamByType(
				"func");
		albumList = getServiceManager().getHotelService().getAlbumForList();
		return "hotelArticlePreUpdate";
	}

	/**
	 * 修改酒店信息
	 * 
	 * @return
	 */
	public String hotelArticleUpdate() {
		try {
			getServiceManager().getHotelService().updateHotelById(
					getParametersAsMap());
			this.setAlertMessage(AlertMessage.HOTEL_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			this.setAlertMessage(AlertMessage.HOTEL_UPDATE_FAILURE);
			return ERROR;
		}
	}

	/**
	 * 删除酒店信息
	 * 
	 * @return
	 */
	public String hotelArticleDelete() {
		String id = MapUtil.getStringFromMap(getParametersAsMap(), "id");
		try {
			getServiceManager().getHotelService().deleteHotelById(id);
			this.setAlertMessage(AlertMessage.HOTEL_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			this.setAlertMessage(AlertMessage.HOTEL_DELETE_FAILURE);
			return ERROR;
		}

	}

	/**
	 * 酒店推荐文章信息
	 * 
	 * @return
	 */
	public String hotelRecommand() {
		recommandInfo = getServiceManager().getHotelService()
				.getHotelRecommand();
		return "hotelRecommand";
	}

	/**
	 * 修改酒店推荐文章信息
	 * 
	 * @return
	 */
	public String hotelRecommandUpdate() {
		try {
			getServiceManager().getHotelService().updateHotelRecommand(
					getParametersAsMap(), getLoginUserName());
			this.setAlertMessage(AlertMessage.HOTEL_RECOMMAND_UPDATE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			this.setAlertMessage(AlertMessage.HOTEL_RECOMMAND_UPDATE_FAILURE);
			return ERROR;
		}
	}
}
