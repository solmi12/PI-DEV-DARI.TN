package com.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entity.Appointment;
import com.esprit.spring.entity.Property;
import com.esprit.spring.entity.User;
import com.esprit.spring.repository.IAppointmentRepository;
@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentRepository appointmentRepository;
	
	//Basic CRUD Functions Implementations---------------------------------------------------------------------------
	@Override
	public int addAppointment(Appointment app) {
		// TODO Auto-generated method stub
		appointmentRepository.save(app);
		return 0;
	}

	@Override
	public void removeAppointment(int id) {
		// TODO Auto-generated method stub
		appointmentRepository.deleteById(id);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		List<Appointment> appointments =new ArrayList<>();      
		appointmentRepository.findAll().forEach(appointments ::add);                      //lambda expression
		return appointments;
	}


	@Override
	public int updateAppointments(Appointment app , int id) {    //the update require the id
		// TODO Auto-generated method stub
		appointmentRepository.save(app);
		return 0;
	}

	@Override
	public Optional<Appointment> getAppointment(int id) {
		// TODO Auto-generated method stub      
		return appointmentRepository.findById(id) ;
	}
	

	//JPQL Functions Implementation-----------------------------------------------------------------------
	@Override
	public List<Appointment> getAppointmentByPropertyId(int propid) {
		// TODO Auto-generated method stub
		return appointmentRepository.getAllAppointmentByProperty(propid);
	}

	@Override
	public List<Appointment> getAppointmentByUserId(int userid) {
		// TODO Auto-generated method stub
		return appointmentRepository.getAppointmentByUser(userid);
	}
	


}
