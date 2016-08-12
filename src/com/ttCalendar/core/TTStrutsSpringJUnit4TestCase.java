/*
 * ttCalendar
 */
package com.ttCalendar.core;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * TTStrutsSpringJUnit4TestCase
 * @author hexin0614@gmail.com
 */
public abstract class TTStrutsSpringJUnit4TestCase<T> extends StrutsSpringJUnit4TestCase<T> {

	/*
	 * (non-Javadoc)
	 * @see org.apache.struts2.StrutsJUnit4TestCase#setUp()
	 */
	@Override
	public void setUp() throws Exception {
		
		super.setUp();
		
		// TTCalendar require HTTPS connection & POST method
		request.setScheme("HTTPS");
		request.setMethod("POST");
		
		// Declare spring settings file
		String[] config = new String[] {"classpath:applicationContext.xml"};

		// Link the servlet context and the Spring context
		servletContext = new MockServletContext();
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setServletContext(servletContext);
		appContext.setConfigLocations(config);
		appContext.refresh();
		servletContext.setAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
				appContext);
	}
}
