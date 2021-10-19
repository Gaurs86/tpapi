package com.comviva.tpapi.staticResources;


public enum SubsStatus {
	    ACTIVE(1,"active")  , 
	    GRACE(2,"grace") ,
	    SUSPEND(3,"suspended"),
	    HOLD(4,"delayedactivation"),
	    ACT_PENDING(5,"activationpending"),
	    DEACT_PENDING(6,"deactivationpending"),
	    CANCELED(7,"canceled"),
	    REJECTED(8,"activation_error"),
	    DEACTIVE(9,"deactive"),
	    NEW(0,"new_user"),
		TONE_DEL_PEN(99,"tonedeletepending");
	    
	    private int statusVal;
	    private String subStatus;
	    
	    
	    SubsStatus(int statusVal ,String subStatus){
	        this.statusVal = statusVal;
	        this.subStatus = subStatus;
	    }
	    
	    public int getStatusVal(){
	        return statusVal;
	    }
	    
	    public String getStatus(){
	        return subStatus;
	    }
	    
	    /**
	     * 
	     * @param value
	     * @return
	     */
	    public static SubsStatus enumValueOf(String value){
	        SubsStatus enumVal;
	        switch(value){
	            case "1" :
	                enumVal = ACTIVE;
	                break;
	            case "2" :
	                enumVal = GRACE;
	                break;
	            case "3" : 
	                enumVal = SUSPEND;
	                break;
	            case "4" :
	                enumVal = HOLD;
	                break;
	            case "5" :
	                enumVal = ACT_PENDING;
	                break;
	            case "6" : 
	                enumVal = DEACT_PENDING;
	                break;
	            case "7" :
	                enumVal = CANCELED;
	                break;
	            case "8" : 
	                enumVal = REJECTED;
	                break;
	            case "9" : 
	                enumVal = DEACTIVE;
	                break;
	            case "99" : 
	                enumVal = TONE_DEL_PEN;
	                break;
	            default :
	                enumVal = REJECTED;
	        }
	        
	        return enumVal;
	    }

}
