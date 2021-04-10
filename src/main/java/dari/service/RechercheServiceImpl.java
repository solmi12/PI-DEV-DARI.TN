package dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.AnnonceImmobilier;
import dari.entity.AnnonceRegion;
import dari.repository.AnnonceRepository;
import dari.repository.RechercheRepository;
import dari.entity.RechercheAnnonce;
@Service
public class RechercheServiceImpl implements IRechercheService {

	
	@Autowired
	RechercheRepository rp;
	@Autowired
	AnnonceRepository ar;
	
	@Override
	public List<AnnonceImmobilier> addRecherche(long id, AnnonceRegion region) {
		RechercheAnnonce x = new RechercheAnnonce();
		x.setClient_id(id);
		x.setRegion(region);
		rp.save(x);
		return ar.retrieveByRegion(region);
	}

	@Override
	public List<AnnonceImmobilier> getPub(long id) {
		
		List<AnnonceImmobilier> list = rp.getpub(id);
		List<AnnonceImmobilier> list2 = ar.findAll();
				for(AnnonceImmobilier annonce : list2){
					if(  list.indexOf(annonce) == -1 ) {list.add(annonce);}
					    // ...
						}
		return list;
	
	
	}

	
	
	
	
	
}
