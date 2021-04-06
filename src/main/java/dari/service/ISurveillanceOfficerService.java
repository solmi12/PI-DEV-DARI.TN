package dari.service;

import dari.entity.SurveillanceOfficer;

public interface ISurveillanceOfficerService {
	
	public void deleteSurveillanceOfficer(Long id);
	public SurveillanceOfficer addSurveillanceOfficer(SurveillanceOfficer surveillanceOfficer);
	public void deleteSurveillanceOfficerAndtheirServeillance(Long id);



}
