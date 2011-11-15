package ula.action.admin.pic;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ula.action.FrameworkAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

public class EditorPictureAction extends FrameworkAction {
	private PagingList picList;
	private String picId;
	// 文件上传
	private File upload;
	private String uploadFileName;

	public PagingList getPicList() {
		return picList;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * Editor上传的图片列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editorList() throws Exception {
		picList = getServiceManager().getPicService().getAllEditorPics();
		return "editorList";
	}

	/**
	 * CKEditor文件上传
	 * 
	 * @return
	 */
	public String editorUpload() {
		try {
			long nowTime = new Date().getTime();
			int pot = uploadFileName.lastIndexOf(".");
			String ext = null;
			// 取扩展名
			if (pot != -1) {
				String tmp = uploadFileName.substring(pot);
				ext = tmp.substring(1, tmp.length());
			} else {
				ext = "";
			}

			String fileURL = "/images/editorimages/" + nowTime + "." + ext;
			String realURL = getServletContext().getRealPath(fileURL);
			upload.renameTo(new File(realURL));
			// 写数据库
			getServiceManager().getPicService().addPic(uploadFileName, fileURL,
					"admin", "editor");
			// CKEditorFuncNum是回调时显示的位置，这个参数必须有
			HttpServletRequest request = getHttpServletRequest();
			String callback = request.getParameter("CKEditorFuncNum");
			PrintWriter out = getHttpServletResponse().getWriter();
			out.print("<script type=\"text/javascript\">");
			out.print("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",'" + request.getContextPath() + fileURL + "',''" + ")");
			out.print("</script>");
			out.flush();
			out.close();
		} catch (Exception e) {
			super.log.debug("文件上传失败");
		}
		return null;
	}

	/**
	 * 删除图片
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteEditorPic() throws Exception {
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
