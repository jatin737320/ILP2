package com.airplane;

import java.time.LocalDate;
import java.time.LocalTime;

public class Services {
    private int serviceId;            // Unique identifier for the service
    private String service;
    private int customerId;        // Customer ID (could be String if alphanumeric)
    private String requesterName;     // Name of the person requesting the service
    private String contactNumber;     // Contact number
    private String email;             // Email address
    private String address;           // Address for the service
    private LocalDate date;           // Date of the service request
    private LocalTime time;           // Time of the service request
    private double amount;            // Amount for the service

    // Constructor
    public Services(int serviceId, String service, int customerId, String requesterName, String contactNumber, String email, String address, LocalDate date, LocalTime time) {
        this.serviceId = serviceId;
        this.service = service;
        this.customerId = customerId;
        this.requesterName = requesterName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.date = date;
        this.time = time;
        //this.amount = amount;
    }
    
    public Services(int customerId, String service, String requesterName, String contactNumber, String email, String address, LocalDate date, LocalTime time)
    {
		this.customerId = customerId;
		this.service = service;
		this.requesterName = requesterName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.date = date;
		this.time = time;
		//this.amount = amount;
	}
    
    public String getService()
    {
    	return service;
    }
    
    // Getter and Setter methods
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Optional: Override toString for easy display
    @Override
    public String toString() {
        return "TV_Service{" +
                "serviceId=" + serviceId +
                ", customerId='" + customerId + '\'' +
                ", requesterName='" + requesterName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", amount=" + amount +
                '}';
    }
}
