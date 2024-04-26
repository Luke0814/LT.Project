package com.ispan.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.model.DataBaseProperties;

@RestController
public class DataBasePropertiesController {
	
	@Autowired
	private DataBaseProperties dbProp;
	
	@GetMapping("/dbproperties.controller")
	public DataBaseProperties processAction() {
		return dbProp;
	}

}
