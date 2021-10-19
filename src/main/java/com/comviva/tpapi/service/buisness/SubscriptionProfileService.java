package com.comviva.tpapi.service.buisness;

import java.util.ArrayList;
import java.util.List;

import com.comviva.tpapi.beans.SubProfileRequestBean;
import com.comviva.tpapi.beans.SubProfileResponseBean;
import com.comviva.tpapi.dao.ServiceDao;
import com.comviva.tpapi.db.sql.ServiceDaoImpl;
import com.comviva.tpapi.service.gw.ServiceHandlingInterface;
import com.comviva.tpapi.staticResources.AppConstants;
import com.comviva.tpapi.staticResources.SubsStatus;
import com.comviva.tpapi.staticResources.TransactionType;
import com.comviva.tpapi.utils.DateTimeUtil;
import com.comviva.tpapi.beans.ChargeClassBean;
import com.comviva.tpapi.beans.ExtraInfoBean;
import com.comviva.tpapi.beans.BlackListInfoBean;
import com.comviva.tpapi.dto.SubProfileDto;
import com.comviva.tpapi.dto.SubTransInfoDto;
import com.comviva.tpapi.exceptions.DBOperationException;
import com.comviva.tpapi.exceptions.SysException;

public class SubscriptionProfileService implements ServiceHandlingInterface {
	
	private final ServiceDao serviceDao = new ServiceDaoImpl();
	
	
	public Object processRequest(Object reqObject) {
		SubProfileRequestBean profileReqBean = (SubProfileRequestBean) reqObject;
		System.out.println(profileReqBean.getSubscriberId());
		String msisdn = profileReqBean.getSubscriberId();
		
		List<SubProfileResponseBean> responseList = new ArrayList<>();
		SubProfileResponseBean subProfileBean = makeUserRbtProfile(msisdn);
		responseList.add(subProfileBean);
		return responseList;
		
	}
	
	public SubProfileResponseBean makeUserRbtProfile(String msisdn) {
		
		System.out.println("makeUserRBT "+msisdn);
		SubProfileResponseBean subProfileBean = new SubProfileResponseBean();
		subProfileBean.setId(msisdn);
		
        SubTransInfoDto transDto = getTransDto(msisdn);
        SubProfileDto subDto = getProfileDto(msisdn);

        subProfileBean.setStatus(getSubscriptionStatus(msisdn, transDto, subDto));

        if (subDto == null || SubsStatus.CANCELED.getStatus().equalsIgnoreCase(subProfileBean.getStatus())) {
            
            subProfileBean.setOperator(AppConstants.OPERATOR);
            subProfileBean.setType(AppConstants.PROD_TYPE);
            subProfileBean.setAccountType(AppConstants.ACC_TYPE_INDIVIDUAL);
            subProfileBean.setLanguage(AppConstants.LANGUAGE);
            /**
             *  Set Default Charge Class For new User
             */
            setDefaultChargeClasses(msisdn, subProfileBean);
        } else {
            subProfileBean.setOperator(AppConstants.OPERATOR);
            subProfileBean.setType(AppConstants.PROD_TYPE);
            subProfileBean.setAccountType(AppConstants.ACC_TYPE_INDIVIDUAL);
            subProfileBean.setLanguage(AppConstants.LANGUAGE);
           //subProfileBean.setCircle(MemCache.getCirclesMap().get(subDto.getCircleId()));
            subProfileBean.setSubId(subDto.getSubId());
            //subProfileBean.setActivatedBy(MemCache.getInterfaceMap().get(subDto.getProvInterface()));
            
            if(!String.valueOf(SubsStatus.CANCELED.getStatusVal()).equalsIgnoreCase(subDto.getSubStatus())){
                subProfileBean.setUdsSubscriber(subDto.isUdsFlag());
            }
            setUdsOnResponse(subProfileBean, subDto);
            
            /**
             * Provisioning Dates Setting
             */
            subProfileBean.setStartDate(DateTimeUtil.formatDbDateToTpDate(subDto.getProvisionDate()));
            subProfileBean.setEndDate(DateTimeUtil.formatDbDateToTpDate(subDto.getProvisionEndDate()));
            subProfileBean.setRenewalDate(DateTimeUtil.formatDbDateToTpDate(subDto.getRenewalDate()));
            subProfileBean.setLastBilledDate(DateTimeUtil.formatDbDateToTpDate(subDto.getLastBillingDate()));
            subProfileBean.setSubValidity(subDto.getSubValidity());
            
            subProfileBean.setLastBillAmount(subDto.getLastChrgAmount());
            /**
             * BlackList Details Setting
             */
            setBlackListInfo(subDto, subProfileBean);

            /**
             * Set Subscriber Type to Prepaid Or Postpaid
             */
            setSubscriberType(subDto, subProfileBean);

            /**
             * Subscription Charge Class Details Setting
             */
            setSubscriptionChargeClass(subDto, subProfileBean);
            
            /**
             * Tone Charge class details setting
             */
            //setMappedToneChargeClass(subDto,subProfileBean);
        }
        
        return subProfileBean;
	}
	
