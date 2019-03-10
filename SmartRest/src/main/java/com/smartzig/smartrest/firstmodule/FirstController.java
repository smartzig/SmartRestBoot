package com.smartzig.smartrest.firstmodule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartzig.smartrest.IController;
import com.smartzig.smartrest.utils.ReturnCode;

@RestController
@RequestMapping("/first")
public class FirstController implements IController  {

	
	private static final Logger log = LogManager.getLogger(FirstController.class);

	
	@Autowired
	private FirstModuleService service;
	
	
	@GetMapping
	public ResponseEntity<String> test()
	{
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}


	@RequestMapping(value = "/get")

	public FirstResponse get(@RequestBody FirstRequest request,HttpServletRequest servletRequest)
	{
		FirstResponse response = null;	

		try
		{
			//----------------------------------------------------------------
			// Get Request Object
			// If Fail return Bad Request
			//----------------------------------------------------------------

			//FirstRequest request =  gson.fromJson(incomingData, FirstRequest.class);
			if(request ==null)
			{
				
				String returnCode = ReturnCode.INVALID_REQUEST.getValue();
				String errorDescription = ReturnCode.INVALID_REQUEST.getDescription();

				response = new FirstResponse("", returnCode, errorDescription, null);
				
				log.error("[FirstController] Error on processing the request- Invalid request - Response: " + response);
				return response ;  
			}


			//----------------------------------------------------------------
			// Validate Request
			// Validate Fields, tokens, headers, everything to make it safe.
			// If can be generic for all This controller Generic make it a method
			//----------------------------------------------------------------
			String idRequest = request.getRequestID();
			String institutionCode = request.getInstitutionCode();
			//String userID = request.getUserID();

			//----------------------------------------------------------------
			// Processing Request 
			//----------------------------------------------------------------

			log.info("[FirstController] Processing get: ID Request: ["
					+ idRequest + "] - Financial Institution Code: ["
					+ institutionCode + "]");

			
			List<String> exampleList = (List<String>) service.findAll();
			

			//log with debug if you need to show data on logs
			log.debug("[FirstController] Processing get: ID Request: ["
					+ idRequest + "] - Financial Institution Code: ["
					+ institutionCode + "] - Itens Found:"+ exampleList.toString());


			String returnCode = ReturnCode.OK.getValue();
			String errorDescription = ReturnCode.OK.getDescription();

			response = new FirstResponse(idRequest, returnCode, errorDescription, exampleList);

			log.debug("[FirstController] Processing get: ID Request: ["
					+ idRequest + "] - Financial Institution Code: ["
					+ institutionCode + "] -Response: " + response);
			return response;

		}
		catch (Exception e)
		{
			
			String returnCode = ReturnCode.SYSTEM_ERROR.getValue();
			String errorDescription = ReturnCode.SYSTEM_ERROR.getDescription();

			response = new FirstResponse("", returnCode, errorDescription, null);
			log.error("[FirstController] Error on processing the request - Response: " + response,e);
			return response ; 
		}

	}
	

}
