package com.sapana.model;

public class Student {
	private Integer id;
	private String name;
	private String address;
	private String email;
	private Integer contact;
		
	public Student() {
		super();
	}
	

	public Student(Integer id) {
		super();
		this.id = id;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getContact() {
		return contact;
	}
	public void setContact(Integer contact) {
		this.contact = contact;
	}
	

}
