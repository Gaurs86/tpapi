package com.comviva.tpapi.resources;

import java.util.List;

import org.glassfish.jersey.server.ResourceConfig;

import com.comviva.tpapi.beans.SubProfileRequestBean;

import com.comviva.tpapi.beans.SubProfileResponseBean;
import com.comviva.tpapi.service.buisness.*;
import com.comviva.tpapi.service.gw.ServiceHandlingInterface;
import com.comviva.tpapi.staticResources.AppQueryProvider;
import com.comviva.tpapi.resources.ProfileResource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/subcription")
public class ProfileResource extends ResourceConfig {
	
	private ServiceHandlingInterface serviceInterface;
	
	public ProfileResource() {
		packages(ProfileResource.class.getPackage().getName());
	}
	
	@GET
	@Path("/voltron")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<SubProfileResponseBean> getUserSubscriptionProfile(@QueryParam("subscriberId") String msisdn,@QueryParam("mode") String mode,
            @QueryParam("storeId") String storeId , @QueryParam("responseType") String responseType) {
		
		AppQueryProvider.loadQueryFileIntoApp();
		
		SubProfileRequestBean reqBean = new SubProfileRequestBean();
		reqBean.setMode(mode);
		reqBean.setSubscriberId(msisdn);
		reqBean.setStoreId(storeId);
		System.out.println(msisdn + " "+mode+" "+storeId);
		serviceInterface = new SubscriptionProfileService();
        List<SubProfileResponseBean> profileResponseList = (List<SubProfileResponseBean>) serviceInterface.processRequest(reqBean);
		return profileResponseList;
	}

}
