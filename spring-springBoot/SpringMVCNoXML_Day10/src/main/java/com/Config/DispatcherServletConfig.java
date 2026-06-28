package com.Config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//                                           AACD is an Abstract class which contains unimplemented methods
public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?> @Nullable [] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?> @Nullable [] getServletConfigClasses() {
	
		Class[] configs = {Config.class};
		return configs;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mappings = {"/flm/*"};
		
		return mappings;
	}

	
	
	

}
