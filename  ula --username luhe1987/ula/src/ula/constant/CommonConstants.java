package ula.constant;

public interface CommonConstants {

	String ENCODING = "UTF-8";

	/* 通用操作结果页面返回值 */
	public static final String EXECUTE_RESULT = "executeResult";

	/* 异常结果返回值 */
	public static final String EXCEPTION = "exception";

	/* 异常信息在上下文中的存储值 */
	public static final String CONTEXT_EXCEPTION = "_exception_";
	public static final String CONTEXT_EXCEPTION_INFO = "_exception_info_";

	/* Paging constants */

	int DEFAULT_PAGE_SIZE = 20;
	int MAX_PAGE_SIZE = 1000;

	String NORMAL_MARK = "?";
	String START_MARK = ":_START_INDEX_";
	String END_MARK = ":_END_INDEX_";

	// TAG INFO
	String TAG_CITY_INTRODUCTION = "intro";
	String TAG_CITY_HISTORY = "history";
	String TAG_CITY_INSURANCE = "insurance";
	String TAG_CITY_COMMONLAW = "commonlaw";
	String TAG_CITY_CELLPHONE = "cellphone";
	String TAG_CITY_ADVICE = "advice";
	String TAG_CITY_MAP = "map";

	String TAG_CITY_TOUR_DALIAN = "dalian";
	String TAG_CITY_TOUR_LVSHUN = "lvshun";
	String TAG_CITY_TOUR_DEVZONE = "devzone";

	String TAG_CITY_FOOD = "food";
	String TAG_CITY_HOUSING = "housing";
	String TAG_CITY_SHOPPING = "shopping";
	String TAG_CITY_TRANSPORTATION = "transportation";
	String TAG_CITY_THERAPY = "therapy";
	String TAG_CITY_FESTIVAL = "festival";
	String TAG_CITY_EXHIBITION = "exhibition";

	String TAG_SPECIAL_VISA = "visa";
	String TAG_SPECIAL_HOTEL = "hotel";
	String TAG_SPECIAL_COMMISION_TICKET = "ticket";
	String TAG_SPECIAL_COMMISION_CARRENTAL = "carrental";
	String TAG_SPECIAL_COMMISION_TRANSLATION = "translation";
	String TAG_SPECIAL_COMMISION_SOUVENIR = "translation";
	String TAG_SPECIAL_RUSSIAN_STUDENTS = "russianstudents";

	String TAG_PROGRAM_MONTH_RECOMMENDATION = "recommend";
	String TAG_PROGRAM_REGULAR = "regular";
	String TAG_PROGRAM_CHINESE_LEARNING = "chineselearning";
	String TAG_PROGRAM_THERAPY = "therapy";
	String TAG_PROGRAM_SUMMER_CAMP = "summercamp";
	String TAG_PROGRAM_HOT_SPRING = "hotspring";
	String TAG_PROGRAM_EXHIBITION = "exhibition";
	String TAG_PROGRAM_COUNTRYSIDE = "countryside";

	String TAG_PAYMENT = "payment";
	String TAG_LINK = "link";

	// KEY INFO
	String KEY_COMPANY_INFO = "companyInfo";
	String KEY_BIZ_INFO = "bizInfo";
	String KEY_TEAM_INFO = "teamInfo";
	String KEY_MEMORY_INFO = "memoryInfo";

	String KEY_CONTACT_GROUP_RU = "ruGroup";
	String KEY_CONTACT_GROUP_CN = "cnGroup";
	String KEY_CONTACT_GROUP_INDIVIDUAL = "person";

	String KEY_SPECIAL_PAYMENT = "payment";

	String KEY_LINK = "link";

	// ID INFO

	int ID_CONTACT_GROUP_RU = 1;
	int ID_CONTACT_GROUP_CN = 2;
	int ID_CONTACT_INDIVIDUAL = 3;

	int ID_PAYMENT = 1;
	int ID_LINK = 1;

	String LOGIN_USER = "_LOGIN_USER_";
	String LOGIN_USERID = "USERID";
	String LOGIN_USERNAME = "USERNAME";

	String LINK = "link";
	String RECOMMENDATION = "recommendation";
	String VIEW = "view";

	/* 记录用户登录前想要访问的地址在Session中的Key */
	public static final String ORIGINAL_URL = "_ORIGINAL_URL_";

}
