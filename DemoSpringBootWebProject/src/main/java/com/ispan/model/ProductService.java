package com.ispan.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository pRepos;
	
	public Product findById(Integer id) {
		Optional<Product> op1 = pRepos.findById(id);
		
		if(op1.isPresent()) {
			return op1.get();
		}
		
		return null;
	}
	
	public List<Product> findAll(){
		return pRepos.findAll();
	}
	
	public Page<Product> findAllByPage(Pageable pageable){
		return pRepos.findAll(pageable);
	}

}
