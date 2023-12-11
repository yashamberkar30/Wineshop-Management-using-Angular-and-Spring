package com.wineshop.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Customer_Table")
@SequenceGenerator(name = "generator1", sequenceName = "gen1", initialValue = 1000)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
	@Column(name = "Customer_Id")
	private long customerId;

	@Column(name = "First_Name", length = 15)
	@NotEmpty
	@Size(min = 3, message = "firstName must contain atleast 3 characters")
	private String firstName;

	@Column(name = "Last_Name", length = 15)
	@NotEmpty
	@Size(min = 3, message = "lastName must contain atleast 3 characters")
	private String lastName;

	@Column(name = "BOD")
	private Date dateOfBirth;

	@Column(name = "Phone_Number")
	@NotEmpty
	@Size(min = 10, max = 10, message = "phoneNumber must contain  10 digits")
	private String phoneNumber;

	@Column(name = "City", length = 20)
	@NotEmpty
	@Size(min = 3, message = "City must contain atleast 3 characters")
	private String city;

	@Column(name = "State", length = 15)
	@NotEmpty
	@Size(min = 3, message = "state must contain atleast 3 characters")
	private String state;

	@Column(name = "zip_code")
	@NotEmpty
	@Size(min = 6, max = 6, message = "zipCode must contain 6 digits")
	private String zipCode;

	@Column(name = "Email_Id", unique = true, length = 25)
	@NotEmpty
	@Email(message = "Email  is not valid!")
	public String emailID;

	@Column(name = "Gender", length = 10)
	@NotEmpty
	@Size(min = 4, message = "gender must contain atleast 4 characters")
	public String gender;

	@Column(name = "Password", length = 15)
	@NotEmpty
	@Size(min = 5, message = "Password length must be 10 and contain uppercase,lowercase,digits")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String password;

	@Column(name = "Address")
	@NotEmpty
	public String address;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", emailID=" + emailID + ", gender=" + gender + ", password="
				+ password + ", address=" + address + "]";
	}

	
}