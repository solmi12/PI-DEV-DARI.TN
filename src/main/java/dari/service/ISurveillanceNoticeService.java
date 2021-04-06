package dari.service;


import java.util.List;

import dari.entity.SurveillanceNotice;


public interface ISurveillanceNoticeService {
	
	public int addSurveillanceNoticeAndaffecterSurveillanceToSurveillanceNotice(SurveillanceNotice Notice, long surveillanceId); //ajouter un avis et l'affecter à une surveilleance
	public int deleteSurveillanceNotice(Long id); //supprimer un avis
	public List<SurveillanceNotice> retrieveSurveillanceNoticeBySurveillance(long SurveillanceId); //afficher les avis d'une surveillance



}
