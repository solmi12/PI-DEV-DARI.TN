package dari.control;

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

import dari.entity.AnnonceImmobilier;
import dari.entity.AnnonceRegion;
import dari.entity.AnnonceType;
import dari.entity.TypeTransaction;
import dari.service.IAnnonceService;

@RestController
public class AnnonceControle {
	@Autowired
	IAnnonceService annonceservice;
	
	@GetMapping("/get-annonces")
	@ResponseBody
	public List<AnnonceImmobilier> getAnnonces(){
	
		List<AnnonceImmobilier> list = annonceservice.retrieveAllAnnonces(); 
		
		return 	list;

		}
	
	@GetMapping("/get-annonce-id/{id}")
	@ResponseBody
	public AnnonceImmobilier getAnnonceById(@PathVariable("id")long id){
		return annonceservice.retrieveAnnonce(id);
		}
	
	@PostMapping("add-annonce/{id_client}")
	@ResponseBody
	public AnnonceImmobilier addAnnonce(@PathVariable("id_client")long id_client, @RequestBody AnnonceImmobilier annonce){
		 
		return annonceservice.addAnnonce(id_client,annonce);	}
		
	@PutMapping("update-annonce")
	@ResponseBody
	public AnnonceImmobilier updateAnnonce(@RequestBody AnnonceImmobilier annonce){
		return annonceservice.updateAnnonce(annonce);	}
		
	@DeleteMapping("delete-annonce/{id}")
	@ResponseBody
	public void deleteAnnonce(@PathVariable("id")long id){
		annonceservice.deleteAnnonce(id);	}
	
	//http://localhost:8081/SpringMVC/servlet//get-annonce-region/TUNIS
	@GetMapping("/get-annonce-region/{region}")
	@ResponseBody
	public List<AnnonceImmobilier> getAnnonceByRegion(@PathVariable("region")AnnonceRegion region){
		
		List<AnnonceImmobilier> list = annonceservice.retrieveAnnonceByRegion(region);
		//List<AnnonceImmobilier> list2 = annonceservice.retrieveAllAnnonces();
		//for(AnnonceImmobilier annonce : list2){
			//list.add(annonce);}
		return  list ; 
	}
	
	//http://localhost:8081/SpringMVC/servlet/get-annonce-type/{type}
	@GetMapping("/get-annonce-type/{type}")
	@ResponseBody
	public List<AnnonceImmobilier> getAnnonceByType(@PathVariable("type")AnnonceType type){
		return annonceservice.retrieveAnnonceByType(type);
	}
	
	//http://localhost:8081/SpringMVC/servlet/get-annonces-prix-max/{prixMax}
	@GetMapping("/get-annonces-prix-max/{prixMax}")
	@ResponseBody
	public List<AnnonceImmobilier> getAnnonceByPrixMax(@PathVariable("prixMax")long prixMax){
		return annonceservice.retrieveAnnonceByPrixMax(prixMax);
		}
	
	//http://localhost:8081/SpringMVC/servlet/get-annonces-prix-min/{prixMin}
	@GetMapping("/get-annonces-prix-min/{prixMin}")
	@ResponseBody
	public List<AnnonceImmobilier> getAnnonceByPrixMin(@PathVariable("prixMin")long prixMin){
		return annonceservice.retrieveAnnonceByPrixMin(prixMin);
		}
	
	//http://localhost:8081/SpringMVC/servlet/get-annonce-type-trans/{typeTrans}
	@GetMapping("/get-annonce-type-trans/{typeTrans}")
	@ResponseBody
	public List<AnnonceImmobilier> getAnnonceByTypeTrans(@PathVariable("typeTrans")TypeTransaction typeTrans){
		return annonceservice.retrieveAnnonceByTypeTrans(typeTrans);
		}
	
	//http://localhost:8081/SpringMVC/servlet/get-annonce-stat-region/{region}
		@GetMapping("/get-annonce-stat-region/{region}")
		@ResponseBody
		public long getStatByRegion(@PathVariable("region")AnnonceRegion region){
			return annonceservice.StatByRegion(region);
			}
	
		//http://localhost:8081/SpringMVC/servlet/get-annonce-stat-type/{type}
				@GetMapping("/get-annonce-stat-type/{type}")
				@ResponseBody
				public long getStatByType(@PathVariable("type")AnnonceType type){
					return annonceservice.StatByType(type);
					}
				
				//http://localhost:8081/SpringMVC/servlet/get-annonce-stat-type-trans/{typeTrans}
				@GetMapping("/get-annonce-stat-type-trans/{typeTrans}")
				@ResponseBody
				public long getStatByTypeTrans(@PathVariable("typeTrans")TypeTransaction typeTrans){
					return annonceservice.StatByTypeTrans(typeTrans);
					}
	
		
}
