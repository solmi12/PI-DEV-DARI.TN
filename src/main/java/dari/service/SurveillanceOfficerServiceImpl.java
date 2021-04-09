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
	public void deleteSurveillanceOfficer(Long id) {
		// TODO Auto-generated method stub
		surveillanceOfficerRepository.deleteById(id);
		
	}

	@Override
	public SurveillanceOfficer addSurveillanceOfficer(SurveillanceOfficer surveillanceOfficer) {
		// TODO Auto-generated method stub
		surveillanceOfficerRepository.save(surveillanceOfficer);
		return surveillanceOfficer;
	}

	@Override
	public void deleteSurveillanceOfficerAndtheirServeillance(Long id) {
		// TODO Auto-generated method stub
	//	surveillanceOfficerRepository.deleteSurveillanceOfficerAndtheirServeillance(id);
		surveillanceOfficerRepository.deleteById(id);
		
	}

	
}
