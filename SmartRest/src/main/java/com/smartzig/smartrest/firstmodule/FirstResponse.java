package com.smartzig.smartrest.firstmodule;

import java.util.List;

import com.smartzig.smartrest.BaseResponse;

public class FirstResponse extends BaseResponse{
	

    private static final long serialVersionUID = -5143894805261523212L;
   
    private final List<String> exampleList;
    
    public FirstResponse() {
    	super();
        this.exampleList = null;
	}

    public FirstResponse(String responseID, String returnCode,
            String errorDescription)
        {
            super(responseID, returnCode, errorDescription);
            this.exampleList = null;
        }
    
    public FirstResponse(String responseID, String returnCode,
            String errorDescription, List<String> exampleList)
        {
            super(responseID, returnCode, errorDescription);
            this.exampleList = exampleList;
        }

	public List<String> getExampleList() {
		return exampleList;
	}

	

	

}
