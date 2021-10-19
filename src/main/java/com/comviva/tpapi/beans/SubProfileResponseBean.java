package com.comviva.tpapi.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@XmlRootElement
public class SubProfileResponseBean {
    private String id;
    private String type;
    private List<String> rights;
    
    private String startDate;
    private String endDate;
    private String lastBilledDate;
    private String lastBillAmount;
    private String language;
    
    private String accountType;
    private String subscriberType;
    
    private String activatedBy;
    private String deactivatedBy;
    
    private boolean isDndEnabled;
    private boolean canAllow;    

    private String blReason;
    private String blSetTime;
    
    private boolean isSelectionBlocked;
    
    private ChargeClassBean subChargeClass;
    private ChargeClassBean toneChargeClass;
    private BlackListInfoBean blackListClass;

    private List<String> credits;
    private String renewalDate;
    private String classOfService;
    
    private String srvKey;
    private ThirdPartyConsentBean thirdPartyConsent;
    private String operator;
    private String circle;
    private String operatorUserType;
    
    private ExtraInfoBean extraInfoClass;
    
    private String billingInfo;
    private boolean legacyDctRequired;
    private int catalogSubscriptionId;
    private boolean automaticRenewal;
    private String status;
    
    /**
     * Below Fields Are XmlTransient . Not to provided in Response
     */
    private boolean udsSubscriber;
    private String subId;
    private String subValidity;
    
    @XmlElement(nillable=true)
    public String getId() {
        return id;
    }
    @XmlElement(nillable=true)
    public String getType() {
        return type;
    }
    @XmlElement(nillable=true)
    public List<String> getRights() {
        return rights;
    }

