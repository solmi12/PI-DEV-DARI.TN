package dari.service;

import java.util.Collection;
import dari.entity.SurveillanceNotice;


public interface ISurveillanceNotice {
	
	public Collection<SurveillanceNotice> retrieveAllSurveillanceNotice();
	public SurveillanceNotice addSurveillanceNotice(SurveillanceNotice s);
	public void deleteSurveillanceNotice(Long id);

}
