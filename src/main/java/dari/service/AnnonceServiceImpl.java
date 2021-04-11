package dari.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.AnnonceImmobilier;
import dari.entity.AnnonceRegion;
import dari.entity.AnnonceType;
import dari.entity.Client;
import dari.entity.TypeTransaction;
import dari.repository.AnnonceRepository;
import dari.repository.ClientRepository;
import dari.service.IAnnonceService;



@Service
public class AnnonceServiceImpl implements IAnnonceService{
	@Autowired
	AnnonceRepository annonceRepository;
	@Autowired
	ClientRepository cr;
	private static final Logger L =LogManager.getLogger(AnnonceServiceImpl.class);


	@Override
	public List<AnnonceImmobilier> retrieveAllAnnonces() {
		
		List<AnnonceImmobilier> annonces =(List<AnnonceImmobilier>) annonceRepository.findAll();
		
		for(AnnonceImmobilier annonce : annonces  ){
			L.info("annonce +++"+ annonce ) ;
		}
			return annonces;
	}

	@Override
	public AnnonceImmobilier addAnnonce(long id_client,AnnonceImmobilier annonce) {
		Client a = new Client();
		Client c = (Client) cr.findById(id_client).get();
		a.setIdClient(id_client);a.setAdresseEmail(c.getAdresseEmail());a.setTel(c.getTel());
		annonce.setClient(a);
		return annonceRepository.save(annonce);
	}

	@Override
	public AnnonceImmobilier retrieveAnnonce(long annonce_ref) {
		
		return annonceRepository.findById(annonce_ref).get();
	}

	@Override
	public void deleteAnnonce(long annonce_ref) {
		annonceRepository.deleteById(annonce_ref);
	}

	@Override
	public AnnonceImmobilier updateAnnonce(AnnonceImmobilier annonce) {
		return annonceRepository.save(annonce);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByRegion(AnnonceRegion region) {
		
		return annonceRepository.retrieveByRegion(region);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByType(AnnonceType type) {	
		return annonceRepository.retrieveByType(type);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByPrixMax(long prixMax) {

		return annonceRepository.retrieveByPrixMax(prixMax);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByPrixMin(long prixMin) {
	
		return annonceRepository.retrieveByPrixMin(prixMin);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByTypeTrans(TypeTransaction typeTrans) {

		return annonceRepository.retrieveByTypeTrans(typeTrans);
	}

	@Override
	public long StatByRegion(AnnonceRegion region) {
		
		return annonceRepository.statByRegion(region);
	}

	/*@Override
	public long StatByPrixMax(long prixMax) {
		return annonceRepository.stateByPrixMax(prixMax);
	}
	@Override
	public long StatByPrixMin(long prixMin) {
		return annonceRepository.stateByPrixMin(prixMin);
	}*/

	@Override
	public long StatByType(AnnonceType type) {
		return annonceRepository.statByType(type);
	}

	@Override
	public long StatByTypeTrans(TypeTransaction typeTrans) {

		return annonceRepository.statByTypeTrans(typeTrans);
	}

	/*@Override
	public List<AnnonceImmobilier> retrieveRegionById(AnnonceRegion region) {
		// TODO Auto-generated method stub
		return annonceRepository.retrieveRgionByID(region);
	} */

	
}
