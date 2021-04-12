package com.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "t_appointment")
public class Appointment implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private	Date date;
	
	private int isAccepted;
	
	@ManyToOne
	private Property property;
	
	@ManyToOne
	User user;

	
	public Appointment() {
		
	}


	public Appointment(int id, Date date, int isAccepted ,Property property, User user) {
		super();
		this.id = id;
		this.date = date;
		this.isAccepted = isAccepted;
		this.property = property;
		this.user =user;
	}
	

	//getters and setters--------------------------------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getIsAccepted() {
		return isAccepted;
	}


	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}


	public Property getProperty() {
		return property;
	}


	public void setProperty(Property property) {
		this.property = property;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	
	
	
	
	
}
