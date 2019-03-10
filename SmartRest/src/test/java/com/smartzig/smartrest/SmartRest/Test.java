package com.smartzig.smartrest.SmartRest;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.smartzig.smartrest.firstmodule.FirstRequest;
import com.smartzig.smartrest.firstmodule.FirstResponse;

public class Test {

	
	private static final Logger log = LogManager.getLogger(Test.class);
	
	public static void main(String[] args) {
		try {
			
			
			Long date = Calendar.getInstance().getTimeInMillis();
			String requestID = "182"+date;
			String institutionCode = "SMART";
			String userID ="1";
			
			 	final String uri = "http://localhost:8080/first/get";
		     
			 	
			    FirstRequest request = new FirstRequest(date, requestID, institutionCode, userID);
			  
			     
			    RestTemplate restTemplate = new RestTemplate();
			    FirstResponse response = restTemplate.postForObject( uri, request, FirstResponse.class);
			   
			    log.info("[TestClient]  ID Request: ["
						+ requestID + "] - Financial Institution Code: ["
						+ institutionCode + "] -Response: " + response);
			    
			}catch (Exception e)
			{
				 log.error("[TestClient]",e);	;
			}

	}

}
