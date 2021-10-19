package com.comviva.tpapi.beans;

import javax.xml.bind.annotation.XmlElement;

public class BlackListInfoBean {
	
	private String reason;
    private boolean isBlackListed;
    private String setTime;
    private String endTime;
    private String type;
    
    
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@XmlElement(name="is_blacklisted",nillable=true)
	public boolean isBlackListed() {
		return isBlackListed;
	}
	public void setBlackListed(boolean isBlackListed) {
		this.isBlackListed = isBlackListed;
	}
	
	@XmlElement(name="set_time",nillable=true)
	public String getSetTime() {
		return setTime;
	}
	public void setSetTime(String setTime) {
		this.setTime = setTime;
	}
	
	@XmlElement(name="end_time",nillable=true)
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@XmlElement(nillable=true)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
    

}
