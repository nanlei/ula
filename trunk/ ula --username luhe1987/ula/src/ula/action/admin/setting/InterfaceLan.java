package ula.action.admin.setting;

import java.util.Map;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;
import ula.constant.ErrorConstants;
import ula.util.StringUtil;

public class InterfaceLan extends CommonAction {
	private String  rediretTo ="/admin/setting/interface!admin.action";
	private PagingList lanList = null; //涉及分页的所有页面语言元素
	private Map lanMap = null; // 单个页面语言元素的Map表示
	
	private String lang_CN =""; //界面使用的汉语
	private String lang_RU=""; //界面使用的俄语
	private String lang_TAG=""; //界面索引
	
	/**
	 * 添加界面元素
	 * @return
	 */
	public String add(){
//		解决乱码
//		this.lang_CN =StringUtil.UTF8Encoding(lang_CN);
//		this.lang_RU = StringUtil.UTF8Encoding(lang_RU);
//		this.lang_TAG = StringUtil.UTF8Encoding(lang_TAG);
		
//		debug log
		super.debug("lang_CN:"+ this.lang_CN +", Lang_RU:" +this.lang_RU+", lang_TAG" + this.lang_TAG);
		
		int db_result = 0;
//		操作数据库
		try {
			db_result = super.getServiceManager().getSettingService().addInfo(this.lang_CN, this.lang_RU,this.lang_TAG);
			if(db_result==1){
				super.setAlertMessage(AlertMessage.INSERT_SUCCESS);
			}
		} catch (Exception e) {
//			出错给出错误信息，并转到错误页面
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setErrorMessage(ErrorConstants.INSERT_ERROR);
			
			return ERROR;
		}
//		返回操作界面
		super.setRedirctURL(rediretTo);
		return REDIRECT;
	}
	
	/**
	 * 界面元素操作界面
	 * @return
	 */
	public String admin(){
		this.lanList = super.getServiceManager().getSettingService().getAllInfo();
		
		if(this.lanList.getList().size()==0){
			super.setAlertMessage(AlertMessage.INFO_EMPTY );
			return "admin";
		}
		return "admin";
	}
	/**
	 * 编辑界面元素
	 * @return
	 */
	public String edit(){
//		获取ID
		String Id = super.getHttpServletRequest().getParameter("id");
//		验证ID 
		if(StringUtil.isEmpty(Id)){
			super.setAlertMessage(AlertMessage.INFO_EMPTY);
			return this.admin();
		}

		
		try {
			this.lanMap = super.getServiceManager().getSettingService().getInfoById(Id);
			super.debug(this.lanMap.toString());
		} catch (Exception e) {
           super.debug(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return "edit";
	}
	public PagingList getLanList() {
		return lanList;
	}
	

	public Map getLanMap() {
		return lanMap;
	}

	/**
	 * 转向添加页面
	 * @return
	 */
	public String preAdd(){
		return "preAdd";
	}

	/**
	 * 删除
	 * @return
	 */
	public String remove(){
//		获取ID
		String Id = super.getHttpServletRequest().getParameter("id");
//		验证ID 
		if(StringUtil.isEmpty(Id)){
			super.setAlertMessage(AlertMessage.INFO_EMPTY);
			return this.admin();
		}
		
		int db_result =0;
		
		try {
			db_result = super.getServiceManager().getSettingService().deleteInfoById(Id);
			if(db_result==1){
				super.setAlertMessage(AlertMessage.DELTE_SUCCESS);
			}
		} catch (Exception e) {
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setAlertMessage(AlertMessage.DELTE_ERROR);
			return this.admin();
		}
		
		return this.admin();
	}

	public void setLang_CN(String langCN) {
		lang_CN = langCN;
	}
	
	public void setLang_RU(String langRU) {
		lang_RU = langRU;
	}
	
	
	public void setLang_TAG(String langTAG) {
		lang_TAG = langTAG;
	}

	/**
	 * 更新界面元素
	 * @return
	 */
	public String update(){
//		获取ID
		String Id = super.getHttpServletRequest().getParameter("id");
//		验证ID 
		if(StringUtil.isEmpty(Id)){
			super.setAlertMessage(AlertMessage.INFO_EMPTY);
			return this.admin();
		}
		
//		解决乱码
//		this.lang_CN =StringUtil.UTF8Encoding(lang_CN);
//		this.lang_RU = StringUtil.UTF8Encoding(lang_RU);
//		this.lang_TAG = StringUtil.UTF8Encoding(lang_TAG);
		
//		debug log
		super.debug("lang_CN:"+ this.lang_CN +", Lang_RU:" +this.lang_RU+", lang_TAG: " + this.lang_TAG);
		
		int db_result = 0;
//		操作数据库
		try {
			db_result = super.getServiceManager().getSettingService().updateInfo(this.lang_CN, this.lang_RU,this.lang_TAG,Id);
			if(db_result==1){
				super.setAlertMessage(AlertMessage.UPDATE_SUCCESS);
			}
		} catch (Exception e) {
//			出错给出错误信息，并转到错误页面
			super.debug(e.getMessage());
			e.printStackTrace();
			super.setErrorMessage(ErrorConstants.INSERT_ERROR);
			
			return ERROR;
		}
//		返回操作界面
		super.setRedirctURL(rediretTo);
		return REDIRECT;
	}

}
