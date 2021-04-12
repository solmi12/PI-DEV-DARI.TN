package com.esprit.spring.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entity.Appointment;
import com.esprit.spring.entity.User;
import com.esprit.spring.service.IAppointmentService;

@RestController
public class AppointmentRestController {
	@Autowired
	private IAppointmentService appointmentService ;
	
		//add appointment
	    // http://localhost:8087/SpringMVC/servlet/add-app
		@PostMapping("/add-app")
		@ResponseBody
		public Appointment addappointment(@RequestBody Appointment appointment){
			appointmentService.addAppointment(appointment);
			return appointment;
		}
		//display all appointments
		// http://localhost:8087/SpringMVC/servlet/display-all-app
		@GetMapping("/display-all-app")
		@ResponseBody
		public List<Appointment> showAppointments(){
			return appointmentService.getAllAppointments();
		}
		//delete appointment by id
		//http://localhost:8087/SpringMVC/servlet/del-app-by-id
	    @DeleteMapping("/del-app-by-id/{id-app}") 
		@ResponseBody
		public void deleteAppointmentById(@PathVariable("id-app")int id) {
	    	appointmentService.removeAppointment(id);
	    }
	    //show appointment by id
	    // http://localhost:8087/retrieve-app-by-id/{app-id}
		@GetMapping("/retrieve-app-by-id/{app-id}")
		@ResponseBody
		public Optional<Appointment> retrieveAppointment(@PathVariable("app-id") int id){
		return appointmentService.getAppointment(id);
		}
		//Appointment Update By Id 
		// http://localhost:8087/SpringMVC/servlet/update-app
		@PutMapping("/update-app")
		@ResponseBody
		public void updateAppointment(){
			Appointment appointment=new Appointment();
			appointmentService.updateAppointments(appointment , appointment.getId());
		}
		
		//Appointment search by user id JPQL Join
		// http://localhost:8087/retrieve-app-by-user/{user-id}
		@GetMapping("/retrieve-app-by-user/{user-id}")
		@ResponseBody
		public List<Appointment> retrieveAppointmentByUser(@PathVariable("user-id")int userid){
		return appointmentService.getAppointmentByUserId(userid);
		}
		
		//Appointment search by property id JPQL Join
		// http://localhost:8087/retrieve-app-by-prop/{prop-id}
		@GetMapping("/retrieve-app-by-prop/{prop-id}")
		@ResponseBody
		public List<Appointment> retrieveAppointmentByProperty(@PathVariable("prop-id")int propid){
		return appointmentService.getAppointmentByPropertyId(propid);
		}

	

}
