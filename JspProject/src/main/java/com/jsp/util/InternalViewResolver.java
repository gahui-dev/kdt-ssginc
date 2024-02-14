package com.jsp.util;

public interface InternalViewResolver {
	public static final String PREFIX = "WEB-INF/view/";
	public static final String SURFIX = ".jsp";
	public static final String FORMAT_RESOLVER = PREFIX + "%s" + SURFIX;
	
	public static String getResolveViewUrl(String viewName) {
		return String.format(FORMAT_RESOLVER, viewName);
	}
}
