package com.comviva.tpapi.exceptions;



import com.comviva.tpapi.staticResources.AppConstants;
import com.comviva.tpapi.beans.ErrorResponseBean;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;



@Provider
public class SysExceptionMapper implements ExceptionMapper<SysException>{

    
    @Override
    public Response toResponse(SysException excp) {
        ErrorResponseBean errorBean = new ErrorResponseBean();
        errorBean.setCode(AppConstants.GENERIC_ERROR_CODE);
        errorBean.setSubCode(AppConstants.GENERIC_ERROR_CODE);
        errorBean.setDescription("General System Error");
        
        return Response.status(Status.BAD_REQUEST).entity(errorBean).build();
    }
    
}
