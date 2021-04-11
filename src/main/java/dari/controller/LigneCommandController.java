package dari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import dari.service.ILigneCommandService;

@Controller
public class LigneCommandController {
	
	    @Autowired
	    ILigneCommandService ligneCommandService;
	
	
		@PostMapping("/addLigneCommand") 
		@ResponseBody
		public ResponseEntity<Object> addLigneCommand(@RequestParam(value="SurveillancId") Long SurveillanceId,@RequestParam(value="quantity")int quantity) { 
	    try{
	    return new ResponseEntity<Object>( ligneCommandService.addLigneCommand(SurveillanceId, quantity),HttpStatus.OK);
	    }
	    catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		@DeleteMapping("/removeLigneCommand/{lcId}") 
		@ResponseBody
		public ResponseEntity<Object> removeLigneCommand(@PathVariable("lcId") Long lcId) { 
	    try{
	    	ligneCommandService.deleteLigneCommand(lcId);
	    return new ResponseEntity<Object>("the line has been deleted successfully :)",HttpStatus.OK);
	    }
	    catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		@GetMapping("/getLigneCommand/{lcId}") 
		@ResponseBody
		public ResponseEntity<Object> getLigneCommand(@PathVariable("lcId") Long lcId) { 
	    try{
	    return new ResponseEntity<Object>(ligneCommandService.retrieveLigneCommand(lcId),HttpStatus.OK);
	    }
	    catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		@PutMapping("/updateLigneCommandBySurveillance/{lcId}") 
		@ResponseBody
		public ResponseEntity<Object> ModifierLigneCommandBySurveillance(@PathVariable("lcId") Long lcId , @RequestParam(value="surveillanceId") Long surveillanceId) { 
	    
	    try{
		return new ResponseEntity<Object>(ligneCommandService.updateLigneCommandBySurveillance(lcId, surveillanceId),HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		@PutMapping("/updateLigneCommandByQuantity/{lcId}") 
		@ResponseBody
		public ResponseEntity<Object> ModifierLigneCommandByQuantity(@PathVariable("lcId") Long lcId , @RequestParam(value="quantity") int quantity) {  
	    try{
		return new ResponseEntity<Object>(ligneCommandService.updateLigneCommandByQuantity(lcId, quantity),HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		

}
