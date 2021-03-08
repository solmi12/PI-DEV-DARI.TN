package dari.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.SurveillanceCommand;
import dari.repository.SurveillanceCommandRepository;

@Service
public class SurveillanceCommandServiceImpl implements ISurveillanceCommand{
	
	@Autowired
	SurveillanceCommandRepository surveillanceCommandRepository; 

	@Override
	public Collection<SurveillanceCommand> retrieveAllSurveillanceCommand() {
		// TODO Auto-generated method stub
		return surveillanceCommandRepository.findAll();
	}

	@Override
	public SurveillanceCommand retrieveSurveillancerCommand(Long id) {
		// TODO Auto-generated method stub
		return surveillanceCommandRepository.findById(id).get();
	}

	@Override
	public SurveillanceCommand addSurveillanceCommand(SurveillanceCommand s) {
		// TODO Auto-generated method stub
		return surveillanceCommandRepository.save(s);
	}

	@Override
	public void deleteSurveillanceCommand(Long id) {
		// TODO Auto-generated method stub
		surveillanceCommandRepository.deleteById(id);
		
	}

	@Override
	public SurveillanceCommand updateCommand(SurveillanceCommand s) {
		// TODO Auto-generated method stub
		return surveillanceCommandRepository.save(s);
	}

}
