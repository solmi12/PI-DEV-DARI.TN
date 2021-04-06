package dari.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import dari.entity.SurveillanceOfficer;
import dari.service.ISurveillanceOfficerService;

@RestController
public class SurveillanceOfficerController {
	
	@Autowired
	ISurveillanceOfficerService surveillanceOfficerService;
	
	@PostMapping("/AddSurveillanceOfficer")
	@ResponseBody
	public SurveillanceOfficer addSurveillanceOffice(@RequestBody SurveillanceOfficer s) {
	SurveillanceOfficer surveillanceOfficer = surveillanceOfficerService.addSurveillanceOfficer(s); 
	return surveillanceOfficer;
	}
	
	
	@DeleteMapping("/RemoveSurveillanceOfficer/{OfficerId}") 
	@ResponseBody
	public int removeSurveillanceOfficer(@PathVariable("OfficerId") Long SurveillanceOfficerId) { 
	surveillanceOfficerService.deleteSurveillanceOfficer(SurveillanceOfficerId);
	return 1;
	}
	
	@DeleteMapping("/deleteSurveillanceOfficerAndtheirServeillance/{OfficerId}") 
	@ResponseBody
	public int deleteSurveillanceOfficerAndtheirServeillance(@PathVariable("OfficerId") Long SurveillanceOfficerId) { 
	surveillanceOfficerService.deleteSurveillanceOfficer(SurveillanceOfficerId);
	return 1;
	}
	
	
	
	
	
	

}
