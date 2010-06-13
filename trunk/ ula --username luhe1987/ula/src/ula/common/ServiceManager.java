package ula.common;

import ula.service.admin.AboutService;
import ula.service.admin.CityServcie;
import ula.service.admin.ContactService;
import ula.service.admin.LogService;

public class ServiceManager {
	
	/*
	 * 这里是所有Service的集合。并提供Getter 和 Setter
	 */
	
	private LogService logService = null;
	private AboutService aboutService = null;
	private ContactService contactService = null;
	private CityServcie cityServcie = null;
	
	public CityServcie getCityServcie() {
		return cityServcie;
	}

	public void setCityServcie(CityServcie cityServcie) {
		this.cityServcie = cityServcie;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public AboutService getAboutService() {
		return aboutService;
	}

	public void setAboutService(AboutService aboutService) {
		this.aboutService = aboutService;
	}

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
}
