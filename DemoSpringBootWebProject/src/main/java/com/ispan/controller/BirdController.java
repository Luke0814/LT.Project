package com.ispan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.model.Bird;
import  com.ispan.model.BirdService;

@RestController
public class BirdController {
	
	@Autowired
	private BirdService birdService;
	
	@PostMapping("/birdinsert.controller")
	public Bird processInsertAction() {
		Bird bird1 = new Bird("Parrot","S","GreenYellow",1);
		return birdService.insert(bird1);
	}
	
	@PostMapping("/birdinsert2.controller")
	public Bird processInsertAction2(@RequestBody Bird bird2) {
		return birdService.insert(bird2);
	}
	
	@GetMapping("/birddelete.controller")
	public String processDeleteAction() {
		birdService.deleteById(104);
		return "Delete OK";
	}
	
	@GetMapping("/birdquerybyid.controller")
	public Bird processQueryByIdAction() {
		return birdService.getById(100);		
	}
	
	@GetMapping("/birdupdate.controller")
	public Bird processUpdateAction() {
		Bird updateBean = new Bird(104, "MockingJay", "L", "Aqua", 12);		
		return birdService.update(updateBean);
	}

}
