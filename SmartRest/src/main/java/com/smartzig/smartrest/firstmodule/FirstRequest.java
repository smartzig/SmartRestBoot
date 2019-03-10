package com.smartzig.smartrest.firstmodule;

import com.smartzig.smartrest.BaseRequest;

public class FirstRequest extends BaseRequest{
	

    private static final long serialVersionUID = -5143894805261523212L;

    private  String institutionCode;
    private  String userID;


    public FirstRequest() 
	{
		super();
		 
	}
    public FirstRequest(long date, String requestID, String institutionCode, String userID) 
	{
		super(date, requestID);
		this.institutionCode = institutionCode;
		this.userID = userID;
	
		 
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public String getUserID() {
		return userID;
	}

}