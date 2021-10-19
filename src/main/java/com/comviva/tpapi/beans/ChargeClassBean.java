package com.comviva.tpapi.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


public class ChargeClassBean {
    private String serviceKey;
    private String amount;
    private String renewalAmount;
    private String currency;
    private String validityDays;
    private String renewalValidityDays;
    private String renewal;
    private String circleId;
    
    /*
     * following parameter is not required in the response/request.
     *  Hence keeping it transient and nillable
     */

    private String serviceId;

    
    @XmlElement(name="service_key",nillable=true)
    public String getServiceKey() {
        return serviceKey;
    }
    @XmlElement(nillable=true)
    public String getAmount() {
        return amount;
    }
    @XmlElement(name="renewal_amount",nillable=true)
    public String getRenewalAmount() {
        return renewalAmount;
    }
    public String getCurrency() {
        return currency;
    }
    @XmlElement(name="validity_days")
    public String getValidityDays() {
        return validityDays;
    }
    @XmlElement(name="renewal_validity_days",nillable=true)
    public String getRenewalValidityDays() {
        return renewalValidityDays;
    }
    @XmlElement(nillable=true)
    public String getRenewal() {
        return renewal;
    }
    @XmlElement(name="circle_i_d",nillable=true)
    public String getCircleId() {
        return circleId;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setValidityDays(String validityDays) {
        this.validityDays = validityDays;
    }
    public void setRenewalValidityDays(String renewalValidityDays) {
        this.renewalValidityDays = renewalValidityDays;
    }
    public void setRenewal(String renewal) {
        this.renewal = renewal;
    }
    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public void setServiceKey(String serviceKey) {
        this.serviceKey = serviceKey;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public void setRenewalAmount(String renewalAmount) {
        this.renewalAmount = renewalAmount;
    }
    
    @XmlTransient
    @XmlElement(nillable=true)
    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}


