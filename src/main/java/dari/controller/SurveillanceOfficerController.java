package dari.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	public SurveillanceOfficer addSurveillanceOffice() {
	SurveillanceOfficer surveillanceOfficer = surveillanceOfficerService.addSurveillanceOfficer(); 
	return surveillanceOfficer;
	}	

}
