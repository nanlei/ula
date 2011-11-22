package ula.action.admin.link;

import java.util.Map;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.ErrorConstants;
import ula.util.StringUtil;

public class LinkAction extends CommonAction {
	private String title = ""; //链接标题
	private String url = "";  // 链接URL
	private PagingList linkList= null; //所有信息的分页处理列表
	private Map linkMap = null; // 单条信息的Map
	

	/**
	 * 添加
	 * @return
	 */
	public String add(){	
//		this.title = StringUtil.UTF8Encoding(this.title);
		try {
			int db_result = super.getServiceManager().getLinkService().addInfo(this.title, this.url);
			if(db_result ==1){
				super.setAlertMessage(AlertMessage.INSERT_SUCCESS);
			}	
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setErrorMessage(ErrorConstants.INSERT_ERROR);
			
			return ERROR;
		}
		
		return this.admin();
	}
	/**
	 * 修改
	 * @return
	 */
	public String edit(){
		String linkID = super.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(linkID)){
			super.setErrorMessage(ErrorConstants.INFO_INVALID);
			return ERROR;
		}
		
		super.debug("ID:"+linkID);
		
		try {
			this.linkMap = super.getServiceManager().getLinkService().getInfoById(linkID);
			super.debug("link info Map: " + this.linkMap);
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setErrorMessage(ErrorConstants.QUERY_ERROR);
			return ERROR;
		}
		
		return "edit";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String remove(){
		String linkID = super.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(linkID)){
			super.setErrorMessage(ErrorConstants.INFO_INVALID);
			return ERROR;
		}
		
		try {
		    int db_result = super.getServiceManager().getLinkService().deleteInfoById(linkID);
		    if(db_result ==0){
		    	super.setAlertMessage(AlertMessage.DELTE_ERROR);
		    	return this.admin();
		    }
		    else{
		    	super.setAlertMessage(AlertMessage.DELTE_SUCCESS);
		    	return this.admin();
		    }
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setErrorMessage(ErrorConstants.QUERY_ERROR);
			return ERROR;
		}
	}
	
	/**
	 * 更新
	 * @return
	 */
	public String update(){
		String linkID = super.getHttpServletRequest().getParameter("id");
		if(StringUtil.isEmpty(linkID)){
			super.setErrorMessage(ErrorConstants.INFO_INVALID);
			return ERROR;
		}
		
		super.debug("linkID:"+linkID);
		
		try {
		    int db_result = super.getServiceManager().getLinkService().updateInfo(linkID, this.title, this.url);
		    if(db_result ==0){
		    	super.setAlertMessage(AlertMessage.UPDATE_FAILURE);
		    	return this.admin();
		    }
		    else{
		    	super.setAlertMessage(AlertMessage.UPDATE_SUCCESS);
		    	return this.admin();
		    }
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setErrorMessage(ErrorConstants.QUERY_ERROR);
			return ERROR;
		}
	}
	
	/**
	 * 管理页面
	 * @return
	 */
	public String admin(){
		this.linkList = super.getServiceManager().getLinkService().getAllInfo();
		if(this.linkList.getRowCount()==0){
			super.setAlertMessage(AlertMessage.LINK_EMPTY +" "+super.getAlertMessage());
		}
		return "admin";
	}
	
	/**
	 * 添加前转到添加页面
	 * @return
	 */
	public String preAdd(){
		return "preAdd";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public PagingList getLinkList() {
		return linkList;
	}
	public void setLinkList(PagingList linkList) {
		this.linkList = linkList;
	}
	
	public Map getLinkMap() {
		return linkMap;
	}
	public void setLinkMap(Map linkMap) {
		this.linkMap = linkMap;
	}
}
