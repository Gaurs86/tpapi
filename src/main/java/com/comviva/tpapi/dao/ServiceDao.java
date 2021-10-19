package com.comviva.tpapi.dao;

import com.comviva.tpapi.dto.SubProfileDto;
import com.comviva.tpapi.dto.SubTransInfoDto;
import com.comviva.tpapi.exceptions.DBOperationException;

public interface ServiceDao {
	
	SubProfileDto getSubscriberProfile(String msisdn) throws DBOperationException;
	
	SubTransInfoDto getSubTransInfo(String msisdn, int type) throws DBOperationException;
	
	
}
