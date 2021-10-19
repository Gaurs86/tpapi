package com.comviva.tpapi.beans;

import javax.xml.bind.annotation.XmlElement;

;

public class ExtraInfoBean {
	
	private String transId;
    private String reasonCode;
    private String udsOptin;
    
    public ExtraInfoBean() {
    	
    	
    }
    
    @XmlElement(name="TRANS_ID",nillable=true)
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	
    @XmlElement(name="REASON_CODE",nillable=true)
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	@XmlElement(name="UDS_OPTIN")
	public String getUdsOptin() {
		return udsOptin;
	}
	public void setUdsOptin(String udsOptin) {
		this.udsOptin = udsOptin;
	}
    
    
    
    

}
