package dari.service;
import java.util.List;

import dari.entity.AnnonceImmobilier;
import dari.entity.AnnonceRegion;
public interface IRechercheService {

 List<AnnonceImmobilier> addRecherche(long client_id,AnnonceRegion region);
 
 List<AnnonceImmobilier> getPub(long id);
	
}
