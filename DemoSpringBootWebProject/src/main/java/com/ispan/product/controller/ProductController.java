package com.ispan.product.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ispan.model.Product;
import com.ispan.model.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/product")
//@SessionAttributes(names = {"totalPages", "totalElements"})
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@GetMapping("/productqueryallpage.controller")
	public String processQueryAllPageAction() {
		return "product/productQueryAll";
	}
	
	@GetMapping("/productquerybyid/{pid}")
	@ResponseBody
	public Product processQueryById(@PathVariable("pid") int pid) {
		return pService.findById(pid);
	}
	
	@GetMapping("/productqueryall")
	@ResponseBody
	public List<Product> processQueryAll() {
		return pService.findAll();
	}
	
	@GetMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<Product> processQueryAllByPage(@PathVariable("pageNo") int pageNo, Model m, HttpServletRequest request){
		int pageSize = 3;
		Pageable p1 = PageRequest.of(pageNo-1, pageSize);
		Page<Product> page = pService.findAllByPage(p1);
		
		int totalPages = page.getTotalPages();
		long totalElements = page.getTotalElements();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("totalPages", totalPages);
		session.setAttribute("totalElements", totalElements);
		
//		m.addAttribute("totalPages", totalPages);
//		m.addAttribute("totalElements", totalElements);
		
		return page.getContent();
	}
}
