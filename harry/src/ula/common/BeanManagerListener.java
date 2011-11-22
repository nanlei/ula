// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BeanManagerListener.java

package ula.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class BeanManagerListener implements ServletContextListener {
	
	public BeanManagerListener() {
	}

	public void contextInitialized(ServletContextEvent event) {
		BeanManager.init(event.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent servletcontextevent) {
	}
}
