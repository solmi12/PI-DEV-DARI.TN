package dari.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import dari.entity.CategorySurveillance;
import dari.entity.Surveillance;
import dari.service.ISurveillanceService;

@RestController
public class SurveillanceController {
	
	
	@Autowired
	ISurveillanceService surveillanceService;
	
	//ajouter surveillance
	@PostMapping("/AddSurveillance")
	@ResponseBody
	public Surveillance addSurveillance(@RequestBody Surveillance s) {
		s.setDateAdd(new Date());
	Surveillance surveillance = surveillanceService.addSurveillance(s); 
	return surveillance;
	}
	
	//supprimer surveillance
	@DeleteMapping("/RemoveSurveillance/{SurveillancId}") 
	@ResponseBody
	public int removeSurveillanceOfficer(@PathVariable("SurveillancId") Long SurveillanceId) { 
	surveillanceService.deleteSurveillance(SurveillanceId);
	return 1;
	}
	
	//modifier surveillance
	@PutMapping("/modifySurveillance") 
	@ResponseBody
	public Surveillance modifySurveillanceOfficer( @RequestBody Surveillance s) { 
	surveillanceService.updateSurveillance(s);
	return s;
	}
	
	//affecter un agent à une surveillance
	@PostMapping("/affecterOfficerToSurveillance/{OfficerId}/{SurveillanceId}") 
	@ResponseBody
	public int affecterSurveillanceOfficerToSurveillance(@PathVariable("OfficerId") long OfficerId, @PathVariable("SurveillanceId") long SurveillanceId){ 
	surveillanceService.affecterSurveillanceOfficerToSurveillance(OfficerId, SurveillanceId);
	return 10;
	}
	
	//ajouter une surveillance et l'affecter à un agent
	@PostMapping("/addSurveillanceAndaffecterSurveillanceOfficerToSurveillance/{OfficerId}") 
	@ResponseBody
	public int addSurveillanceAndaffecterSurveillanceOfficerToSurveillance(@RequestBody Surveillance s,
			@PathVariable("OfficerId") long surveillanceOfficerId) {
		// TODO Auto-generated method stub
		s.setDateAdd(new Date());
		surveillanceService.addSurveillanceAndaffecterSurveillanceOfficerToSurveillance(s, surveillanceOfficerId);
		return 10;
		}
	
	//retourne la liste de tout les surveillances
		@GetMapping("/retrieveAllSurveillance")
		@ResponseBody
		public List<Surveillance> retrieveAllSurveillance() {
		return surveillanceService.retrieveAllSurveillance();
		}
	
	//trouver une surveillance par ID
	@GetMapping("/retrieveSurveillancer/{SurveillanceId}")
	@ResponseBody
	public Surveillance retrieveSurveillancer(@PathVariable("SurveillanceId") long id) {
	return surveillanceService.retrieveSurveillance(id);
	}
	
	//trouver les surveillances d'un agent
	@GetMapping("/retrieveAllSurveillanceByOfficer/{officerId}")
	@ResponseBody
	public List<Surveillance> retrieveAllSurveillanceByOfficer(@PathVariable("officerId") int id) {
	return surveillanceService.retrieveAllSurveillanceByOfficer(id);
	}
	
	//recherche entre deux prixs
	@GetMapping("/searchSurveillanceByPrice/{1}/{2}")
	@ResponseBody
	public List<Surveillance> searchSurveillanceByPrice(@PathVariable("1") double Price1 , @PathVariable("2") double Price2) {
	return surveillanceService.searchSurveillanceByPrice(Price1, Price2);
		}
	
	//recherche par cetegory
	@GetMapping("/searchSurveillanceByCategory/{category}")
	@ResponseBody
	public List<Surveillance> searchSurveillanceByCategory(@PathVariable("category") CategorySurveillance category ) {
	return surveillanceService.searchSurveillanceByCategory(category);
			}
	
	//recherche par fournisseur
	@GetMapping("/searchSurveillanceByProvider/{name}")
	@ResponseBody
	public List<Surveillance> searchSurveillanceByProvider(@PathVariable("name") String name ) {
	return surveillanceService.searchSurveillanceByProvider(name);
		}
	
	//afficher par prix asc
	@GetMapping("/displaySurveillanceByPriceAsc")
	@ResponseBody
	public List<Surveillance> displaySurveillanceByPriceAsc() {
	return surveillanceService.displaySurveillanceByPriceAsc();
			}
	
	//afficher par prix desc
	@GetMapping("/displaySurveillanceByPriceDesc")
	@ResponseBody
	public List<Surveillance> displaySurveillanceByPriceDesc() {
	return surveillanceService.displaySurveillanceByPriceDesc();
			}
		
	//afficher par date
	@GetMapping("/displaySurveillanceByDate")
	@ResponseBody
	public List<Surveillance> displaySurveillanceByDate() {
	return surveillanceService.displaySurveillanceByDate();
			}
	
	//trouver les surveillances par like
	@GetMapping("/displaySurveillanceByLike")
	@ResponseBody
	public List<Surveillance> displaySurveillanceByLike() {
	return surveillanceService.displaySurveillanceByLike();
				}
	
	//add like
	@PutMapping("/addlikeSurveillance/{SurveillancId}") 
	@ResponseBody
	public Surveillance addlikeSurveillance(@PathVariable("SurveillancId") long SurveillanceId) { 
	return surveillanceService.addLike(SurveillanceId);
		}
	//add deslike
	@PutMapping("/addDeslikeSurveillance/{SurveillancId}") 
	@ResponseBody
	public Surveillance addDeslikeSurveillance(@PathVariable("SurveillancId") long SurveillanceId) { 
	return surveillanceService.addDeslike(SurveillanceId);
			}

	
	

}
