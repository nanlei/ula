package ula.util;

import java.util.Map;

public class CommonUtil {
	public static boolean sessionKeyExists(Map session, String key){
		return session.containsKey(key);
	}
}
