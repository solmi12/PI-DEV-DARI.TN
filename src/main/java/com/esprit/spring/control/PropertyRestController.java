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
import com.esprit.spring.entity.Property;
import com.esprit.spring.service.IPropertyService;

@RestController
public class PropertyRestController {
	
	@Autowired
	private IPropertyService propertyService;
	
		// http://localhost:8087/SpringMVC/servlet/add-prop
		@PostMapping("/add-prop")
		@ResponseBody
		public Property addproperty(@RequestBody Property property){
			propertyService.addProperty(property);
			return property;
		}
		
		// http://localhost:8087/SpringMVC/servlet/display-all-prop
		@GetMapping("/display-all-prop")
		@ResponseBody
		public List<Property> showProperties(){
			return propertyService.getAllProperties();
		}
		
		// http://localhost:8087/SpringMVC/servlet/del-prop-by-id
	    @DeleteMapping("/del-prop-by-id/{id-prop}")
		@ResponseBody
		public void deletePropertyById(@PathVariable("id-prop")int id) {
	    	propertyService.removeProperty(id);
		}
	    // http://localhost:8087/retrieve-prop-by-id/{prop-id}
		@GetMapping("/retrieve-prop-by-id/{prop-id}")
		@ResponseBody
		public Optional<Property> retrieveProperty(@PathVariable("prop-id") int id){
		return propertyService.getProperty(id);
		} 
		// http://localhost:8087/SpringMVC/servlet/update-prop
		@PutMapping("/update-prop")
		@ResponseBody
		public void updateAppointment(){
			Property property=new Property();
			propertyService.updateProperties(property , property.getPropId());
			}

}
