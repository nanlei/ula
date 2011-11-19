package ula.util;

import java.util.Map;

public class CommonUtil {
	public static boolean sessionKeyExists(Map session, String key) {
		return session.containsKey(key);
	}

	public static String getExtensionFromFileName(String fileName) {
		int pot = fileName.lastIndexOf(".");
		if (pot != -1) {
			return fileName.substring(pot + 1, fileName.length());
		} else {
			return "";
		}
	}
}
