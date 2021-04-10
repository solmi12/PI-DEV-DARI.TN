package dari.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dari.entity.AnnonceImmobilier;
import dari.entity.AnnonceRegion;
import dari.service.IRechercheService;

@RestController
public class RechercheControle {
	@Autowired
	IRechercheService is;
	
	@PostMapping("add-recherche/{id}/{region}")
	@ResponseBody
	public List<AnnonceImmobilier> addAnnonce(@PathVariable("id")long id,@PathVariable("region")AnnonceRegion region) {
		
		return is.addRecherche(id, region);
		}
	
	@GetMapping("get-publicite/{id}")
	@ResponseBody
	public List<AnnonceImmobilier> getPub(@PathVariable ("id")long id){
		return is.getPub(id);
		
	}

}
