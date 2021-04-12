package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.spring.entity.Appointment;

public interface IAppointmentRepository extends CrudRepository <Appointment , Integer> {
	
	
	
	// Retrieve the list of appointments by a single property: 
	@Query("Select DISTINCT app from Appointment app join app.property prop where prop.propId=:propid")
    public List<Appointment> getAllAppointmentByProperty(@Param("propid") int propid);
	
	
	
	// Retrieve the list of appointments by a single user:
	@Query("Select distinct app from Appointment app Join app.user use where use.userId=:userid")
    public List<Appointment> getAppointmentByUser(@Param("userid")int userid);

}
