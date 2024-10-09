package com.airplane;

import java.util.*;

import java.sql.*;

public class Customer2 {
	
	private int id;
	String name, username, email, contact, password, address;
	
	Customer2(int id, String name, String username, String email, String password, String contact, String address)
	{
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.address = address;
	}
	
	Customer2(String name, String username, String email, String password, String contact, String address)
	{
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}
	
	
}
