package com.smartzig.smartrest.secondmodule;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartzig.smartrest.IController;

@RestController
@RequestMapping("/second")
public class SecondController implements IController{
	

	@GetMapping
	public ResponseEntity<String> test()
	{
		return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
	}


}
