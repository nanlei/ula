package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;
import ula.constant.CommonConstants;

/**
 * 前台-关于大连
 * 
 * @author Nanlei
 * 
 */
public class CityAction extends AnonymousAction {
	private List<Map<String, Object>> recommendList;
	private List<Map<String, Object>> linkList;
	private List<Map<String, Object>> articleList;
	private Map<String, Object> city;
	private Map<String, Object> cityTour;
	private Map<String, Object> weather;

	public List<Map<String, Object>> getRecommendList() {
		return recommendList;
	}

	public List<Map<String, Object>> getLinkList() {
		return linkList;
	}

	public List<Map<String, Object>> getArticleList() {
		return articleList;
	}

	public Map<String, Object> getCity() {
		return city;
	}

	public Map<String, Object> getCityTour() {
		return cityTour;
	}

	public Map<String, Object> getWeather() {
		return weather;
	}

	private void baseInfo() throws Exception {
		weather = getServiceManager().getIndexService().getWeather();
		recommendList = getServiceManager().getIndexService()
				.getRecommendList();
		linkList = getServiceManager().getIndexService().getLinkList();
	}

	/**
	 * 关于大连首页
	 * 
	 * @return
	 */
	public String city() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_INTRODUCTION);
		baseInfo();
		return SUCCESS;
	}

	/**
	 * 大连介绍
	 * 
	 * @return
	 * @throws Exception
	 */
	public String intro() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_INTRODUCTION);
		baseInfo();
		return "intro";
	}

	/**
	 * 大连历史
	 * 
	 * @return
	 * @throws Exception
	 */
	public String history() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_HISTORY);
		baseInfo();
		return "history";
	}

	/**
	 * 城市地图
	 * 
	 * @return
	 * @throws Exception
	 */
	public String map() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_MAP);
		baseInfo();
		return "map";
	}

	/**
	 * 景点公园-市内
	 * 
	 * @return
	 * @throws Exception
	 */
	public String dalian() throws Exception {
		cityTour = getServiceManager().getFrontService().getCityTourByType(
				CommonConstants.TAG_CITY_TOUR_DALIAN);
		baseInfo();
		return "dalian";
	}

	/**
	 * 景点公园-旅顺
	 * 
	 * @return
	 * @throws Exception
	 */
	public String lvshun() throws Exception {
		cityTour = getServiceManager().getFrontService().getCityTourByType(
				CommonConstants.TAG_CITY_TOUR_LVSHUN);
		baseInfo();
		return "lvshun";
	}

	/**
	 * 景点公园-开发区
	 * 
	 * @return
	 * @throws Exception
	 */
	public String devzone() throws Exception {
		cityTour = getServiceManager().getFrontService().getCityTourByType(
				CommonConstants.TAG_CITY_TOUR_DEVZONE);
		baseInfo();
		return "devzone";
	}

	/**
	 * 大连美食
	 * 
	 * @return
	 * @throws Exception
	 */
	public String food() throws Exception {
		articleList = getServiceManager().getFrontService()
				.getArticleListByType(CommonConstants.TAG_CITY_FOOD);
		baseInfo();
		return "food";
	}

	/**
	 * 大连美食-美食文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String foodInfo() throws Exception {
		city = getServiceManager().getFrontService().getArticleById(
				getParametersAsMap());
		baseInfo();
		return "foodInfo";
	}

	/**
	 * 大连居住
	 * 
	 * @return
	 * @throws Exception
	 */
	public String housing() throws Exception {
		articleList = getServiceManager().getFrontService()
				.getArticleListByType(CommonConstants.TAG_CITY_HOUSING);
		baseInfo();
		return "housing";
	}

	/**
	 * 大连居住-居住文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String housingInfo() throws Exception {
		city = getServiceManager().getFrontService().getArticleById(
				getParametersAsMap());
		baseInfo();
		return "housingInfo";
	}

	/**
	 * 大连购物
	 * 
	 * @return
	 * @throws Exception
	 */
	public String shopping() throws Exception {
		articleList = getServiceManager().getFrontService()
				.getArticleListByType(CommonConstants.TAG_CITY_SHOPPING);
		baseInfo();
		return "shopping";
	}

	/**
	 * 大连购物-购物文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String shoppingInfo() throws Exception {
		city = getServiceManager().getFrontService().getArticleById(
				getParametersAsMap());
		baseInfo();
		return "shoppingInfo";
	}

	/**
	 * 大连交通
	 * 
	 * @return
	 * @throws Exception
	 */
	public String transportation() throws Exception {
		articleList = getServiceManager().getFrontService()
				.getArticleListByType(CommonConstants.TAG_CITY_TRANSPORTATION);
		baseInfo();
		return "transportation";
	}

	/**
	 * 大连交通-交通文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String transportationInfo() throws Exception {
		city = getServiceManager().getFrontService().getArticleById(
				getParametersAsMap());
		baseInfo();
		return "transportationInfo";
	}

	/**
	 * 大连治疗
	 * 
	 * @return
	 * @throws Exception
	 */
	public String therapy() throws Exception {
		articleList = getServiceManager().getFrontService()
				.getArticleListByType(CommonConstants.TAG_CITY_THERAPY);
		baseInfo();
		return "therapy";
	}

	/**
	 * 大连治疗-治疗文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String therapyInfo() throws Exception {
		city = getServiceManager().getFrontService().getArticleById(
				getParametersAsMap());
		baseInfo();
		return "therapyInfo";
	}

	/**
	 * 大连节日
	 * 
	 * @return
	 * @throws Exception
	 */
	public String festival() throws Exception {
		articleList = getServiceManager().getFrontService()
				.getArticleListByType(CommonConstants.TAG_CITY_FESTIVAL);
		baseInfo();
		return "festival";
	}

	/**
	 * 大连节日-节日文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String festivalInfo() throws Exception {
		city = getServiceManager().getFrontService().getArticleById(
				getParametersAsMap());
		baseInfo();
		return "festivalInfo";
	}

	/**
	 * 展会信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exhibition() throws Exception {
		articleList = getServiceManager().getFrontService()
				.getArticleListByType(CommonConstants.TAG_CITY_EXHIBITION);
		baseInfo();
		return "exhibition";
	}

	/**
	 * 展会信息-展会文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exhibitionInfo() throws Exception {
		city = getServiceManager().getFrontService().getArticleById(
				getParametersAsMap());
		baseInfo();
		return "exhibitionInfo";
	}

	/**
	 * 其它信息-保险
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insurance() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_INSURANCE);
		baseInfo();
		return "insurance";
	}

	/**
	 * 其它信息-法律常识
	 * 
	 * @return
	 * @throws Exception
	 */
	public String law() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_COMMONLAW);
		baseInfo();
		return "law";
	}

	/**
	 * 其它信息-手机信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String mobile() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_CELLPHONE);
		baseInfo();
		return "mobile";
	}

	/**
	 * 其它信息-实用建议
	 * 
	 * @return
	 * @throws Exception
	 */
	public String tips() throws Exception {
		city = getServiceManager().getFrontService().getCityInfoByTag(
				CommonConstants.TAG_CITY_ADVICE);
		baseInfo();
		return "tips";
	}
}
