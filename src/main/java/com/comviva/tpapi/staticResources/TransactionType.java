/*
 * COPYRIGHT: Comviva Technologies Pvt. Ltd.
 *
 * This software is the sole property of Comviva and is protected
 * by copyright law and international treaty provisions. Unauthorized
 * reproduction or redistribution of this program, or any portion of
 * it may result in severe civil and criminal penalties and will be
 * prosecuted to the maximum extent possible under the law.
 * Comviva reserves all rights not expressly granted. You may not
 * reverse engineer, decompile, or disassemble the software, except
 * and only to the extent that such activity is expressly permitted
 * by applicable law notwithstanding this limitation.

 * THIS SOFTWARE IS PROVIDED TO YOU "AS IS" WITHOUT WARRANTY OF ANY
 * KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE. YOU ASSUME THE ENTIRE RISK AS TO THE ACCURACY
 * AND THE USE OF THIS SOFTWARE. Comviva SHALL NOT BE LIABLE FOR
 * ANY DAMAGES WHATSOEVER ARISING OUT OF THE USE OF OR INABILITY TO
 * USE THIS SOFTWARE, EVEN IF Comviva HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.comviva.tpapi.staticResources;

/**
 * @author suraj.gupta
 *
 */
public enum TransactionType {
    
    SUB_ONLY(3,"activationpending"),
    TONE_DEL(4,"tonedeletepending"),
    SUB_WITH_TONE(6,"activationpending"),
    DEL_SUB(10,"deactivationpending"),
    OTHER(0,"new_user");
    
    private int transactionType;
    private String transactionStatus;
    
    TransactionType(int transType , String transactionStatus){
        this.transactionType = transType;
        this.transactionStatus = transactionStatus;
    }
    
    public String getTransStatus(){
        return transactionStatus;
    }
    /**
     * 
     * @param value
     * @return
     */
    public static TransactionType enumValueOf(String value){
        TransactionType enumVal;
        switch(value){
            case "3" :
                enumVal = SUB_ONLY;
                break;
            case "4" :
                enumVal = TONE_DEL;
                break;
            case "6" :
                enumVal = SUB_WITH_TONE;
                break;
            case "10" : 
                enumVal = DEL_SUB;
                break;
            default :
                enumVal = OTHER;
        }
        
        return enumVal;
    }
}
