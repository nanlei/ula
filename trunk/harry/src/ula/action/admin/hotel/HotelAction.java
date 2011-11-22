package ula.action.admin.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ula.action.CommonAction;
import ula.util.MapUtil;

/**
 * 前台查看大连酒店信息
 * 
 * @author Nanlei
 * 
 */
public class HotelAction extends CommonAction {
	private List hotelList;
	private Map recommandHotel;
	private List hotelSearchList;
	private Map hotelInfo;
	private List albumPicList;
	private List picIndex;

	private List locationList;// 酒店位置
	private List levelList;// 酒店星级
	private List funcList;// 酒店功能

	public List getHotelList() {
		return hotelList;
	}

	public Map getRecommandHotel() {
		return recommandHotel;
	}

	public List getHotelSearchList() {
		return hotelSearchList;
	}

	public Map getHotelInfo() {
		return hotelInfo;
	}

	public List getAlbumPicList() {
		return albumPicList;
	}

	public List getPicIndex() {
		return picIndex;
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

	/**
	 * 跳转到酒店显示首页
	 * 
	 * @return
	 */
	public String hotel() {
		super.view();
		hotelList = getServiceManager().getHotelService().getHotelLevelList();
		recommandHotel = getServiceManager().getHotelService()
				.getRecommandHotel();
		locationList = getServiceManager().getHotelService()
				.getHotelParamByType("location");
		levelList = getServiceManager().getHotelService().getHotelParamByType(
				"level");
		funcList = getServiceManager().getHotelService().getHotelParamByType(
				"func");
		return "hotel";
	}

	/**
	 * 酒店搜索
	 * 
	 * @return
	 */
	public String hotelSearch() {
		super.view();
		hotelSearchList = getServiceManager().getHotelService().getSearchHotel(
				getParametersAsMap());
		return "hotelSearch";
	}

	public String hotelInfo() {
		super.view();
		String id = MapUtil.getStringFromMap(getParametersAsMap(), "id");
		hotelInfo = getServiceManager().getHotelService().getHotelById(id);
		String location = getServiceManager().getHotelService()
				.getParamValueByName((String) hotelInfo.get("LOCATION"));
		hotelInfo.put("location", location);
		String level = getServiceManager().getHotelService()
				.getParamValueByName((String) hotelInfo.get("LEVEL"));
		hotelInfo.put("level", level);
		String func = getServiceManager().getHotelService()
				.getParamValueByName((String) hotelInfo.get("FUNC"));
		hotelInfo.put("func", func);
		albumPicList = getServiceManager().getHotelService()
				.getHotelAlbumPicByHotelId(id);
		picIndex = new ArrayList();
		for (int i = 0; i < albumPicList.size(); i++) {
			Map map = (Map) albumPicList.get(i);
			picIndex.add(map.get("PICID"));
		}
		return "hotelInfo";
	}

	public String hotelLevel() {
		super.view();
		String level = MapUtil.getStringFromMap(getParametersAsMap(), "level");
		hotelSearchList = getServiceManager().getHotelService()
				.getHotelByLevel(level);
		return "hotelLevel";
	}
}
