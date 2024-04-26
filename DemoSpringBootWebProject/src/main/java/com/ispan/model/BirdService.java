package com.ispan.model;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BirdService {
@Autowired
public BirdRepository birdRepos;

public Bird insert (Bird bird) {
	return birdRepos.save(bird);	
	
}

public Bird update(Bird bird) {
	return birdRepos.save(bird);
	
	
}
	
public void deleteById(Integer id) {
	birdRepos.deleteById(id);
	
}

public Bird getById(Integer id) {
	Optional<Bird> op1 = birdRepos.findById(id);
	if(op1.isPresent()) {
		return op1.get();
		
		
	}
	return null;
	
}
public List<Bird> getAll() {
	return birdRepos.findAll();
	
}
}
