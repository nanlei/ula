package ula.action.admin.tour;

import java.util.List;
import java.util.Map;

import ula.action.BaseAction;

/**
 * 行程相关参数管理
 * 
 * @author Nanlei
 * 
 */
public class ParamAction extends BaseAction {
	public List<Map<String, Object>> vacationTypeList;
	public List<Map<String, Object>> tourCategoryList;

	public List<Map<String, Object>> getVacationTypeList() {
		return vacationTypeList;
	}

	public List<Map<String, Object>> getTourCategoryList() {
		return tourCategoryList;
	}

	public String vacationTypeAdmin() throws Exception {
		vacationTypeList = getServiceManager().getTourService()
				.getAllTourVacationTypes();
		return "vacationTypeAdmin";
	}

	/**
	 * 根据休假类型获取对应的行程分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String vacationTypeInfo() throws Exception {
		tourCategoryList = getServiceManager().getTourService()
				.getTourCategoryByVacationType(getParametersAsMap());
		return "vacationTypeInfo";
	}

}
