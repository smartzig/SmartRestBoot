package com.smartzig.smartrest;



import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class BaseResponse implements Serializable
{
    
	
	private static final long serialVersionUID = 7947891842909702401L;
	private String responseID;
	private String returnCode;
	private String responseDescription;

	private final static Gson gson = new Gson();

	public BaseResponse()
	{
		this.responseID = null;
		this.returnCode = null;
		this.responseDescription = null;
	}

	public BaseResponse(String idResponse, String returnCode, String responseDescription)
	{
		this.responseID = idResponse;
		this.returnCode = returnCode;
		this.responseDescription = responseDescription;
	
	}


	public String getResponseID() {
		return responseID;
	}
	
	
	public String getReturnCode()
	{
		return this.returnCode;
	}


	public String getResponseDescription()
	{
		return this.responseDescription;
	}

	public JsonObject toJsonObject()
	{
		Gson gson = new Gson();
		String output = gson.toJson(this);
		JsonParser parser = new JsonParser();
		JsonObject result = parser.parse(output).getAsJsonObject();
		return result;		
	}

	@Override
	public String toString() 
	{
		return toJsonString();
	}

	public String toJsonString()
	{
		return gson.toJson(this);
	}


}
