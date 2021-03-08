package dari.service;

import java.util.Collection;


import dari.entity.Surveillance;



public interface ISurveillanceService {
	
	public Collection<Surveillance> retrieveAllSurveillance();
	public Surveillance retrieveSurveillancer(Long id);
	public Surveillance addSurveillance(Surveillance s);
	public void deleteSurveillance(Long id);
	public Surveillance updateUser(Surveillance u);
	public Collection<Surveillance> searchSurveillanceByCapteur(String capteur);
	public Collection<Surveillance> searchSurveillanceByResolution(int resolution);
	public Collection<Surveillance> searchSurveillanceByPrice(int Price1 , int Price2);


}
