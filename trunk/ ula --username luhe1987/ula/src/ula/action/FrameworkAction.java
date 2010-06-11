package ula.action;

import java.util.Map;

import ula.constant.AlertMessage;
import ula.constant.ErrorConstants;
import ula.util.StringUtil;

public class FrameworkAction extends CommonAction {
//	获取来自客户端的参数
	private String title ="";
	private String content ="";
	
//	以Map用来存放查询出来的信息
	private Map<String, Object> infoMap = null;
	
//	map的key
	private String mapKeyName = "infoMapKey";

// 对数据库进行写操作时的结果	
	private int result =0;

	//	用户定制的提示消息
	private String customAlertMessage = "";

	public String add(){
		
		this.title = StringUtil.UTF8Encoding(this.title);
		this.content = StringUtil.UTF8Encoding(this.content);

		this.debug("title:" +this.title + ", content:" + this.content);
		
		this.setResult(addToDB(title, content));
		
		if(result ==0){
			this.setAlertMessage(AlertMessage.UPDATE_FAILURE);
			return "admin";
		}
		
		return this.admin();
	}	
	
	protected int addToDB(String title,String content){
		return 0;
	}
	
	
	public String admin() {
		
		if (infoMap == null || infoMap.isEmpty()) {
			this.setAlertMessage(this.customAlertMessage);
			return "admin";
		}
		
		super.debug(infoMap.toString());
		
		this.getHttpServletRequest().setAttribute(this.mapKeyName, infoMap);
		
		return "admin";
	}
	/**
	 * 转向修改页面
	 * 
	 * @return
	 */
	public String edit() {
		this.debug("要编辑的原信息内容：" + infoMap.toString());
		this.getHttpServletRequest().setAttribute(this.mapKeyName, infoMap);
		
		return "edit";
	}
	public String getContent() {
		return content;
	}
	public String getCustomAlertMessage() {
		return customAlertMessage;
	}

	public String getTitle() {
		return title;
	}



	public String preAdd() {
		return "preAdd";
	}

	public void setContent(String content) {
		this.content = content;
	}



	public void setCustomAlertMessage(String customAlertMessage) {
		this.customAlertMessage = customAlertMessage;
	}

	public void setInfoMap(Map<String, Object> infoMap) {
		this.infoMap = infoMap;
	}

	public void setMapKeyName(String mapKeyName) {
		this.mapKeyName = mapKeyName;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 更新信息。
	 * @return
	 */
	public String update() {
		// 获取客户端信息
		this.title = StringUtil.UTF8Encoding(this.title);
		this.content = StringUtil.UTF8Encoding(this.content);

		this.debug("title:" + this.title + ", content:" + this.content);
		
		this.result = this.updateToDB(title,content);
		
		// 检查是否更新成功，未成功返回错误提示
		if (result ==0) {
			this.setErrorMessage(ErrorConstants.SAVE_FAILURE);
			return ERROR;
		}
		
		// 更新成功，给出提示信息
		this.setAlertMessage(AlertMessage.UPDATE_SUCCESS);
		
		return this.admin();
		
	}
	protected int updateToDB(String title2, String content2) {
		return 0;
	}
	
	/**
	 * 业务介绍查看
	 * 
	 * @return
	 */
	public String view() {
		
		if (infoMap.isEmpty()) {
			this.setErrorMessage(ErrorConstants.MAP_EMPTY);
			return ERROR;
		}
		
		this.getHttpServletRequest().setAttribute(this.mapKeyName, infoMap);
		
		return "view";
	}
	
	
}
