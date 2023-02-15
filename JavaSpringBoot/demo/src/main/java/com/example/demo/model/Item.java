package com.example.demo.model;

public class Item {

	// MEMBER VARIABLES
	protected String name;
	protected double price;
	public String testString;

	// CONSTRUCTOR
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * GETTERS
	 * @return members name and  price
	 */
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	/**
	 * SETTERS
	 * @param members name and price
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
