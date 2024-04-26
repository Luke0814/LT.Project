package com.ispan.model;



import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name = "bird")
@Component
public class Bird {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String bname;
	private String size;
	private String color;
	private int age;	
	
	public Bird() {
	}


	public Bird(int bid, String bname, String size, String color, int age) {
		this.bid = bid;
		this.bname = bname;
		this.size = size;
		this.color = color;
		this.age = age;
	}
	

	public Bird(String bname, String size, String color, int age) {
		this.bname = bname;
		this.size = size;
		this.color = color;
		this.age = age;
	}


	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
