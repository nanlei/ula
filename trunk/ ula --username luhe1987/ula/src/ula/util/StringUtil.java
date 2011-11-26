package ula.util;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	public static boolean isEmpty(String str) {
		return str == null || str.equals("");
	}

	public static String UTF8Encoding(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {

		}
		return str;
	}

}
