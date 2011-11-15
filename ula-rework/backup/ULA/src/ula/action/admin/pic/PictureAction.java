package ula.action.admin.pic;

import java.io.File;
import java.util.Date;
import java.util.Map;

import ula.action.FrameworkAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 图片管理
 * 
 * @author Nanlei
 * 
 */
public class PictureAction extends FrameworkAction {
	private PagingList picList;
	private Map picInfo;
	private String picId;

	// 图片上传
	private File picture;
	private String pictureFileName;

	public PagingList getPicList() {
		return picList;
	}

	public Map getPicInfo() {
		return picInfo;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	/**
	 * 图片列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		picList = getServiceManager().getPicService().getAllPics();
		return "list";
	}

	/**
	 * 上传图片跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpload() throws Exception {
		return "preUpload";
	}

	/**
	 * 图片上传
	 * 
	 * @return
	 */
	public String upload() {
		try {
			long nowTime = new Date().getTime();
			int pot = pictureFileName.lastIndexOf(".");
			String ext = null;
			// 取扩展名
			if (pot != -1) {
				String tmp = pictureFileName.substring(pot);
				ext = tmp.substring(1, tmp.length());
			} else {
				ext = "";
			}
			if ("jpg".equalsIgnoreCase(ext) || "gif".equalsIgnoreCase(ext)
					|| "jpeg".equalsIgnoreCase(ext)
					|| "png".equalsIgnoreCase(ext)
					|| "bmp".equalsIgnoreCase(ext)) {
				String fileURL = "/images/" + nowTime + "." + ext;
				String realURL = getServletContext().getRealPath(fileURL);
				picture.renameTo(new File(realURL));
				// 写数据库
				getServiceManager().getPicService().addPic(pictureFileName,
						fileURL, "admin", "common");
				this.setAlertMessage(AlertMessage.PIC_INSERT_SUCCESS);
			} else {
				this.setAlertMessage(AlertMessage.PIC_INSERT_DENY);
			}
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	/**
	 * 查看图片详情
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showPic() throws Exception {
		picInfo = getServiceManager().getPicService().getPicInfoById(picId);
		return "showPic";
	}

	/**
	 * 删除图片
	 * 
	 * @return
	 */
	public String deletePic() {
		try {
			Map picInfo = getServiceManager().getPicService().getPicInfoById(
					picId);
			String filePath = (String) picInfo.get("PICPATH");
			File pic = new File(getServletContext().getRealPath(filePath));
			if (pic.exists()) {
				pic.delete();
			}
			getServiceManager().getPicService().deletePicById(picId);
			this.setAlertMessage(AlertMessage.PIC_DELETE_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
