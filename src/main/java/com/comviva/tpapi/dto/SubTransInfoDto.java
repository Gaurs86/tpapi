package com.comviva.tpapi.dto;

public class SubTransInfoDto {
	
	private String subType;
    private String serviceType;
    private String transactionType;
    private String transactionLeg;
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionLeg() {
		return transactionLeg;
	}
	public void setTransactionLeg(String transactionLeg) {
		this.transactionLeg = transactionLeg;
	}
    
    

}
