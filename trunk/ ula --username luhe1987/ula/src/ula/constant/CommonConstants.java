package ula.constant;

public interface CommonConstants {
	
	String ENCODING = "UTF-8";

	/* Paging constants */
	int DEFAULT_PAGE_SIZE = 5;
	int DEFAULT_NOTE_SIZE = 3;
	int MAX_PAGE_SIZE = 1000;
	int MAX_NOTE_SIZE = 1000;

	String NORMAL_MARK = "?";
	String START_MARK = ":_START_INDEX_";
	String END_MARK = ":_END_INDEX_";
	
//	TAG INFO
	String TAG_CITY_INTRODUCTION ="intro";
	String TAG_CITY_HISTORY ="history";
	
	String TAG_SPECIAL_VISA="visa";
	String TAG_SPECIAL_HOTEL="hotel";
	String TAG_SPECIAL_COMMISION_TICKET = "ticket";
	
	String TAG_PROGRAM_MONTH_RECOMMENDATION = "recommend";
	String TAG_PROGRAM_REGULAR = "regular";
	String TAG_PROGRAM_CHINESE_LEARNING = "chineselearning";
	String TAG_PROGRAM_THERAPY = "therapy";
	String TAG_PROGRAM_SUMMER_CAMP = "summercamp";
	String TAG_PROGRAM_HOT_SPRING = "hotspring";
	String TAG_PROGRAM_EXHIBITION = "exhibition";
	String TAG_PROGRAM_COUNTRYSIDE = "countryside";

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

// ID INFO
	
	int ID_CONTACT_GROUP_RU = 1;
	int ID_CONTACT_GROUP_CN = 2;
	int ID_CONTACT_INDIVIDUAL = 3;
	
	int ID_CITY_INTRODUCTION =1;
	int ID_CITY_HISTORY =2;
	
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

	String LOGIN_USER = "_LOGIN_USER_";
	String LOGIN_USERID = "userId";

	/* 记录用户登录前想要访问的地址在Session中的Key */
	public static final String ORIGINAL_URL = "_ORIGINAL_URL_";

}
