package ula.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 解决URL生成问题。 同时可以添加参数，修改参数，删除参数 这个工具类有可能会涉及到线程安全问题，所以没有使用静态方法。
 * 
 * @author Harry
 * 
 */
public class URLUtil {
	private String URL = "";
	private Map<String, String> param = new HashMap<String, String>();

	/**
	 * 根据namespace,actionName,methodName生成一个URL
	 * 
	 * @param namespace
	 *            不用以"/"开头
	 * @param actionName
	 * @param methodName
	 *            .action前边的部分
	 * @return
	 */
	public String makeURL(String namespace, String actionName, String methodName) {
		URL = "/"
				+ namespace
				+ "/"
				+ actionName
				+ (methodName == null || methodName.equals("") ? "" : "!"
						+ methodName) + ".action";
		return URL;
	}

	public void setParam(String key, int value) {
		param.put(key, "" + value);
	}

	public void setParam(String key, String value) {
		param.put(key, value);
	}

	public void addParam(String key, int value) {
		setParam(key, value);
	}

	public void addParam(String key, String value) {
		setParam(key, value);
	}

	public String getParam(String key) {
		return param.get(key);
	}

	public void removeParam(String key) {
		this.param.remove(key);
	}

	public String getURLwithParams() {
		String paramList = getParams();
		if (paramList.equals(""))
			return URL;
		return URL + "?" + paramList;
	}

	public String getParams() {
		String paramList = "";
		Map<String, String> paramMap = param;
		Set<Entry<String, String>> params = paramMap.entrySet();

		for (Entry<String, String> paramEntry : params) {
			paramList += paramEntry.getKey() + "=" + paramEntry.getValue()
					+ "&";
		}

		return paramList.substring(0, paramList.length() - 1);
	}

	public static String encodeURL(String url) {
		// deal with non-Latin characters
		try {
			url = java.net.URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	public static String profileURL (String id, String linkText){
		return "<a href =/edunotesapp/profile/profile!profileView.action?userID="+id+">"+linkText+"</a>";
	}
	public static String pageURL (String id, String linkText){
		return "<a href =/edunotesapp/groupPage/groupPage!detail.action?pageId="+id+">"+linkText+"</a>";
	}
}
