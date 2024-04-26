package com.ispan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.model.Users;
import com.ispan.model.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService uService;
	
	@GetMapping("/finduser1.controller")
	public List<Users> processAction1(){
	   return uService.findUsers("ma");
	}
	
	@GetMapping("/finduser2.controller")
	public List<Users> processAction2(){
	   return uService.findByNameLike("%o%");
	}
	
	@GetMapping("/findalluser.controller")
	public List<Users> processAction3(){
		return uService.findAll();
	}

}
