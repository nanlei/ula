package ula.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用返回结果类，保存了操作结果信息
 * 
 * @author Nanlei
 * 
 */
public class ExecuteResult {

	private String result = "success";// 操作结果
	private List<String> messages = new ArrayList<String>();// 提示信息
	private Map<String, String> redirURLs = new LinkedHashMap<String, String>();// 下一步操作

	public void setResult(String result) {
		this.result = result;
	}

	public void addRedirURL(String desc, String url) {
		this.redirURLs.put(desc, url);
	}

	public void addMessage(String msg) {
		this.messages.add(msg);
	}

	public String getResult() {
		return result;
	}

	public Map<String, String> getRedirURLs() {
		return redirURLs;
	}

	public List<String> getMessages() {
		return messages;
	}
}