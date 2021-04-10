package dari.controller;



import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import dari.entity.CategorySurveillance;
import dari.entity.Surveillance;
import dari.entity.SurveillanceOfficer;
import dari.repository.SurveillanceOfficerRepository;
import dari.repository.SurveillanceRepository;
import dari.repository.ValeursRepository;
import dari.service.ISurveillanceService;
import javassist.NotFoundException;

@RestController
public class SurveillanceController {
	
	
	@Autowired
	ISurveillanceService surveillanceService;
	
	@Autowired
	SurveillanceRepository surveillance;
	
	@PostMapping("/add") 
	@ResponseBody
	public ResponseEntity<Object> test( ) {
	// TODO Auto-generated method stub
		Surveillance s = new Surveillance();
		surveillance.save(s);
	return new ResponseEntity<Object>(s,  HttpStatus.OK);
	}
	
	//ajouter une surveillance et l'affecter à un agent
	@PostMapping("/addSurveillanceAndAffecterSurveillanceOfficerToSurveillance/{OfficerId}") 
	@ResponseBody
	public ResponseEntity<String> addSurveillanceAndaffecterSurveillanceOfficerToSurveillance(@RequestParam(value="productName") String productName, @RequestParam(value="capteur") String capteur ,
			@RequestParam(value="resolution") int resolution,@RequestParam(value="indiceProtection") int indiceProtection,@RequestParam(value="porteeInfrarouge") int porteeInfrarouge,
			@RequestParam(value="categorySurveillance") CategorySurveillance categorySurveillance,@RequestParam(value="price") double price, @PathVariable("OfficerId") Long surveillanceOfficerId) {
		// TODO Auto-generated method stub
		try{			
		surveillanceService.addSurveillanceAndaffecterSurveillanceOfficerToSurveillance(productName, capteur, resolution, indiceProtection, porteeInfrarouge, categorySurveillance, price, surveillanceOfficerId);
		return new ResponseEntity<>("ad was added successfully :)" ,  HttpStatus.OK);
			}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
			}
	}
	
	//trouver une surveillance par ID
	@GetMapping("/retrieveSurveillancer/{SurveillanceId}")
	@ResponseBody
	public ResponseEntity<Object> retrieveSurveillancer(@PathVariable("SurveillanceId") long id) {
	
	try{
	return new ResponseEntity<Object>(surveillanceService.retrieveSurveillance(id), HttpStatus.OK);
		}
	catch(Exception e){
	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	//supprimer surveillance
	@DeleteMapping("/RemoveSurveillance/{SurveillancId}/{idAgent}") 
	@ResponseBody
	public ResponseEntity<String> removeSurveillanceOfficer(@PathVariable("SurveillancId") Long SurveillanceId ,@PathVariable("SurveillancId") Long idAgent) { 
	try{
		surveillanceService.deleteSurveillance(SurveillanceId,idAgent);
	return new ResponseEntity<String>("the ad was successfully deleted :)",HttpStatus.OK);
	}
	catch(Exception e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);	
	}
	
	}
	
	//trouver les surveillances d'un agent
	@GetMapping("/retrieveAllSurveillanceByOfficer/{officerId}")
	@ResponseBody
	public ResponseEntity<Object> retrieveAllSurveillanceByOfficer(@PathVariable("officerId") Long id) {
	try{
		return new ResponseEntity<Object>(surveillanceService.retrieveAllSurveillanceByOfficer(id),HttpStatus.OK);	
	}
	catch (Exception e){
	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
	}
		}
	
	//modifier surveillance
	@PutMapping("/modifySurveillance/{OfficerId}/{surveillanceId}") 
	@ResponseBody
	public ResponseEntity<Object> updateSurveillance(@RequestParam(value="productName") String productName, @RequestParam(value="capteur") String capteur ,
			@RequestParam(value="resolution") int resolution,@RequestParam(value="indiceProtection") int indiceProtection,@RequestParam(value="porteeInfrarouge") int porteeInfrarouge,
			@RequestParam(value="categorySurveillance") CategorySurveillance categorySurveillance,@RequestParam(value="price") double price, @PathVariable("OfficerId") Long surveillanceOfficerId,
			@PathVariable("surveillanceId") Long surveillanceId) {
		// TODO Auto-generated method stub
		try{			
		
		return new ResponseEntity<Object>(surveillanceService.updateSurveillance(productName, capteur, resolution, indiceProtection, porteeInfrarouge,
				categorySurveillance, price, surveillanceOfficerId, surveillanceId),  HttpStatus.OK);
			}
		catch (Exception e){
		return new	ResponseEntity<Object>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
			}
	}
	
	//retourne la liste de tout les surveillances
	@GetMapping("/retrieveAllSurveillance")
	@ResponseBody
	public ResponseEntity<Object> retrieveAllSurveillance() {
		try{
	return new ResponseEntity<Object>(surveillanceService.retrieveAllSurveillance(), HttpStatus.OK);
		}
	catch(Exception e){
	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/like/{idSurveillance}/{idClient}")
	@ResponseBody
	public ResponseEntity<Object> addRemoveLike(@PathVariable("idSurveillance") Long idSurveillance,@PathVariable("idClient") Long idClient ) {
		try{
	return new ResponseEntity<Object>(surveillanceService.ajouterSupprimerLike(idSurveillance,idClient), HttpStatus.OK);
		}
	catch(Exception e){
	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@PutMapping("/deslike/{idSurveillance}/{idClient}")
	@ResponseBody
	public ResponseEntity<Object> addRemoveDeslike(@PathVariable("idSurveillance") Long idSurveillance,@PathVariable("idClient") Long idClient ) {
		try{
	return new ResponseEntity<Object>(surveillanceService.ajouterSupprimerDeslike(idSurveillance, idClient), HttpStatus.OK);
		}
	catch(Exception e){
	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	//recherche entre deux prixs
	@GetMapping("/searchSurveillanceByPrice")
	@ResponseBody
	public ResponseEntity<Object> searchSurveillanceByPrice(@RequestParam(value="p1") double Price1 ,@RequestParam(value="p2") double Price2) {
	try{
		
	return new ResponseEntity<Object>(surveillanceService.searchSurveillanceByPrice(Price1, Price2), HttpStatus.OK);
		}
	catch(Exception e){
	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
		}
	
	//recherche par cetegory
	@GetMapping("/searchSurveillanceByCategory")
	@ResponseBody
	public ResponseEntity<Object> searchSurveillanceByCategory(@RequestParam(value="category") CategorySurveillance category ) {
	try{
	return new ResponseEntity<Object>(surveillanceService.searchSurveillanceByCategory(category), HttpStatus.OK);
			}
	catch(Exception e){
	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
			}
	}
	
	@Autowired
	SurveillanceOfficerRepository surveillanceOfficerRepository;
	
	//recherche par fournisseur
	@GetMapping("/searchSurveillanceByProvider")
	@ResponseBody
	public List<Surveillance> searchSurveillanceByProvider(@RequestParam(value="name") String name ) {
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
	
	@GetMapping("/displaySurveillanceByCode")
	@ResponseBody
	public ResponseEntity<Surveillance> displaySurveillanceByCode(@RequestParam(value="code") String code) {
		return new ResponseEntity<Surveillance>(surveillanceService.searchSurveillanceByCode(code), HttpStatus.OK);
		}


}
