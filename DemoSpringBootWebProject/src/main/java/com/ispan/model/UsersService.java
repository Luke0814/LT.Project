package com.ispan.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepos;
	
	public List<Users> findUsers(String name){
		return usersRepos.findUsers(name);
	}
	
	public List<Users> findByNameLike(String name){
		return usersRepos.findByNameLike(name);
	}
	
	public List<Users> findAll(){
		return usersRepos.findAll();
	}

}
