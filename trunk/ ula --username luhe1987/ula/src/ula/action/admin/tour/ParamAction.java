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

	public List<Map<String, Object>> getVacationTypeList() {
		return vacationTypeList;
	}

	public String vacationTypeAdmin() throws Exception {
		vacationTypeList = getServiceManager().getTourService()
				.getAllTourVacationTypes();
		return "vacationTypeAdmin";
	}

}
