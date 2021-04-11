package dari.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import dari.entity.SurveillanceNotice;
import dari.service.ISurveillanceNoticeService;


@Controller
public class SurveillanceNoticeController {
	
	@Autowired
	ISurveillanceNoticeService surveillanceNoticeService;
	
	//ajouter un avis et l'affecter à une surveillance
	@PostMapping("/addNotice/{surveillanceId}/{clientId}") 
	@ResponseBody
	public ResponseEntity<Object> addSurveillanceNotice(@RequestParam(value="description") String description,
				@PathVariable("surveillanceId") Long surveillanceId,@PathVariable("clientId") Long clientId ) {
	// TODO Auto-generated method stub
	try{			
	return new ResponseEntity<Object>(surveillanceNoticeService.addSurveillanceNoticeAndaffecterSurveillanceToSurveillanceNotice(description, surveillanceId, clientId) ,  HttpStatus.OK);
		}
	catch (Exception e){
	return new	ResponseEntity<Object>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
	
	}
	
	//supprimer surveillance
	@DeleteMapping("/RemoveSurveillanceNotoce/{surveillanceId}/{idClient}/{noticeId}") 
	@ResponseBody
	public ResponseEntity<Object> removeSurveillanceOfficer(@PathVariable("surveillanceId") Long surveillanceId , @PathVariable("idClient") Long idClient,
			@PathVariable("noticeId") Long noticeId) { 
		try{			
		return new ResponseEntity<Object>(surveillanceNoticeService.deleteSurveillanceNotice(surveillanceId, idClient, noticeId),  HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<Object>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
	
	//trouver les surveillances d'un agent
	@GetMapping("/retrieveAllSurveillanceNoticeBySurveillance/{surveillanceId}")
	@ResponseBody
	public List<SurveillanceNotice> retrieveSurveillanceNoticeBySurveillance(@PathVariable("surveillanceId") long id) {
	return surveillanceNoticeService.retrieveSurveillanceNoticeBySurveillance(id);
		} 
	

}
