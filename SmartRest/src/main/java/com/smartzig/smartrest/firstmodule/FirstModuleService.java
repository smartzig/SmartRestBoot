package com.smartzig.smartrest.firstmodule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;



// use it to connect to database, uses c3p0 for multiple connections

@Service
public class FirstModuleService {

	public List<String> findAll() {
		List<String> exampleList = new ArrayList<String>();
		
		exampleList.add("item1");
		exampleList.add("item2");
		return exampleList;
	}
	
	

}
