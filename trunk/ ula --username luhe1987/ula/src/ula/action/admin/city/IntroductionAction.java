package ula.action.admin.city;

import ula.action.CommonAction;

/**
 * 大连介绍
 * 
 * @author Harry
 * 
 */
public class IntroductionAction extends CommonAction {
	private String value;

	public String getValue() {
		return value;
	}

	public String test() {
		value = "aaaa";
		return "test";
	}
}
