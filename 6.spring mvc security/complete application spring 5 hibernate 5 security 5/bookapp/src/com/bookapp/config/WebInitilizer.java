package com.bookapp.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bookapp.security.config.SecurityConfig;

public class WebInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppConfig.class, SecurityConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	//Configuration for error handling
	@Override
	protected FrameworkServlet createDispatcherServlet(
			WebApplicationContext servletAppContext) {
		DispatcherServlet ds=new DispatcherServlet(servletAppContext);
		ds.setThrowExceptionIfNoHandlerFound(true);
		return ds;
	}

}
