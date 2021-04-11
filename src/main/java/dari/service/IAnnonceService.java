package dari.service;

import java.util.List;

import dari.entity.AnnonceImmobilier;
import dari.entity.AnnonceRegion;
import dari.entity.AnnonceType;
import dari.entity.TypeTransaction;

public interface IAnnonceService {
	List<AnnonceImmobilier> retrieveAllAnnonces();
	AnnonceImmobilier addAnnonce(long id_client,AnnonceImmobilier annonce);
	AnnonceImmobilier retrieveAnnonce(long annonce_ref);
	void deleteAnnonce(long annonce_ref);
	AnnonceImmobilier updateAnnonce(AnnonceImmobilier annonce);
	List<AnnonceImmobilier> retrieveAnnonceByRegion(AnnonceRegion region);
	List<AnnonceImmobilier> retrieveAnnonceByType(AnnonceType Type);
	List<AnnonceImmobilier> retrieveAnnonceByPrixMax(long prixMax);
	List<AnnonceImmobilier> retrieveAnnonceByPrixMin(long prix);
	List<AnnonceImmobilier> retrieveAnnonceByTypeTrans(TypeTransaction typeTran);
	long StatByRegion(AnnonceRegion region);
	/*long StatByPrixMax(long prixMax);
	long StatByPrixMin(long prixMin);*/
	long StatByType(AnnonceType Type);
	long StatByTypeTrans(TypeTransaction typeTrans);
	
	
	/*List<AnnonceImmobilier> retrieveRegionById(AnnonceRegion region);*/
}