    @XmlElement(name="start_date")
    public String getStartDate() {
        return startDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRights(List<String> rights) {
        this.rights = rights;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @XmlElement(name="subscription_class", nillable=true)
    public ChargeClassBean getSubChargeClass() {
        return subChargeClass;
    }

    public void setSubChargeClass(ChargeClassBean subChargeClass) {
        this.subChargeClass = subChargeClass;
    }

    @XmlElement(name="end_date",nillable=true)
    public String getEndDate() {
        return endDate;
    }

    @XmlElement(name="last_billed_date",nillable=true)
    public String getLastBilledDate() {
        return lastBilledDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setLastBilledDate(String lastBilledDate) {
        this.lastBilledDate = lastBilledDate;
    }

    @XmlElement(name="last_bill_amount",nillable=true)
    public String getLastBillAmount() {
        return lastBillAmount;
    }

    @XmlElement(nillable=true)
    public String getLanguage() {
        return language;
    }
    @XmlElement(name="account_type",nillable=true)
    public String getAccountType() {
        return accountType;
    }
    @XmlElement(name="subscriber_type",nillable=true)
    public String getSubscriberType() {
        return subscriberType;
    }
    @XmlElement(name="activated_by",nillable=true)
    public String getActivatedBy() {
        return activatedBy;
    }
    @XmlElement(name="deactivated_by",nillable=true)
    public String getDeactivatedBy() {
        return deactivatedBy;
    }
    @XmlElement(name="is_dnd_enabled",nillable=true)
    public boolean isDndEnabled() {
        return isDndEnabled;
    }
    @XmlElement(name="can_allow",nillable=true)
    public boolean isCanAllow() {
        return canAllow;
    }
    @XmlElement(name="bl_reason",nillable=true)
    public String getBlReason() {
        return blReason;
    }
    @XmlElement(name="bl_set_time",nillable=true)
    public String getBlSetTime() {
        return blSetTime;
    }
    @XmlElement(name="is_selection_blocked",nillable=true)
    public boolean isSelectionBlocked() {
        return isSelectionBlocked;
    }
    @XmlElement(name="charge_class",nillable=true)
    public ChargeClassBean getToneChargeClass() {
        return toneChargeClass;
    }
    @XmlElement(name="blacklist_info",nillable=true)
    public BlackListInfoBean getBlackListClass() {
        return blackListClass;
    }
    @XmlElement(nillable=true)
    public List<String> getCredits() {
        return credits;
    }
    @XmlElement(name="renewal_date",nillable=true)
    public String getRenewalDate() {
        return renewalDate;
    }
    @XmlElement(name="class_of_service",nillable=true)
    public String getClassOfService() {
        return classOfService;
    }
    @XmlElement(name="srv_key",nillable=true)
    public String getSrvKey() {
        return srvKey;
    }
    @XmlElement(name="thirdpartyconsent",nillable=true)
    public ThirdPartyConsentBean getThirdPartyConsent() {
        return thirdPartyConsent;
    }
    @XmlElement(nillable=true)
    public String getOperator() {
        return operator;
    }
    @XmlElement(nillable=true)
    public String getCircle() {
        return circle;
    }
    @XmlElement(name="operator_user_type",nillable=true)
    public String getOperatorUserType() {
        return operatorUserType;
    }
    @XmlElement(name="extra_info",nillable=true)
    public ExtraInfoBean getExtraInfoClass() {
        return extraInfoClass;
    }
    @XmlElement(name="billing_info",nillable=true)
    public String getBillingInfo() {
        return billingInfo;
    }
    @XmlElement(name="legacy_dct_required",nillable=true)
    public boolean isLegacyDctRequired() {
        return legacyDctRequired;
    }
    @XmlElement(name="catalog_subscription_id",nillable=true)
    public int getCatalogSubscriptionId() {
        return catalogSubscriptionId;
    }
    @XmlElement(name="automatic_renewal",nillable=true)
    public boolean isAutomaticRenewal() {
        return automaticRenewal;
    }
    @XmlElement(nillable=true)
    public String getStatus() {
        return status;
    }
    
    @XmlTransient
    public boolean isUdsSubscriber() {
        return udsSubscriber;
    }
    
    @XmlTransient
    public String getSubId() {
        return subId;
    }
    
    @XmlTransient
    public String getSubValidity() {
        return subValidity;
    }
    
    public void setSubValidity(String subValidity) {
        this.subValidity = subValidity;
    }
    public void setSubId(String subId) {
        this.subId = subId;
    }
    public void setUdsSubscriber(boolean udsSubscriber) {
        this.udsSubscriber = udsSubscriber;
    }
    
    public void setLastBillAmount(String lastBillAmount) {
        this.lastBillAmount = lastBillAmount;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setSubscriberType(String subscriberType) {
        this.subscriberType = subscriberType;
    }

    public void setActivatedBy(String activatedBy) {
        this.activatedBy = activatedBy;
    }

    public void setDeactivatedBy(String deactivatedBy) {
        this.deactivatedBy = deactivatedBy;
    }

    public void setDndEnabled(boolean isDndEnabled) {
        this.isDndEnabled = isDndEnabled;
    }

    public void setCanAllow(boolean canAllow) {
        this.canAllow = canAllow;
    }

    public void setBlReason(String blReason) {
        this.blReason = blReason;
    }

    public void setBlSetTime(String blSetTime) {
        this.blSetTime = blSetTime;
    }

    public void setSelectionBlocked(boolean isSelectionBlocked) {
        this.isSelectionBlocked = isSelectionBlocked;
    }

    public void setToneChargeClass(ChargeClassBean toneChargeClass) {
        this.toneChargeClass = toneChargeClass;
    }

    public void setBlackListClass(BlackListInfoBean blackListClass) {
        this.blackListClass = blackListClass;
    }

    public void setCredits(List<String> credits) {
        this.credits = credits;
    }

    public void setRenewalDate(String renewalDate) {
        this.renewalDate = renewalDate;
    }

    public void setClassOfService(String classOfService) {
        this.classOfService = classOfService;
    }

    public void setSrvKey(String srvKey) {
        this.srvKey = srvKey;
    }

    public void setThirdPartyConsent(ThirdPartyConsentBean thirdPartyConsent) {
        this.thirdPartyConsent = thirdPartyConsent;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public void setOperatorUserType(String operatorUserType) {
        this.operatorUserType = operatorUserType;
    }

    public void setExtraInfoClass(ExtraInfoBean extraInfoClass) {
        this.extraInfoClass = extraInfoClass;
    }

    public void setBillingInfo(String billingInfo) {
        this.billingInfo = billingInfo;
    }

    public void setLegacyDctRequired(boolean legacyDctRequired) {
        this.legacyDctRequired = legacyDctRequired;
    }

    public void setCatalogSubscriptionId(int catalogSubscriptionId) {
        this.catalogSubscriptionId = catalogSubscriptionId;
    }

    public void setAutomaticRenewal(boolean automaticRenewal) {
        this.automaticRenewal = automaticRenewal;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    
}
