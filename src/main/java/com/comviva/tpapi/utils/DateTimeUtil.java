package com.comviva.tpapi.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

	private static DateTimeFormatter tpDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");;
	private static DateTimeFormatter dbDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

	public static String formatDbDateToTpDate(String inputDate) {
		
		
	   return LocalDateTime.parse(inputDate, dbDateFormatter).atZone(ZoneId.systemDefault()).format(tpDateTimeFormatter);
	    
	}

}
