package com.esprit.spring.service;

import java.util.List;
import java.util.Optional;



import com.esprit.spring.entity.Appointment;

public interface IAppointmentService {
	//Basic CRUD Functions---------------------------------------------------------------------------
	public int addAppointment(Appointment app);
	public void removeAppointment(int id);
	public List<Appointment> getAllAppointments();
	public int updateAppointments(Appointment app, int id);
	public Optional<Appointment> getAppointment(int id);
	
	//JPQL functions---------------------------------------------------------------------------------
	public List<Appointment> getAppointmentByPropertyId(int propid);
	public List<Appointment> getAppointmentByUserId(int userid);

}
