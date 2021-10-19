package com.comviva.tpapi.utils;

public class CommonUtils {
	
	public static int getPartitionId(String input) {
        int id = 0;
        if (input != null && input.length() > 0) {
            try {
                id = Integer.parseInt(input.substring(input.length() - 1));
            } catch (NumberFormatException e) {
            }
        }
        return id;
    }
	
	public static boolean parseIntToBoolean(int val){
        return val !=0;
    }

}
