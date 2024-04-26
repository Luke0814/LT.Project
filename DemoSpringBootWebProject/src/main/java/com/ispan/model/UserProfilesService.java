package com.ispan.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.exeption.UserNotFoundException;

@Service
@Transactional
public class UserProfilesService {
	
	@Autowired
	private UserProfilesRepository uRepos;
	
	public UserProfiles findByName(String name) {
		Optional<UserProfiles> op1 = uRepos.findByName(name);
		
		if(op1.isEmpty()) {
			throw new UserNotFoundException("Can't find User");
		}
		
		return op1.get();
	}
	
	public UserProfiles createUserProfiles(UserProfiles up1) {
		return uRepos.save(up1);
	}

}

	

