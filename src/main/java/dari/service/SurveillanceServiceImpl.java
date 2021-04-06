package dari.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dari.entity.CategorySurveillance;
import dari.entity.Surveillance;
import dari.entity.SurveillanceOfficer;
import dari.repository.SurveillanceOfficerRepository;
import dari.repository.SurveillanceRepository;

@Service
public class SurveillanceServiceImpl implements ISurveillanceService{
	
	@Autowired
	SurveillanceRepository surveillanceRepository;
	
	@Autowired
	SurveillanceOfficerRepository surveillanceOfficerRepository; 
	

	@Override
	public List<Surveillance> retrieveAllSurveillance() {
		// TODO Auto-generated method stub
		List<Surveillance> surveillances = (List<Surveillance>) surveillanceRepository.findAll();
		return surveillances;
	}

	@Override
	public Surveillance retrieveSurveillance(long id) {
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
	public int deleteSurveillance(Long id) {
		// TODO Auto-generated method stub
		surveillanceRepository.deleteById(id);
		return 1;
		
	}

	@Override
	public Surveillance updateSurveillance(Surveillance u) {
		// TODO Auto-generated method stub
		surveillanceRepository.save(u);
		return u;
	}


	@Override
	public void affecterSurveillanceOfficerToSurveillance(long SurveillanceOfficerID, long surveillanceId) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(surveillanceId).get();
		SurveillanceOfficer so = surveillanceOfficerRepository.findById(SurveillanceOfficerID).get();
		s.setSurveillanceOfficer(so);
		surveillanceRepository.save(s);
		surveillanceOfficerRepository.save(so);
		}

	@Override
	public void addSurveillanceAndaffecterSurveillanceOfficerToSurveillance(Surveillance Surveillance,
			long surveillanceOfficerId) {
		// TODO Auto-generated method stub
		SurveillanceOfficer so = surveillanceOfficerRepository.findById(surveillanceOfficerId).get();
		Surveillance.setSurveillanceOfficer(so);
		surveillanceRepository.save(Surveillance);
		}

	@Override
	public List<Surveillance> retrieveAllSurveillanceByOfficer(int officerId) {
		// TODO Auto-generated method stub
		return surveillanceRepository.retrieveAllSurveillanceByOfficer(officerId);
		 
	}

	@Override
	public List<Surveillance> searchSurveillanceByPrice(double Price1, double Price2) {
		// TODO Auto-generated method stub
		return surveillanceRepository.findByPriceBetween(Price1, Price2);
	}

	@Override
	public List<Surveillance> searchSurveillanceByCategory(CategorySurveillance category) {
		// TODO Auto-generated method stub
		return surveillanceRepository.findByCategorySurveillanceLike(category);
	}

	@Override
	public List<Surveillance> searchSurveillanceByProvider(String name) {
		// TODO Auto-generated method stub
		return surveillanceRepository.findByProviderNameLike(name);
	}

	@Override
	public List<Surveillance> displaySurveillanceByPriceAsc() {
		// TODO Auto-generated method stub
		return surveillanceRepository.SurveillanceByPriceAsc();
	}

	@Override
	public List<Surveillance> displaySurveillanceByPriceDesc() {
		// TODO Auto-generated method stub
		return surveillanceRepository.SurveillanceByPriceDesc();
	}

	@Override
	public List<Surveillance> displaySurveillanceByLike() {
		// TODO Auto-generated method stub
		return surveillanceRepository.SurveillanceByLike();
	}

	@Override
	public List<Surveillance> displaySurveillanceByDate() {
		// TODO Auto-generated method stub
		return surveillanceRepository.SurveillanceByDate();
	}

	@Override
	public Surveillance addLike(long surveillanceId) {
		// TODO Auto-generated method stub
		Surveillance s = new Surveillance();
		s=surveillanceRepository.findById(surveillanceId).get();
		int nbe =s.getLike()+1;
		s.setLike(nbe);
		surveillanceRepository.save(s);
		return s;
	}

	@Override
	public Surveillance addDeslike(long surveillanceId) {
		// TODO Auto-generated method stub
		Surveillance s = new Surveillance();
		s=surveillanceRepository.findById(surveillanceId).get();
		int nbe =s.getDeslike();
		s.setDeslike(nbe);
		surveillanceRepository.save(s);
		return s;
	}

}
