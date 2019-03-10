package com.smartzig.smartrest;

import java.io.Serializable;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class BaseRequest implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5062546357203675048L;
	private final String requestID;
	private final long date;
	private final static Gson gson = new Gson();
	public BaseRequest()
	{
		this.requestID = null;
		this.date = 0L;
	}

	public BaseRequest(long date, String idRequest)
	{
		this.date = date;
		this.requestID = idRequest;
	}

	public long getDate()
	{
		return this.date;
	}

	public String getRequestID()
	{
		return this.requestID;
	}

	public JsonObject toJsonObject()
	{
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
