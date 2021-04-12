package dari.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dari.entity.Client;
import dari.entity.LigneCommand;
import dari.entity.StateCommand;
import dari.entity.Surveillance;
import dari.entity.SurveillanceCommand;
import dari.entity.SurveillanceOfficer;
import dari.repository.ClientRepository;
import dari.repository.SurveillanceOfficerRepository;
import dari.service.ISurveillanceCommandService;

@Controller
public class SurveillanceCommandController {
	
		@Autowired
		ISurveillanceCommandService surveillanceCommandService;
		
		@GetMapping("/detailsCommand/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> detailsCommand(@PathVariable("idCommand") Long idCommand){
		try{
		 return new ResponseEntity<Object>(surveillanceCommandService.detailsCommand(idCommand),HttpStatus.OK);
		    }
		 catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
			}
		}
		
		@DeleteMapping("/deleteCommand/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> removeCommand(@PathVariable("idCommand") Long idCommand){
		try{
		surveillanceCommandService.removeCommand(idCommand);
		return new ResponseEntity<Object>("the command has been successfully removed :)",HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
	
		@PostMapping("/AddDevis/{idClient}")
		@ResponseBody
		public ResponseEntity<Object> addDevis(@RequestBody List<LigneCommand> lc, @PathVariable("idClient") Long idClient) {
	    try{
	    	if( ! surveillanceCommandService.verifeCommand(lc)){
	    	return new ResponseEntity<Object>("les prodfuits doivent etre appartiennent à un seul agent",HttpStatus.OK);
	    	}
	    	surveillanceCommandService.demandeDevis(lc, idClient);
		return new ResponseEntity<Object>("Your request has been sent",HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		@PutMapping("/ReponseDevis/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> ReponseDevis(@PathVariable("idCommand") Long idCommand , @RequestParam(value="description") String description ,
				@RequestParam(value="bonus") double bonus ) {
		try{
		return new ResponseEntity<Object>(surveillanceCommandService.ReponseDevis(idCommand, description, bonus),HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		@PutMapping("/requestPasseCommand/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> requestPasseCommand(@PathVariable("idCommand") Long idCommand) {
		try{
		surveillanceCommandService.requestPasseCommand(idCommand);
		return new ResponseEntity<Object>("your command being processed",HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		@PutMapping("/responsePasseCommand/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> responsePasseCommand(@PathVariable("idCommand") Long idCommand ,@RequestParam(value="description") String description ) {
		try{
		return new ResponseEntity<Object>(surveillanceCommandService.responsePasseCommand(idCommand, description),HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}	
		}
		
		@PutMapping("/annulerCommand/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> annulerCommand(@PathVariable("idCommand") Long idCommand) {
		try{
		surveillanceCommandService.annulerPassCommand(idCommand);
		return new ResponseEntity<Object>( "your command has been canceled" ,HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}	
		}
		
		@PutMapping("/confirmeCommand/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> confirmeCommand(@PathVariable("idCommand") Long idCommand) {
		try{
			surveillanceCommandService.CommandConfirmer(idCommand);
		return new ResponseEntity<Object>("commandeConfirmée",HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}	
		}
		
		@PutMapping("/requestAvoir/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> requestAvoir(@PathVariable("idCommand") Long idCommand) {
		try{
		return new ResponseEntity<Object>(surveillanceCommandService.requestRetourCommand(idCommand),HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}	
		}
		
		@PutMapping("/responseAvoir/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> responseAvoir(@PathVariable("idCommand") Long idCommand ,@RequestParam(value="description") String description,
				@RequestParam(value="avoir") boolean avoir	) {
		try{
		return new ResponseEntity<Object>(surveillanceCommandService.responseRetourCommand(idCommand, description, avoir),HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}	
		}
		
		//############################### DEVIS CLIENT ################################
		
		@GetMapping("/afficherRequestDevisClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestDevisClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.DEVIS, false);
		}
		
		@GetMapping("/afficherResponseDevisClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponseDevisClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.DEVIS,true);
		}
		
		//############################### DEVIS AGENT ################################	
		
		@GetMapping("/afficherRequestDevisAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestDevisAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.DEVIS, false);
		}
		
		@GetMapping("/afficherReponseDevisAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponseDevisAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.DEVIS, true);
		}
		
		//############################### COMMAND CLIENT ################################
		
		@GetMapping("/afficherRequestPassCommandClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestPassCommandClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.PASSECOMMAND, false);
		}
		
		@GetMapping("/afficherResponsePassCommandClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponsePassCommandClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.PASSECOMMAND,true);
		}
		
		@GetMapping("/afficherAnnulerPassCommandClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherAnnulerPassCommandClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.ANNULER,true);
		}
		
		@GetMapping("/afficherOKCommandClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherOKCommandClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.OK,true);
		}
		
		//############################### COMMAND AGENT ################################
		
		@GetMapping("/afficherRequestPassCommandAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestPassCommandAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.PASSECOMMAND, false);
		}
		
		@GetMapping("/afficherResponsePassCommandAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponsePassCommandAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.PASSECOMMAND, true);
		}
		
		@GetMapping("/afficherAnnulerPassCommandAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherAnnulerPassCommandAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.ANNULER, true);
		}
		
		@GetMapping("/afficheeOkCommandAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherOkCommandAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.OK, true);
		}
		
		//############################### AVOIR CLIENT ################################
		
		@GetMapping("/afficherRequestAvoirClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestAvoirClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.AVOIR, false);
		}
		
		@GetMapping("/afficherResponseAvoirClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponseAvoirClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.AVOIR, true);
		}
		
		@Autowired
		ClientRepository cr;
		
		@GetMapping("/afficherAvoirConfirmerClient/{idClient}")
		@ResponseBody
		public Map<SurveillanceOfficer,Double> afficherAvoirConfirmerClient(@PathVariable("idClient") Long idClient){
			return cr.findById(idClient).get().getAvoirs();
		}
		
		
		//############################### AVOIR AGENT ################################
		
		@GetMapping("/afficherRequestAvoirAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestAvoirAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.AVOIR, false);
		}
		
		@GetMapping("/afficherResponseAvoirAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponseAvoirAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.AVOIR, true);
		}
		
		@Autowired
		SurveillanceOfficerRepository sor;
		
		@GetMapping("/afficherAvoirConfirmerAgent/{idAgent}")
		@ResponseBody
		public Map<Client,Double> afficherAvoirConfirmerAgent(@PathVariable("idAgent") Long idAgent){
			return sor.findById(idAgent).get().getAvoirs();
		}
		
		//####################################### STATISTIQUE ###########################################
		
	/*	@GetMapping("/affichersatatisqueVendre/{idAgent}")
		@ResponseBody
		public Map<Surveillance, Integer> satatisqueVendre(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.surveillanceVendre(idAgent);
		}
		
		@GetMapping("/affichersatatisqueRetour/{idAgent}")
		@ResponseBody
		public Map<Surveillance, Integer> satatisqueRetour(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.surveillanceRetour(idAgent);
		}*/
		
		@GetMapping("/affichersatatisqueLike/{idAgent}")
		@ResponseBody
		public Map<Surveillance, Integer> satatisqueLike(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.statistiquebyllike(idAgent);
		}
		
		@GetMapping("/affichersatatisqueDesLike/{idAgent}")
		@ResponseBody
		public Map<Surveillance, Integer> satatisqueDesLike(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.statistiquebyDesike(idAgent);
		}

}
