package ula.constant;

public interface CommonConstants {
	
	String ENCODING = "UTF-8";

	/* Paging constants */
	
	int DEFAULT_PAGE_SIZE = 20;
	int MAX_PAGE_SIZE = 1000;

	String NORMAL_MARK = "?";
	String START_MARK = ":_START_INDEX_";
	String END_MARK = ":_END_INDEX_";
	
//	TAG INFO
	String TAG_CITY_INTRODUCTION ="intro";
	String TAG_CITY_HISTORY ="history";
	String TAG_CITY_INSURANCE ="insurance";
	String TAG_CITY_COMMONLAW ="commonlaw";
	String TAG_CITY_CELLPHONE ="cellphone";
	String TAG_CITY_ADVICE="advice";
	String TAG_CITY_MAP = "map";
	
	
	String TAG_SPECIAL_VISA="visa";
	String TAG_SPECIAL_HOTEL="hotel";
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
	
//	KEY INFO
	String KEY_COMPANY_INFO = "companyInfo";
	String KEY_BIZ_INFO = "bizInfo";
	String KEY_TEAM_INFO = "teamInfo";
	String KEY_MEMORY_INFO = "memoryInfo";
	
	String KEY_CONTACT_GROUP_RU = "ruGroup";
	String KEY_CONTACT_GROUP_CN = "cnGroup";
	String KEY_CONTACT_GROUP_INDIVIDUAL = "person";
	
	String KEY_CITY_INTRODUCTION ="cityIntro";
	String KEY_CITY_HISTORY ="cityHistory";
	
	String KEY_PROGRAM_MONTH_RECOMMENDATION = "recommend";
	String KEY_PROGRAM_REGULAR = "regular";
	String KEY_PROGRAM_CHINESE_LEARNING = "chineselearning";
	String KEY_PROGRAM_THERAPY = "therapy";
	String KEY_PROGRAM_SUMMER_CAMP = "summercamp";
	String KEY_PROGRAM_HOT_SPRING = "hotspring";
	String KEY_PROGRAM_EXHIBITION = "exhibition";
	String KEY_PROGRAM_COUNTRYSIDE = "countryside";
	
	String KEY_SPECIAL_PAYMENT = "payment";
	String KEY_SPECIAL_VISA = "visa";
	String KEY_SPECIAL_RUSSIAN_STUDENTS = "russianstudents";
	String KEY_SPECIAL_TICKET ="ticket";
	String KEY_SPECIAL_CARRENTAL ="carrental";
	String KEY_SPECIAL_TRANSLATION ="translation";
	String KEY_SPECIAL_SOUVENIR ="souvenir";
	
	String KEY_LINK = "link";

// ID INFO
	
	int ID_CONTACT_GROUP_RU = 1;
	int ID_CONTACT_GROUP_CN = 2;
	int ID_CONTACT_INDIVIDUAL = 3;
	
	int ID_CITY_INTRODUCTION =1;
	int ID_CITY_HISTORY =2;
	int ID_CITY_INSURANCE =3;
	int ID_CITY_COMMOMLAW=4;
	int ID_CITY_CELLPHONE=5;
	int ID_CITY_ADVICE=6;
	int ID_CITY_MAP = 7;
	
	int ID_SPECIAL_VISA =1;
	int ID_SPECIAL_HOTEL_BOOKING =2;
	int ID_SPECIAL_COMMISSION_TICKET=3;
	int ID_SPECIAL_COMMISSION_CAR_RENTAL=4;
	int ID_SPECIAL_COMMISSION_TRANSLATION=5;
	int ID_SPECIAL_COMMISSION_SOUVENIR=6;
	int ID_SPECIAL_RUSSIAN_STUDENTS=7;
	
	int ID_PROGRAM_MONTH_RECOMMENDATION =1;
	int ID_PROGRAM_REGULAR_SCHEDULE =2;
	int ID_PROGRAM_THERAPY_SCHEDULE =3;
	int ID_PROGRAM_CHINESE_LEARNING =4;
	int ID_PROGRAM_SUMMER_CAMP =5;
	int ID_PROGRAM_HOT_SPRING_TOUR =6;
	int ID_PROGRAM_EXHIBITION =7;
	int ID_PROGRAM_COUNTRYSIDE_TOUR =8;
	
	int ID_PAYMENT =1;
	int ID_LINK=1;

	String LOGIN_USER = "_LOGIN_USER_";
	String LOGIN_USERID = "USERID";
	String LOGIN_USERNAME="USERNAME";

	String KEY_CITY_INSURANCE = "insurance";
	String KEY_CITY_COMMONLAW = "law";
	String KEY_CITY_CELLPHONE = "cellphone";
	String KEY_CITY_ADVICE = "advice";
	String KEY_CITY_MAP ="citymap";

	String LINK = "link";
	String RECOMMENDATION = "recommendation";
	String VIEW = "view";



	

	/* 记录用户登录前想要访问的地址在Session中的Key */
	public static final String ORIGINAL_URL = "_ORIGINAL_URL_";

}
