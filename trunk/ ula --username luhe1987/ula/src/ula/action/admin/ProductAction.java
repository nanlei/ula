package ula.action.admin;

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
 * 产品管理Action
 * 
 * @author Nanlei
 * 
 */
public class ProductAction extends BaseAction {
	private PagingList productList;
	private Map<String, Object> product;
	private int displayNum;
	private PagingList tourList;
	private List<Map<String, Object>> productTourList;

	// 图片上传
	private File cover;
	private String coverFileName;
	private String coverContentType;

	public PagingList getProductList() {
		return productList;
	}

	public Map<String, Object> getProduct() {
		return product;
	}

	public int getDisplayNum() {
		return displayNum;
	}

	public PagingList getTourList() {
		return tourList;
	}

	public List<Map<String, Object>> getProductTourList() {
		return productTourList;
	}

	// 图片上传
	public void setCover(File cover) {
		this.cover = cover;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}

	public String productAdmin() throws Exception {
		productList = getServiceManager().getProductService().getAllProducts();
		displayNum = getServiceManager().getProductService()
				.getProductsDisplayNum();
		return "productAdmin";
	}

	/**
	 * 添加产品，包含图片上传
	 * 
	 * @return
	 */
	public String add() {
		if (cover.length() <= 0) {
			setResult(ERROR);
			addMessage(AlertMessage.PIC_SIZE_ZERO);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		} else if (coverContentType.indexOf("image") == -1) {
			setResult(ERROR);
			addMessage(AlertMessage.PIC_INSERT_DENY);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		} else {
			String fileName = new java.util.Date().getTime() + "."
					+ CommonUtil.getExtensionFromFileName(coverFileName);
			String filePath = "/images/product/" + fileName;
			String realPath = getServletContext().getRealPath(filePath);
			try {
				ImageUtil.resizeImageToFile(new FileInputStream(cover), 188,
						125, realPath);
				// 写数据库
				getServiceManager().getProductService().addProduct(
						getParametersAsMap(), filePath, getLoginUserName());
				setResult(SUCCESS);
				addMessage(AlertMessage.PRODUCT_ADD_SUCCESS);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_PRODUCT);
			} catch (Exception e) {
				log.error(ExceptionUtils.getStackTrace(e));
				setResult(ERROR);
				addMessage(AlertMessage.PRODUCT_ADD_FAILURE);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			}
		}
		return EXECUTE_RESULT;
	}

	public String preUpdate() throws Exception {
		product = getServiceManager().getProductService().getProductById(
				getParametersAsMap());
		displayNum = getServiceManager().getProductService()
				.getProductsDisplayNum();
		return "preUpdate";
	}

	/**
	 * 更新产品，包含文件上传
	 * 
	 * @return
	 */
	public String update() {
		if (StringUtils.isEmpty(coverFileName)) {// 不更新封面图片
			try {
				getServiceManager().getProductService().updateProduct(
						getParametersAsMap(), getLoginUserName());
				setResult(SUCCESS);
				addMessage(AlertMessage.PRODUCT_UPDATE_SUCCESS);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_PRODUCT);
			} catch (Exception e) {
				log.error(ExceptionUtils.getStackTrace(e));
				setResult(ERROR);
				addMessage(AlertMessage.PRODUCT_UPDATE_FAILURE);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			}
		} else {// 更新封面图片
			if (cover.length() <= 0) {
				setResult(ERROR);
				addMessage(AlertMessage.PIC_SIZE_ZERO);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			} else if (coverContentType.indexOf("image") == -1) {
				setResult(ERROR);
				addMessage(AlertMessage.PIC_INSERT_DENY);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			} else {
				String oldFilePath = (String) getServiceManager()
						.getProductService().getProductById(
								getParametersAsMap()).get("COVER");
				String fileName = new java.util.Date().getTime() + "."
						+ CommonUtil.getExtensionFromFileName(coverFileName);
				String filePath = "/images/product/" + fileName;
				String realPath = getServletContext().getRealPath(filePath);
				try {
					// 先删除已有的图片
					File oldFile = new File(getServletContext().getRealPath(
							oldFilePath));
					if (oldFile.exists()) {
						oldFile.delete();
					}
					ImageUtil.resizeImageToFile(new FileInputStream(cover),
							188, 125, realPath);
					// 写数据库
					getServiceManager().getProductService().updateProduct(
							getParametersAsMap(), filePath, getLoginUserName());
					setResult(SUCCESS);
					addMessage(AlertMessage.PRODUCT_UPDATE_SUCCESS);
					addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_PRODUCT);
				} catch (Exception e) {
					log.error(ExceptionUtils.getStackTrace(e));
					setResult(ERROR);
					addMessage(AlertMessage.PRODUCT_UPDATE_FAILURE);
					addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
				}
			}
		}
		return EXECUTE_RESULT;
	}

	public String delete() {
		String oldFilePath = (String) getServiceManager().getProductService()
				.getProductById(getParametersAsMap()).get("COVER");
		try {
			// 先删除已有的图片
			File oldFile = new File(getServletContext()
					.getRealPath(oldFilePath));
			if (oldFile.exists()) {
				oldFile.delete();
			}
			// 删除数据库
			getServiceManager().getProductService().deleteProductById(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.PRODUCT_DELETE_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_PRODUCT);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.PRODUCT_DELETE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	public String preAddTour() throws Exception {
		product = getServiceManager().getProductService().getProductById(
				getParametersAsMap());
		productTourList = getServiceManager().getProductService()
				.getProductTourByProductId(getParametersAsMap());
		setPageSize(20);
		tourList = getServiceManager().getTourService().getAllTours();
		return "preAddTour";
	}

	public String addTour() {
		try {
			getServiceManager().getProductService().addProductTour(
					getParametersAsMap());
			setResult(SUCCESS);
			addMessage(AlertMessage.PRODUCT_TOUR_ADD_SUCCESS);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_PRODUCT);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(AlertMessage.PRODUCT_TOUR_ADD_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}
}
