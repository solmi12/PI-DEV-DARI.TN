package dari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import dari.entity.LigneCommand;
import dari.repository.SurveillanceCommandRepository;
import dari.service.ILigneCommandService;

@Controller
public class LigneCommandController {
	
	    @Autowired
	    ILigneCommandService ligneCommandService;
	
	
		@PostMapping("/addLigneCommand/{SurveillancId}/{quantity}") 
		@ResponseBody
		public int addLigneCommand(@PathVariable("SurveillancId") Long SurveillanceId,@PathVariable("quantity") int quantity) { 
	    ligneCommandService.addLigneCommand(SurveillanceId, quantity);
		return 200;
		}
		
		@DeleteMapping("/removeLigneCommand/{lcId}") 
		@ResponseBody
		public int removeLigneCommand(@PathVariable("lcId") Long lcId) { 
	    ligneCommandService.deleteLigneCommand(lcId);
		return 200;
		}
		
		@GetMapping("/getLigneCommand/{lcId}") 
		@ResponseBody
		public LigneCommand getLigneCommand(@PathVariable("lcId") Long lcId) { 
	    
		return ligneCommandService.retrieveLigneCommand(lcId);
		}
		
		@PutMapping("/updateLigneCommandBySurveillance/{lcId}/{surveillanceId}") 
		@ResponseBody
		public int ModifierLigneCommandBySurveillance(@PathVariable("lcId") Long lcId , @PathVariable("surveillanceId") Long surveillanceId) { 
	    ligneCommandService.updateLigneCommandBySurveillance(lcId, surveillanceId);
		return 200;
		}
		
		@PutMapping("/updateLigneCommandByQuantity/{lcId}/{quantity}") 
		@ResponseBody
		public int ModifierLigneCommandByQuantity(@PathVariable("lcId") Long lcId , @PathVariable("quantity") int quantity) { 
	    ligneCommandService.updateLigneCommandByQuantity(lcId, quantity);
		return 200;
		}
		
		

}
