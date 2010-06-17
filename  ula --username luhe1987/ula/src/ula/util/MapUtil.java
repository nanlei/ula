package ula.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Map对象操作工具类
 * 
 * @author Nanlei
 * 
 */
public class MapUtil {

	/**
	 * 从Map中获取数据，能自动取得Object数组中第一项
	 * 
	 * @param map
	 *            原始Map
	 * @param key
	 *            要获取数据的Key
	 * @return 取得的对象或对象数组中的第一项
	 */
	@SuppressWarnings("unchecked")
	public static Object getObjectFromMap(Map map, String key) {
		Object value = map.get(key);
		if (value != null && (value instanceof Object[])) {
			Object[] array = (Object[]) value;
			if (array != null && array.length > 0) {
				value = array[0];
			}
		}
		return value;
	}

	/* 获取字符串 */
	@SuppressWarnings("unchecked")
	public static String getStringFromMap(Map map, String key) {
		Object value = getObjectFromMap(map, key);
		if (value == null)
			return null;
		if (value instanceof String) {
			return (String) value;
		}
		return value.toString();
	}

	/* 获取基本对象 */
	@SuppressWarnings("unchecked")
	public static int getIntFromMap(Map map, String key) {
		Object value = getObjectFromMap(map, key);
		if (value instanceof String) {
			return Integer.parseInt((String) value);
		}
		return ((BigDecimal) value).intValue();
	}

	@SuppressWarnings("unchecked")
	public static Integer getIntegerObjectFromMap(Map map, String key) {
		return new Integer(getIntFromMap(map, key));
	}

	@SuppressWarnings("unchecked")
	public static long getLongFromMap(Map map, String key) {
		Object value = getObjectFromMap(map, key);
		if (value instanceof String) {
			return Long.parseLong((String) value);
		}
		return ((BigDecimal) value).longValue();
	}

	@SuppressWarnings("unchecked")
	public static Long getLongObjectFromMap(Map map, String key) {
		return new Long(getLongFromMap(map, key));
	}

	/* 获取对象数组 */
	@SuppressWarnings("unchecked")
	public static Object[] getObjectArrayFromMap(Map map, String key) {
		String[] keys = key.split(",");
		Object[] tmp = new Object[keys.length];
		for (int i = 0; i < keys.length; i++) {
			tmp[i] = getObjectFromMap(map, keys[i].trim());
		}
		return tmp;
	}

	/* 获取单值对象Map */
	@SuppressWarnings("unchecked")
	public static Map getSingleValueMap(Map srcMap) {
		Map m = new HashMap();
		if (srcMap != null) {
			Iterator it = srcMap.keySet().iterator();
			String key = null;
			while (it.hasNext()) {
				key = (String) it.next();
				m.put(key, getObjectFromMap(srcMap, key));
			}
		}
		return m;
	}

	/**
	 * 根据值返回一个新的Map 值是数组时特殊处理：单值返回具体对象，多值返回用原来的数组构造的List
	 */
	@SuppressWarnings("unchecked")
	public static Map getNaturalValueMap(Map srcMap) {
		Map m = new HashMap();
		if (srcMap != null) {
			Iterator it = srcMap.keySet().iterator();
			String key = null;
			while (it.hasNext()) {
				key = (String) it.next();
				Object value = srcMap.get(key);
				if (value != null && (value instanceof Object[])) {
					Object[] array = (Object[]) value;
					if (array != null && array.length == 1) {
						value = array[0];
					} else {
						value = Arrays.asList(array);
					}
				}
				m.put(key, value);
			}
		}
		return m;
	}

}
