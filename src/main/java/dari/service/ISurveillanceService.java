package dari.service;


import java.util.List;
import dari.entity.CategorySurveillance;
import dari.entity.Surveillance;



public interface ISurveillanceService {
	
	public String generateCodeCommande();
	
	public void addSurveillanceAndaffecterSurveillanceOfficerToSurveillance(String productName, String capteur , int resolution, int indiceProtection,
			int porteeInfrarouge,CategorySurveillance categorySurveillance,double price, Long surveillanceOfficerId); //ajouter une surveillance et l'affecter à un agent :)
	
	public Surveillance retrieveSurveillance(long id); //trouver une surveillance par ID :)
	
	public int deleteSurveillance(Long id); //supprimer surveillance :)
	
	//public Surveillance updateSurveillance(Surveillance s); //modifier surveillance :)
	
	public Surveillance ajouterSupprimerLike(Long idSurveillance, Long idClient);
	
	public Surveillance ajouterSupprimerDeslike(Long idSurveillance, Long idClient);
	
	public List<Surveillance> retrieveAllSurveillanceByOfficer(Long officerId); //trouver les surveillances d'un agent :)
	
	public List<Surveillance> retrieveAllSurveillance(); //retourne la liste de tout les surveillances :)
	
	public List<Surveillance> searchSurveillanceByPrice(double Price1 , double Price2); //trouver les surveillances par prix :)
	
	public List<Surveillance> searchSurveillanceByCategory(CategorySurveillance category);//trouver les surveillances par category :)
	
	public List<Surveillance> searchSurveillanceByProductName(String name); //trouver les surveillances par Provider :)
	
	public List<Surveillance> searchSurveillanceByProvider(String name); //trouver les surveillances par Provider :)
	
	public List<Surveillance> displaySurveillanceByPriceAsc(); //trouver les surveillances par prix ascendant :)
	
	public List<Surveillance> displaySurveillanceByPriceDesc();//trouver les surveillances par prix descend :)

	public List<Surveillance> displaySurveillanceByDate();//trouver les surveillances par date :)
	
	public List<Surveillance> displaySurveillanceByLike();//trouver les surveillances par like :)




}
