package dari.service;


import java.util.List;
import dari.entity.CategorySurveillance;
import dari.entity.Surveillance;



public interface ISurveillanceService {
	
	public Surveillance addSurveillance(Surveillance s); //ajouter surveillance :)
	
	public Surveillance addLike(long surveillanceId); //ajouter like
	
	public Surveillance addDeslike(long surveillanceId); //ajouter dislike
	
	public int deleteSurveillance(Long id); //supprimer surveillance :)
	
	public Surveillance updateSurveillance(Surveillance s); //modifier surveillance :)
	
	public void affecterSurveillanceOfficerToSurveillance(long surveillanceOfficerId , long SurveillanceID); //affecter un agent à une surveillance :)
	
	public void addSurveillanceAndaffecterSurveillanceOfficerToSurveillance(Surveillance Surveillance, long surveillanceOfficerId); //ajouter une surveillance et l'affecter à un agent :)
	
	public Surveillance retrieveSurveillance(long id); //trouver une surveillance par ID :)
	
	public List<Surveillance> retrieveAllSurveillance(); //retourne la liste de tout les surveillances :)
	
	public List<Surveillance> retrieveAllSurveillanceByOfficer(int officerId); //trouver les surveillances d'un agent :)
	
	public List<Surveillance> searchSurveillanceByPrice(double Price1 , double Price2); //trouver les surveillances par prix :)
	
	public List<Surveillance> searchSurveillanceByCategory(CategorySurveillance category);//trouver les surveillances par category :)
	
	public List<Surveillance> searchSurveillanceByProvider(String name); //trouver les surveillances par Provider :)
	
	public List<Surveillance> displaySurveillanceByPriceAsc(); //trouver les surveillances par prix ascendant :)
	
	public List<Surveillance> displaySurveillanceByPriceDesc();//trouver les surveillances par prix descend :)
	
	public List<Surveillance> displaySurveillanceByLike();//trouver les surveillances par like :)
	
	public List<Surveillance> displaySurveillanceByDate();//trouver les surveillances par date :)




}
