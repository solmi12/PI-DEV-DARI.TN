package dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dari.entity.SurveillanceOfficer;
import dari.repository.SurveillanceOfficerRepository;

@Service
public class SurveillanceOfficerServiceImpl implements ISurveillanceOfficerService {
	
	@Autowired
	SurveillanceOfficerRepository surveillanceOfficerRepository;
	@Override
	public SurveillanceOfficer addSurveillanceOfficer() {
		// TODO Auto-generated method stub
		SurveillanceOfficer surveillanceOfficer = new SurveillanceOfficer();
		surveillanceOfficerRepository.save(surveillanceOfficer);
		return surveillanceOfficer;
	}

	
}
