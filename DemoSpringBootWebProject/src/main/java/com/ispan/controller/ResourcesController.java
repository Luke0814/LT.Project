package com.ispan.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {
	
	@Value("classpath:static/images/images01.jpg")
	private Resource resource;
	
	@GetMapping(path = "/resources.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processResourcesAction() throws IOException {
		File file = resource.getFile();
		System.out.println(file.getName() + " " + file.getPath() + " " + file.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping(path = "/resourceloader.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processResourceLoaderAction() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:static/images/images01.jpg");
		
		File file = resource.getFile();
		System.out.println(file.getName() + " " + file.getPath() + " " + file.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}
	
	
	@GetMapping(path = "/resourcespath.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processClassPathResourcesAction() throws IOException {
		
		Resource resource = new ClassPathResource("/static/images/images01.jpg");
		
		File file = resource.getFile();
		System.out.println(file.getName() + " " + file.getPath() + " " + file.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
		
	}

}