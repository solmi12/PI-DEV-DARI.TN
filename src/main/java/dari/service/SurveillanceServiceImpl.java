package dari.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.Surveillance;
import dari.repository.SurveillanceRepository;

@Service
public class SurveillanceServiceImpl implements ISurveillanceService{
	
	@Autowired
	SurveillanceRepository surveillanceRepository;

	@Override
	public Collection<Surveillance> retrieveAllSurveillance() {
		// TODO Auto-generated method stub
		return surveillanceRepository.findAll();
	}

	@Override
	public Surveillance retrieveSurveillancer(Long id) {
		// TODO Auto-generated method stub
		return surveillanceRepository.findById(id).get();
	}

	@Override
	public Surveillance addSurveillance(Surveillance s) {
		// TODO Auto-generated method stub
		surveillanceRepository.save(s);
		return null ;
	}

	@Override
	public void deleteSurveillance(Long id) {
		// TODO Auto-generated method stub
		surveillanceRepository.deleteById(id);
		
	}

	@Override
	public Surveillance updateUser(Surveillance u) {
		// TODO Auto-generated method stub
		surveillanceRepository.save(u);
		return u;
	}

	@Override
	public Collection<Surveillance> searchSurveillanceByCapteur(String capteur) {
		// TODO Auto-generated method stub
		return surveillanceRepository.searchByCapteur(capteur);
	}

	@Override
	public Collection<Surveillance> searchSurveillanceByResolution(int resolution) {
		// TODO Auto-generated method stub
		return surveillanceRepository.searchByResolution(resolution);
	}

	@Override
	public Collection<Surveillance> searchSurveillanceByPrice(int Price1, int Price2) {
		// TODO Auto-generated method stub
		return surveillanceRepository.searchSurveillanceByPrice(Price1, Price2);
	}

}
