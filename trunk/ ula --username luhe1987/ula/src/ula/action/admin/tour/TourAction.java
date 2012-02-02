package ula.action.admin.tour;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import ula.action.BaseAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.util.CommonUtil;
import ula.util.ImageUtil;

/**
 * 行程管理
 * 
 * @author Nanlei
 * 
 */
public class TourAction extends BaseAction {
	private PagingList tourList;
	private List<Map<String, Object>> categoryList;
	private Map<String, Object> tour;

	// 图片上传
	private File coverlink;
	private String coverlinkFileName;
	private String coverlinkContentType;

	public PagingList getTourList() {
		return tourList;
	}

	public List<Map<String, Object>> getCategoryList() {
		return categoryList;
	}

	public Map<String, Object> getTour() {
		return tour;
	}

	// 图片上传
	public void setCoverlink(File coverlink) {
		this.coverlink = coverlink;
	}

	public void setCoverlinkFileName(String coverlinkFileName) {
		this.coverlinkFileName = coverlinkFileName;
	}

	public void setCoverlinkContentType(String coverlinkContentType) {
		this.coverlinkContentType = coverlinkContentType;
	}

	public String tourAdmin() throws Exception {
		tourList = getServiceManager().getTourService().getAllTours();
		categoryList = getServiceManager().getTourService()
				.getAllTourCategories();
		return "tourAdmin";
	}

	/**
	 * 添加行程
	 * 
	 * @return
	 */
	public String add() {
		if (coverlink.length() <= 0) {
			log.debug("The size of file(" + coverlinkFileName + ") is 0");
			setResult(ERROR);
			addMessage(AlertMessage.PIC_SIZE_ZERO);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		} else if (coverlinkContentType.indexOf("image") == -1) {
			log.debug("The type of file is not a kind of images");
			setResult(ERROR);
			addMessage(AlertMessage.PIC_INSERT_DENY);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		} else {
			String fileName = new java.util.Date().getTime() + "."
					+ CommonUtil.getExtensionFromFileName(coverlinkFileName);
			String filePath = "/images/tour/" + fileName;
			String realPath = getServletContext().getRealPath(filePath);
			try {
				ImageUtil.resizeImageToFile(new FileInputStream(coverlink),
						191, 131, realPath);
				// 写数据库
				getServiceManager().getTourService().addTour(
						getParametersAsMap(), filePath, getLoginUserName());
				setResult(SUCCESS);
				addMessage(AlertMessage.TOUR_ADD_SUCCESS);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR);
			} catch (Exception e) {
				log.error(ExceptionUtils.getStackTrace(e));
				setResult(ERROR);
				addMessage(AlertMessage.TOUR_ADD_FAILURE);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			}
		}
		return EXECUTE_RESULT;
	}

	public String preUpdate() throws Exception {
		tour = getServiceManager().getTourService().getTourById(
				getParametersAsMap());
		categoryList = getServiceManager().getTourService()
				.getAllTourCategories();
		return "preUpdate";
	}

	/**
	 * 更新行程
	 * 
	 * @return
	 */
	public String update() {
		if (StringUtils.isEmpty(coverlinkFileName)) {// 不更新封面图片
			try {
				getServiceManager().getTourService().updateTourById(
						getParametersAsMap(), getLoginUserName());
				setResult(SUCCESS);
				addMessage(AlertMessage.TOUR_UPDATE_SUCCESS);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR);
			} catch (Exception e) {
				log.error(ExceptionUtils.getStackTrace(e));
				setResult(ERROR);
				addMessage(AlertMessage.TOUR_UPDATE_FAILURE);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			}
		} else {// 更新封面图片
			if (coverlink.length() <= 0) {
				log.debug("The size of file(" + coverlinkFileName + ") is 0");
				setResult(ERROR);
				addMessage(AlertMessage.PIC_SIZE_ZERO);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			} else if (coverlinkContentType.indexOf("image") == -1) {
				log.debug("The type of file is not a kind of images");
				setResult(ERROR);
				addMessage(AlertMessage.PIC_INSERT_DENY);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			} else {
				String oldFilePath = (String) getServiceManager()
						.getTourService().getTourById(getParametersAsMap())
						.get("COVERLINK");
				String fileName = new java.util.Date().getTime()
						+ "."
						+ CommonUtil
								.getExtensionFromFileName(coverlinkFileName);
				String filePath = "/images/tour/" + fileName;
				String realPath = getServletContext().getRealPath(filePath);
				try {
					// 先删除已有的图片
					File oldFile = new File(getServletContext().getRealPath(
							oldFilePath));
					if (oldFile.exists()) {
						oldFile.delete();
					}
					ImageUtil.resizeImageToFile(new FileInputStream(coverlink),
							191, 131, realPath);
					// 写数据库
					getServiceManager().getTourService().updateTourById(
							getParametersAsMap(), filePath, getLoginUserName());
					setResult(SUCCESS);
					addMessage(AlertMessage.TOUR_UPDATE_SUCCESS);
					addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR);
				} catch (Exception e) {
					log.error(ExceptionUtils.getStackTrace(e));
					setResult(ERROR);
					addMessage(AlertMessage.TOUR_UPDATE_FAILURE);
					addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
				}
			}
		}
		return EXECUTE_RESULT;
	}

	/**
	 * 删除行程
	 * 
	 * @return
	 */
	public String delete() {
		String oldFilePath = (String) getServiceManager().getTourService()
				.getTourById(getParametersAsMap()).get("COVERLINK");
		try {
			// 先删除已有的图片
			File oldFile = new File(getServletContext()
					.getRealPath(oldFilePath));
			if (oldFile.exists()) {
				oldFile.delete();
			}
			// 删除数据库
			getServiceManager().getTourService().deleteTourById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.TOUR_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_TOUR);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.TOUR_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
