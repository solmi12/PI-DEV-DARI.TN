package dari.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import dari.entity.SurveillanceNotice;
import dari.service.ISurveillanceNoticeService;

@Controller
public class SurveillanceNoticeController {
	
	@Autowired
	ISurveillanceNoticeService surveillanceNoticeService;
	
	//ajouter une surveillance et l'affecter à une surveillance
	@PostMapping("/addSurveillanceNoticeAndaffecterSurveillanceToSurveillanceNotice/{surveillanceId}") 
	@ResponseBody
	public int addSurveillanceNoticeAndaffecterSurveillanceToSurveillanceNotice(@RequestBody SurveillanceNotice sn,
				@PathVariable("surveillanceId") long surveillanceId) {
	// TODO Auto-generated method stub
	surveillanceNoticeService.addSurveillanceNoticeAndaffecterSurveillanceToSurveillanceNotice(sn, surveillanceId);
	return 10;
			}
	
	//supprimer surveillance
	@DeleteMapping("/RemoveSurveillanceNotoce/{NoticeId}") 
	@ResponseBody
	public int removeSurveillanceOfficer(@PathVariable("NoticeId") Long NoticeId) { 
	surveillanceNoticeService.deleteSurveillanceNotice(NoticeId);
	return 1;
		}
	
	//trouver les surveillances d'un agent
	@GetMapping("/retrieveAllSurveillanceNoticeBySurveillance/{surveillanceId}")
	@ResponseBody
	public List<SurveillanceNotice> retrieveSurveillanceNoticeBySurveillance(@PathVariable("surveillanceId") long id) {
	return surveillanceNoticeService.retrieveSurveillanceNoticeBySurveillance(id);
		}

}
