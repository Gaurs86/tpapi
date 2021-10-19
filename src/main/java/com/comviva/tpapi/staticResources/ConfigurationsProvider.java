package com.comviva.tpapi.staticResources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigurationsProvider {
	
	private static String dataSource;
	private static int transQueryTimeout;
	public static synchronized boolean readProperties() {
		boolean isPropertyLoadedSuccessfully = false;
		
		try (InputStream is = ConfigurationsProvider.class.getClassLoader().getResourceAsStream("tpapi.properties")) {
			Properties  propertyFileName = new Properties();
            propertyFileName.load(is);
            
            dataSource = readStringParam(propertyFileName, "DATA_SOURCE");
            transQueryTimeout = readIntParam(propertyFileName, "TRANSACTION_QUERY_TIMEOUT_IN_SECONDS");
            isPropertyLoadedSuccessfully = true;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return isPropertyLoadedSuccessfully;
	}

	private static Integer readIntParam(Properties propertyFileName, String paramName) {
		Integer property = Integer.parseInt(propertyFileName.getProperty(paramName).trim());
		return property;
	}

	private static String readStringParam(Properties propertyFileName, String paramName) {
		
		String property = propertyFileName.getProperty(paramName).trim();
		return property;
	}

	public static String getDataSource() {
		return dataSource;
	}

	public static int getTransQueryTimeout() {
		
		return transQueryTimeout;
	}
	
	
	
}
