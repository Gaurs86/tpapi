package com.comviva.tpapi.staticResources;

import java.io.InputStream;
import java.util.Properties;
import com.comviva.tpapi.staticResources.AppQueryProvider;

public class AppQueryProvider {
	private static Properties queryFile = new Properties();
	private static String subProfileQuery;
	private static String toneTransInfoQuery;
	private static String subTransInfoQuery;
	
	public static synchronized boolean loadQueryFileIntoApp() {
		boolean isLoaded = false;
		try (InputStream is = AppQueryProvider.class.getClassLoader().getResourceAsStream("dbQueries.properties")) { 
			queryFile.load(is);
			subProfileQuery = readQuery(queryFile, "GET_SUB_PROFILE");
			toneTransInfoQuery = readQuery(queryFile, "GET_TONE_TRANS_INFO");
			subTransInfoQuery = readQuery(queryFile, "GET_SUB_TRANS_INFO");
			System.out.println(subTransInfoQuery);
			isLoaded = true;
		}catch (Exception e) {
			System.err.println("appqueryProvider");
		}
    	return isLoaded;
	}
	private static String readQuery(Properties queryFile , String queryName){
        String query = queryFile.getProperty(queryName).trim();
        return query;
    }
	
	public static String getSubProfileQuery() {
		return subProfileQuery;
	}
	public static String getToneTransInfoQuery() {
		
		return toneTransInfoQuery;
	}
	public static String getSubTransInfoQuery() {
		
		return subTransInfoQuery;
	}
	
	
}