    private void setSubscriptionChargeClass(SubProfileDto subDto, SubProfileResponseBean subProfileBean) {
    	
    	ChargeClassBean subClass = new ChargeClassBean();
    	
    	subClass.setAmount(subProfileBean.getLastBillAmount());
        subClass.setValidityDays(subProfileBean.getSubValidity());
        subProfileBean.setSrvKey("r");
        subProfileBean.setSubChargeClass(subClass);
        subProfileBean.setClassOfService("e");
		
	}

	private void setDefaultChargeClasses(String msisdn, SubProfileResponseBean subProfileBean) {
    	
    	ChargeClassBean subClass = new ChargeClassBean();
    	
    	subProfileBean.setSubChargeClass(subClass);
        subProfileBean.setSrvKey("COM_ACT_NDT_49_28D");
        subProfileBean.setClassOfService("COM_ACT_NDT_49_28D");
		
	}

	public static String getSubscriptionStatus(String msisdn, SubTransInfoDto transDto, SubProfileDto subDto) {
        String status = null;
        if (transDto == null && subDto == null) {
           
            status = SubsStatus.NEW.getStatus();
        } else if (transDto != null) {
            
            TransactionType trType = TransactionType.enumValueOf(transDto.getTransactionType());

            if (TransactionType.SUB_ONLY == trType || TransactionType.SUB_WITH_TONE == trType) {
                status = TransactionType.SUB_ONLY.getTransStatus();
            } else if (TransactionType.DEL_SUB == trType) {
                status = TransactionType.DEL_SUB.getTransStatus();
            }else if(TransactionType.TONE_DEL == trType){
            	status = TransactionType.TONE_DEL.getTransStatus();
            }else{
                status = SubsStatus.enumValueOf(subDto.getSubStatus()).getStatus();
            }
        } else {
            status = SubsStatus.enumValueOf(subDto.getSubStatus()).getStatus();
        }

        return status;
    }

	private SubTransInfoDto getTransDto(String msisdn) {
		
		SubTransInfoDto transDto;
		
		try {
			transDto = serviceDao.getSubTransInfo(msisdn,AppConstants.PENDING_TRANSACTION_TYPE_SUB);
		} catch (DBOperationException e) {
			
			throw new SysException(AppConstants.RBT_ERROR_DB_DOWN);
		}
		return transDto;
	}

	private SubProfileDto getProfileDto(String msisdn) {
		
		SubProfileDto subDto;
		try {
			subDto = serviceDao.getSubscriberProfile(msisdn);
		} catch (DBOperationException e) {
			
			throw new SysException(AppConstants.RBT_ERROR_DB_DOWN);
		}
		return subDto;
	}

	private static void setUdsOnResponse(SubProfileResponseBean subProfileBean, SubProfileDto subDto) {
        if(subDto.isUdsFlag()){
            ExtraInfoBean extraInfo = subProfileBean.getExtraInfoClass();
            
            if(extraInfo == null){
                extraInfo = new ExtraInfoBean();
            }
            
            if (subDto.isUdsFlag()) {
                extraInfo.setUdsOptin("TRUE");
            }

            subProfileBean.setExtraInfoClass(extraInfo);
        }
    }
	
	private static void setBlackListInfo(SubProfileDto subDto, SubProfileResponseBean subProfileBean) {
        if (subDto.getBlackListMsisdn() != null) {
            subProfileBean.setSelectionBlocked(true);
            subProfileBean.setBlSetTime(subDto.getBlackListTime());

            BlackListInfoBean blBean = new BlackListInfoBean();
            blBean.setBlackListed(true);
            blBean.setSetTime(subDto.getBlackListTime());
            subProfileBean.setBlackListClass(blBean);
        }
    }
	
	private static void setSubscriberType(SubProfileDto subDto, SubProfileResponseBean subProfileBean) {
        if ("P".equalsIgnoreCase(subDto.getSubsCategory())) {
            subProfileBean.setSubscriberType(AppConstants.PREPAID_TYPE);
        } else if ("B".equalsIgnoreCase(subDto.getSubsCategory())) {
            subProfileBean.setSubscriberType(AppConstants.POSTPAID_TYPE);
        }
    }
}
