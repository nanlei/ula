package ula.constant;

public interface CommonConstants {
	/*Error Messages*/
	String WAC_IS_NULL = "WebApplicationContext is NULL"; 

	
	
	/* Paging constants*/
	int DEFAULT_PAGE_SIZE = 5;
	int DEFAULT_NOTE_SIZE = 3;
	int MAX_PAGE_SIZE = 1000;
	int MAX_NOTE_SIZE = 1000;
	
	String NORMAL_MARK = "?";
	String START_MARK = ":_START_INDEX_";
	String END_MARK = ":_END_INDEX_";
	
	String KEY_COMPANY_INFO ="companyInfo";
	String KEY_BIZ_INFO ="bizInfo";
	String KEY_TEAM_INFO ="teamInfo";
	String KEY_MEMORY_INFO ="memoryInfo";
	
	String KEY_CONTACT_INFO ="contactInfo";
	
	int ID_CONTACT_GROUP_RU =1;
	int ID_CONTACT_GROUP_CN =2;
	int ID_CONTACT_INDIVIDUAL =3;
	
	String KEY_CONTACT_GROUP_RU ="ruGroup";
	String KEY_CONTACT_GROUP_CN ="cnGroup";
	String KEY_CONTACT_GROUP_INDIVIDUAL ="individual";
	
}
