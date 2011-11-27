package ula.action.admin.link;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.ErrorConstants;
import ula.util.StringUtil;

public class LinkAction extends CommonAction {
	private String title = ""; // 链接标题
	private String url = ""; // 链接URL
	private PagingList linkList = null; // 所有信息的分页处理列表
	private Map<String, Object> linkMap = null; // 单条信息的Map

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String add() {
		// this.title = StringUtil.UTF8Encoding(this.title);
		try {
			int db_result = getServiceManager().getLinkService().addInfo(
					this.title, this.url);
			if (db_result == 1) {
				setAlertMessage(AlertMessage.INSERT_SUCCESS);
			}
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setErrorMessage(ErrorConstants.INSERT_ERROR);
			return ERROR;
		}
		return this.admin();
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String edit() {
		String linkID = getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(linkID)) {
			setErrorMessage(ErrorConstants.INFO_INVALID);
			return ERROR;
		}
		log.debug("ID:" + linkID);
		try {
			linkMap = getServiceManager().getLinkService().getInfoById(linkID);
			log.debug("link info Map: " + this.linkMap);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setErrorMessage(ErrorConstants.QUERY_ERROR);
			return ERROR;
		}

		return "edit";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String remove() {
		String linkID = getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(linkID)) {
			setErrorMessage(ErrorConstants.INFO_INVALID);
			return ERROR;
		}
		try {
			int db_result = getServiceManager().getLinkService()
					.deleteInfoById(linkID);
			if (db_result == 0) {
				setAlertMessage(AlertMessage.DELTE_ERROR);
				return this.admin();
			} else {
				setAlertMessage(AlertMessage.DELTE_SUCCESS);
				return this.admin();
			}
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setErrorMessage(ErrorConstants.QUERY_ERROR);
			return ERROR;
		}
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	public String update() {
		String linkID = getHttpServletRequest().getParameter("id");
		if (StringUtil.isEmpty(linkID)) {
			setErrorMessage(ErrorConstants.INFO_INVALID);
			return ERROR;
		}
		log.debug("linkID:" + linkID);
		try {
			int db_result = getServiceManager().getLinkService().updateInfo(
					linkID, this.title, this.url);
			if (db_result == 0) {
				setAlertMessage(AlertMessage.UPDATE_FAILURE);
				return this.admin();
			} else {
				setAlertMessage(AlertMessage.UPDATE_SUCCESS);
				return this.admin();
			}
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setErrorMessage(ErrorConstants.QUERY_ERROR);
			return ERROR;
		}
	}

	/**
	 * 管理页面
	 * 
	 * @return
	 */
	public String admin() {
		linkList = getServiceManager().getLinkService().getAllInfo();
		if (this.linkList.getRowCount() == 0) {
			setAlertMessage(AlertMessage.LINK_EMPTY + " " + getAlertMessage());
		}
		return "admin";
	}

	/**
	 * 添加前转到添加页面
	 * 
	 * @return
	 */
	public String preAdd() {
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

	public Map<String, Object> getLinkMap() {
		return linkMap;
	}

	public void setLinkMap(Map<String, Object> linkMap) {
		this.linkMap = linkMap;
	}
}
