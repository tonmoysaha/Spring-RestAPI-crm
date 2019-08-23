package com.spring.springrestcrud.entity;

public class Customer {

	private int id;

	private String fristName;

	private String lastName;

	private String email;

	public Customer() {

	}

	public Customer(int id, String fristName, String lastName, String email) {
		this.id = id;
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
