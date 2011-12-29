package ula.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间日期工具类
 * 
 * @author Nanlei
 * 
 */
public class CalendarUtil {
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(cal.getTime());
	}
}
