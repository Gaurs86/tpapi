package com.comviva.tpapi.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SubProfileRequestBean {
	
	private String subscriberId;
    private String mode;
    private String storeId;
    
    
    
	public SubProfileRequestBean() {
		
	}
	
	
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	@Override
	public String toString() {
		return "SubProfileRequestBean [subscriberId=" + subscriberId + ", mode=" + mode + ", storeId=" + storeId + "]";
	}
    
    

}
