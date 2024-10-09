package com.airplane;

public class Service {

	private final int ServiceId;
	
	private String contact;
	
	private String Name;
	
	private String email;
	
	private String address;
	
	private int CusId;
	
	private String manuf;
	
	private String date;

	public Service(int serviceId, String contact, String name, String email, String address, int cusId, String manuf,
			String date) {
		super();
		ServiceId = serviceId;
		this.contact = contact;
		Name = name;
		this.email = email;
		this.address = address;
		CusId = cusId;
		this.manuf = manuf;
		this.date = date;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCusId() {
		return CusId;
	}

	public void setCusId(int cusId) {
		CusId = cusId;
	}

	public String getManuf() {
		return manuf;
	}

	public void setManuf(String manuf) {
		this.manuf = manuf;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getServiceId() {
		return ServiceId;
	}
	
	
}
