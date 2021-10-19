package com.comviva.tpapi.db.sql;

import java.util.List;

import com.comviva.tpapi.dao.ServiceDao;
import com.comviva.tpapi.dto.SubProfileDto;
import com.comviva.tpapi.dto.SubTransInfoDto;
import com.comviva.tpapi.exceptions.DBOperationException;
import com.comviva.tpapi.staticResources.AppQueryProvider;
import com.comviva.tpapi.staticResources.ConfigurationsProvider;
import com.comviva.tpapi.staticResources.AppConstants;
import com.comviva.tpapi.utils.CommonUtils;

public class ServiceDaoImpl implements ServiceDao{
	
	private final DBUtility dbUtil = new DBUtility();
	@Override
    public SubProfileDto getSubscriberProfile(String msisdn) throws DBOperationException {
        SubProfileDto subProfileDto = null;


        Integer partitionId = CommonUtils.getPartitionId(msisdn);
       
        String subProfileQuery = AppQueryProvider.getSubProfileQuery().replace("{mdn}", msisdn).replace("{prtId}", partitionId.toString());

        List<String> dataList = null;//dbUtil.getQueryResult(subProfileQuery, ConfigurationsProvider.getTransQueryTimeout());

        if (dataList == null || dataList.isEmpty()) {
            
        } else {
            subProfileDto = new SubProfileDto();
            for (int i = 0; i < dataList.size(); i += 18) {
                subProfileDto.setSubMsisdn(dataList.get(i));
                subProfileDto.setSubStatus(dataList.get(i + 1));
                subProfileDto.setBlackListMsisdn(dataList.get(i + 2));
                subProfileDto.setBlackListTime(dataList.get(i + 3));
                subProfileDto.setSmsLang(dataList.get(i + 4));
                subProfileDto.setSubId(dataList.get(i + 5));
                subProfileDto.setCircleId(dataList.get(i + 6));
                subProfileDto.setSubsCategory(dataList.get(i + 7));
                subProfileDto.setServiceKey(dataList.get(i + 8));
                subProfileDto.setLastChrgAmount(dataList.get(i + 9));
                subProfileDto.setProvisionDate(dataList.get(i + 10));
                subProfileDto.setLastBillingDate(dataList.get(i + 11));
                subProfileDto.setProvisionEndDate(dataList.get(i + 12));
                subProfileDto.setRenewalDate(dataList.get(i + 13));
                subProfileDto.setSubValidity(dataList.get(i + 14));
                subProfileDto.setReferenceId(dataList.get(i + 15));
                subProfileDto.setUdsFlag(CommonUtils.parseIntToBoolean(Integer.parseInt(dataList.get(i + 16))));
                subProfileDto.setProvInterface(dataList.get(i + 17));
            }
        }
        
        return subProfileDto;
    }
	
	@Override
	public SubTransInfoDto getSubTransInfo(String msisdn, int type) throws DBOperationException {
		
		SubTransInfoDto subTransDto = null;
		String transInfoQuery ;
		System.out.println(msisdn+" gdfg");
        if(AppConstants.PENDING_TRANSACTION_TYPE_TONE == type){
            transInfoQuery = AppQueryProvider.getToneTransInfoQuery().replace("{mdn}", msisdn);
        }else{
            transInfoQuery = AppQueryProvider.getSubTransInfoQuery().replace("{mdn}", msisdn);
            System.out.println(transInfoQuery);
        }

        List<String> dataList = null;// dbUtil.getQueryResult(transInfoQuery, ConfigurationsProvider.getTransQueryTimeout());

        if (dataList == null || dataList.isEmpty()) {
            
        } else {
            subTransDto = new SubTransInfoDto();
            for (int i = 0; i < dataList.size(); i += 4) {
                subTransDto.setSubType(dataList.get(i));
                subTransDto.setServiceType(dataList.get(i + 1));
                subTransDto.setTransactionType(dataList.get(i + 2));
                subTransDto.setTransactionLeg(dataList.get(i + 3));
            }
        }
		
		return subTransDto;
	}
	

}
