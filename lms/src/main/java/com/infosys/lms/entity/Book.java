package com.infosys.lms.entity;

import com.infosys.lms.util.Availability;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Book {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String authorName;
	
	private int yop;
	
	private double price;
	
	private Availability availability;
	
	private String category;
	
	
	

	public Book() {
		super();
	}

	public Book(int id, String name, String authorName, int yop, double price, Availability availability,
			String category) {
		super();
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.yop = yop;
		this.price = price;
		this.availability = availability;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", authorName=" + authorName + ", yop=" + yop + ", price=" + price
				+ ", availability=" + availability + ", category=" + category + "]";
	}
	
	
	
	
	
	
	

}
