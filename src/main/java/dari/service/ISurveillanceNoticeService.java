package dari.service;


import java.util.List;

import dari.entity.SurveillanceNotice;


public interface ISurveillanceNoticeService {
	
	public SurveillanceNotice addSurveillanceNoticeAndaffecterSurveillanceToSurveillanceNotice(String description , Long surveillanceId , Long idClient); //ajouter un avis et l'affecter à une surveilleance
	public String deleteSurveillanceNotice(Long idNotice , Long idSurveillance , Long idClient); //supprimer un avis
	public List<SurveillanceNotice> retrieveSurveillanceNoticeBySurveillance(Long SurveillanceId); //afficher les avis d'une surveillance



}
