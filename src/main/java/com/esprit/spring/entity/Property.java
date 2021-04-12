package com.esprit.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esprit.spring.enumeration.TransactionType;





@Entity
@Table(name = "t_property")
public class Property {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int propId;
    private float price;
   
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
	
    private String description;
	
	int streetNumber;
	String streetName;
	String city;
	String state;
	int postcode;
	
	@OneToMany(cascade = CascadeType.ALL)//, mappedBy="property"
	private List<Appointment> appointments;
	
	@OneToMany(cascade = CascadeType.ALL)//, mappedBy="property"
	private List<ImageModel> imageModels;
	
	public Property(){
		
	}

	public Property(int propId, float price, TransactionType transactionType, String description,
			int streetNumber, String streetName, String city, String state, int postcode,
			List<Appointment> appointments) {
		super();
		this.propId = propId;
		this.price = price;
		this.transactionType = transactionType;
		this.description = description;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.appointments = appointments;
	}

	//getters and setters--------------------------------------------------------------
	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	

}
