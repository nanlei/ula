package ula.action;

import java.util.HashMap;
import java.util.Map;

import ula.constant.AlertMessage;
import ula.constant.DebugConstants;
import ula.constant.ErrorConstants;
import ula.util.StringUtil;

public class FrameworkAction extends CommonAction {
	// 获取来自客户端的参数
	private String title = "";
	private String content = "";

	// 以Map用来存放查询出来的信息
	private Map<String, Object> infoMap = null;

	// map的key
	private String mapKeyName = "";

	// 对数据库进行写操作时的结果
	private int result = 0;

	public String add() {

		this.debug("title:" + this.title + ", content:" + this.content);

		int db_result = addToDB(title, content);

		if (db_result == -1) {
			super.debug(DebugConstants.DEBUG_MESSAGE_addToDB);
			// 如果是在debug状态，那么报错
			if (super.log.isDebugEnabled()) {
				return ERROR;
			}
			// 如果不是在debug状态，给出用户提示，并返回管理页面
			super.setAlertMessage(AlertMessage.UPDATE_FAILURE);
			return "admin";
		}

		this.setResult(db_result);

		if (result == 0) {
			super.setAlertMessage(AlertMessage.UPDATE_FAILURE);
			return "admin";
		} else {
			super.setAlertMessage(AlertMessage.UPDATE_SUCCESS);
		}

		return this.admin();
	}

	/**
	 * 一个hook方法，需要被子类覆盖
	 * 
	 * @param title
	 * @param content
	 * @return
	 * 
	 *         -1 默认值, 子类未覆盖此方法 0 添加到数据库失败
	 */
	protected int addToDB(String title, String content) {
		return -1;
	}

	public String admin() {

		if (StringUtil.isEmpty(this.mapKeyName)) {
			super.debug(DebugConstants.DEBUG_MESSAGE_setMapKeyName);
			return ERROR;
		}

		if (this.infoMap == null) {
			super.debug(DebugConstants.DEBUG_MESSAGE_setInfoMap);
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

		if (StringUtil.isEmpty(this.mapKeyName)) {
			super.debug(DebugConstants.DEBUG_MESSAGE_setMapKeyName);
			return ERROR;
		}

		if (this.infoMap == null) {
			super.debug(DebugConstants.DEBUG_MESSAGE_setInfoMap);
			return ERROR;
		}

		this.debug("要编辑的原信息内容：" + infoMap.toString());
		this.getHttpServletRequest().setAttribute(this.mapKeyName, infoMap);

		return "edit";
	}

	public String getContent() {
		return content;
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
	 * 
	 * @return
	 */
	public String update() {
		// 获取客户端信息
		// this.title = StringUtil.UTF8Encoding(this.title);
		// this.content = StringUtil.UTF8Encoding(this.content);

		super.debug("title:" + this.title + ", content:" + this.content);

		int db_result = updateToDB(title, content);

		if (db_result == -1) {
			super.debug(DebugConstants.DEBUG_MESSAGE_updateToDB);
			return ERROR;
		}

		this.setResult(db_result);

		// 检查是否更新成功，未成功返回错误提示
		if (result == 0) {
			this.setErrorMessage(ErrorConstants.SAVE_FAILURE);
			return ERROR;
		}

		// 更新成功，给出提示信息
		this.setAlertMessage(AlertMessage.UPDATE_SUCCESS);
		
		return admin();

	}

	/**
	 * 一个hook方法，需要被子类覆盖
	 * 
	 * @param title2
	 * @param content2
	 * @return -1 默认值, 子类未覆盖此方法 0 更新数据库失败
	 */
	protected int updateToDB(String title, String content) {
		return -1;
	}

	/**
	 * 信息查询页面。用于连接前端页面。
	 * 
	 * note: 放入session的变量 1. 每月推荐 2.Links
	 * 
	 * @return
	 */
	public String view() {

		// 获取页面常量
		super.view();

		// 处理框架逻辑
		if (StringUtil.isEmpty(this.mapKeyName)) {
			super.debug(DebugConstants.DEBUG_MESSAGE_setMapKeyName);
		}

//		如果数据库连接错误，或者数据库中没有所查询的数据，那么infoMap的值为null
//		这是view.title, view.content将无法显示。所有构造默认的情况
		if (this.infoMap == null) {
			//给出后台程序的调试信息		
			super.debug(DebugConstants.DEBUG_MESSAGE_setInfoMap);
			
			//处理前台显示			
			this.infoMap = new HashMap();
			this.infoMap.put("title", "");
			this.infoMap.put("content", "");

		}
		
		this.getHttpServletRequest().setAttribute(this.mapKeyName, infoMap);
		
		return "view";
	}

}
