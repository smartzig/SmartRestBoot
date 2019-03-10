package com.smartzig.smartrest.utils;

public enum ReturnCode 
{
	OK("00", "OK"),
	OK_WARN("01", "OK - But may contains some errors - Check Error description"),
	INVALID_INSTITUTION_CODE("02", "Invalid Institution Code"),
	INVALID_USER_ID("03", "Invalid UserID"),
	INVALID_REQUEST("98", "Invalid Request"),
	SYSTEM_ERROR("99", "System Error");
    
    /** DOCUMENT ME! */
    private final String value;
    
    private final String description;

	/**
     * DOCUMENT ME!
     */
    ReturnCode(String value, String description)
    {
        this.value = value;
        this.description = description;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getValue()
    {
        return value;
    }
    
    public String getDescription() {
		return description;
	}

    /**
     * DOCUMENT ME!
     */
    public static ReturnCode get(String value)
    {    	
        switch (value)
        {        
            case "00":
                return OK;
                
            case "01":
            	return OK_WARN;
               
            case "02":
                return INVALID_INSTITUTION_CODE;
                
            case "03":
                return INVALID_USER_ID;
                
            case "98":
                return INVALID_REQUEST;
                
            case "99":
                return SYSTEM_ERROR;                          

            default:
                return OK;
        }
    }
}
