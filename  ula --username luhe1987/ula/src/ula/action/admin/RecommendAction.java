package ula.action.admin;

import java.io.File;
import java.io.FileInputStream;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.CommonUtil;
import ula.util.ImageUtil;

/**
 * 每月推荐
 * 
 * @author Nanlei
 * 
 */
public class RecommendAction extends CommonAction {
	private PagingList recommendList;
	// 图片上传
	private File cover;
	private String coverFileName;
	private String coverContentType;

	public PagingList getRecommendList() {
		return recommendList;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}

	public String admin() {
		recommendList = getServiceManager().getRecommendService()
				.getAllRecommends();
		return "admin";
	}

	public String add() {
		if (cover.length() <= 0) {
			log.debug("The size of file(" + coverFileName + ") is 0");
			this.setAlertMessage(AlertMessage.PIC_SIZE_ZERO);
			return ERROR;
		} else if (coverContentType.indexOf("image") == -1) {
			log.debug("The type of file is not a kind of images");
			this.setAlertMessage(AlertMessage.PIC_INSERT_DENY);
			return ERROR;
		} else {
			String fileName = new java.util.Date().getTime() + "."
					+ CommonUtil.getExtensionFromFileName(coverFileName);
			String filePath = "/images/recommend/" + fileName;
			String realPath = getServletContext().getRealPath(filePath);
			try {
				ImageUtil.resizeImageToFile(new FileInputStream(cover), 179,
						121, realPath);
				// 写数据库
				getServiceManager().getRecommendService().addRecommend(
						getParametersAsMap(), filePath, getLoginUserName());
				this.setAlertMessage(AlertMessage.RECOMMAND_ADD_SUCCESS);
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				this.setAlertMessage(AlertMessage.RECOMMAND_ADD_FAILURE);
				return ERROR;
			}
		}
	}
}
