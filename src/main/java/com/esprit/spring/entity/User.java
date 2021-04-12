package com.esprit.spring.entity;

import java.io.Serializable;
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

import com.esprit.spring.enumeration.UserFunction;



@Entity
@Table(name = "t_user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
   
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String email;
	private int passWord;
	@Enumerated(EnumType.STRING)
	private UserFunction userFonction;
	
	@OneToMany(cascade = CascadeType.ALL)//, mappedBy="user"
	private List<Appointment> appointments;
	
	public User(){
		
	}

	public User(int userId, String firstName, String lastName, int phoneNumber, String email, int passWord,
			UserFunction userFonction, List<Appointment> appointments) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.passWord = passWord;
		this.userFonction = userFonction;
		this.appointments = appointments;
	}
	
	
	//getters and setters--------------------------------------------------------------

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassWord() {
		return passWord;
	}

	public void setPassWord(int passWord) {
		this.passWord = passWord;
	}

	public UserFunction getUserFonction() {
		return userFonction;
	}

	public void setUserFonction(UserFunction userFonction) {
		this.userFonction = userFonction;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
}
