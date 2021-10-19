package com.comviva.tpapi.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ThirdPartyConsentBean {
	
	private String id;
    private String thirdPartyUrl;
    private String returnUrl;
    private String omParam3;
    private String omCallbackUrl;
    
    private String childRefId;
    
    @XmlElement(name="id",nillable=true)
	public String getId() {
		return id;
	}
    
    @XmlElement(name="third_party_url",nillable=true)
	public String getThirdPartyUrl() {
		return thirdPartyUrl;
	}
    
    @XmlElement(name="return_url",nillable=true)
	public String getReturnUrl() {
		return returnUrl;
	}
    
    @XmlTransient
	public String getOmParam3() {
		return omParam3;
	}
    
    @XmlTransient
	public String getOmCallbackUrl() {
		return omCallbackUrl;
	}
    @XmlTransient
	public String getChildRefId() {
		return childRefId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setThirdPartyUrl(String thirdPartyUrl) {
		this.thirdPartyUrl = thirdPartyUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public void setOmParam3(String omParam3) {
		this.omParam3 = omParam3;
	}

	public void setOmCallbackUrl(String omCallbackUrl) {
		this.omCallbackUrl = omCallbackUrl;
	}

	public void setChildRefId(String childRefId) {
		this.childRefId = childRefId;
	}
    
    

}
