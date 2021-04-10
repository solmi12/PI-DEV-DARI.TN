package dari.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dari.entity.CategorySurveillance;
import dari.entity.Surveillance;
import dari.entity.SurveillanceOfficer;
import dari.entity.Valeurs;
import dari.repository.SurveillanceOfficerRepository;
import dari.repository.SurveillanceRepository;
import dari.repository.ValeursRepository;

@Service
public class SurveillanceServiceImpl implements ISurveillanceService{
	
	@Autowired
	SurveillanceRepository surveillanceRepository;
	
	@Autowired
	SurveillanceOfficerRepository surveillanceOfficerRepository;
	
	@Autowired
	ValeursRepository valeursRepository;
	
	@Override
	public String generateCodeCommande() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().toUpperCase().substring(0, 18);
	}
	
	@Override
	public Surveillance addValueInMap(Long idSurveillance, Long key, Long value) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(idSurveillance).get();
		if(! s.getAvisClients().containsKey(key) )
		{
		Valeurs v = new Valeurs();
		v.getValeurs().add(value);
		valeursRepository.save(v);
		s.getAvisClients().put(key, v);
		surveillanceRepository.save(s);
		}
		else{
		Valeurs v = s.getAvisClients().get(key);
		v.getValeurs().add(value);
		valeursRepository.save(v);
		s.getAvisClients().put(key, v);
		surveillanceRepository.save(s);
		}
		return s;
	}
	
	@Override
	public boolean searchValueInMap(Long idSurveillance, Long key, Long value) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(idSurveillance).get();
		Map<Long,Valeurs> map = s.getAvisClients();
			if (map.containsKey(key)&& map.get(key).getValeurs().contains(value)){
				
				return true;
			}
			else return false;
	}
	
	@Override
	public Surveillance deleteValueInMap(Long idSurveillance, Long key, Long value) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(idSurveillance).get();
		if (! searchValueInMap(idSurveillance,key,value)){
			Map<Long,Valeurs> map = s.getAvisClients();
			Valeurs v = map.get(key);
			v.getValeurs().remove(value);
			valeursRepository.save(v);
			map.put(key,v);
			if(v.getValeurs().size()==0)
			{
				map.remove(key);
				valeursRepository.deleteById(v.getIdValeur());
			}
		s.setAvisClients(map);
		surveillanceRepository.save(s);
		}
		
		return s;
	}
	
	@Override
	public void addSurveillanceAndaffecterSurveillanceOfficerToSurveillance(String productName, String capteur,
			int resolution, int indiceProtection, int porteeInfrarouge, CategorySurveillance categorySurveillance,
			double price, Long surveillanceOfficerId) {
		// TODO Auto-generated method stub
		Surveillance surveillance = new Surveillance(productName, capteur, resolution, indiceProtection, porteeInfrarouge, price, categorySurveillance);
		SurveillanceOfficer so = surveillanceOfficerRepository.findById(surveillanceOfficerId).get();
		surveillance.setSurveillanceOfficer(so);
		surveillance.setCodeSurveillance(generateCodeCommande());
		surveillance.setDateAdd(new Date());
		surveillanceRepository.save(surveillance);
		
	}
	
	@Override
	public Surveillance retrieveSurveillance(long id) {
		// TODO Auto-generated method stub
		return surveillanceRepository.findById(id).get();
	}
	
	@Override
	public String deleteSurveillance(Long id , Long idAgent) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(id).get();
		if(s.getSurveillanceOfficer().getIdSurveillanceOfficer()==idAgent){
		surveillanceRepository.deleteById(id);
		return null;
		}
		else{
			return null;
		}
		
	}
	
	@Override
	public List<Surveillance> retrieveAllSurveillanceByOfficer(Long officerId) {
		// TODO Auto-generated method stub
		return  surveillanceOfficerRepository.findById(officerId).get().getSurveillances();
		 
	}
	
	@Override
	public List<Surveillance> retrieveAllSurveillance() {
		// TODO Auto-generated method stub
		return  (List<Surveillance>) surveillanceRepository.findAll();
	}

	@Override
	public List<Surveillance> searchSurveillanceByPrice(double Price1, double Price2) {
		// TODO Auto-generated method stub
		double x =0;
		if(Price1>Price2){
			x=Price2;
			Price2=Price1;
			Price1=x;
			}
		return surveillanceRepository.findByPriceBetween(Price1, Price2);
	}

	@Override
	public List<Surveillance> searchSurveillanceByCategory(CategorySurveillance category) {
		// TODO Auto-generated method stub
		return surveillanceRepository.findByCategorySurveillanceLike(category);
	}

	@Override
	public Surveillance searchSurveillanceByProductName(String name) {
		// TODO Auto-generated method stub
		return surveillanceRepository.findByProductNameLike(name);
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
	public List<Surveillance> displaySurveillanceByDate() {
		// TODO Auto-generated method stub
		return surveillanceRepository.SurveillanceByDate();
	}

	@Override
	public Surveillance ajouterSupprimerLike(Long idSurveillance, Long idClient) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(idSurveillance).get();
		if(! s.getIdClientsLike().contains(idClient)){
			s.setJaime(s.getJaime()+1);
			s.getIdClientsLike().add(idClient);
			surveillanceRepository.save(s);
			return s;
		}
		else {
			s.setJaime(s.getJaime()-1);
			s.getIdClientsLike().remove(idClient);
			surveillanceRepository.save(s);
			return s;
		}
		
	}
	
	@Override
	public List<Surveillance> displaySurveillanceByLike() {
		// TODO Auto-generated method stub
		return surveillanceRepository.SurveillanceByLike();
	}

	@Override
	public Surveillance ajouterSupprimerDeslike(Long idSurveillance, Long idClient) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(idSurveillance).get();
		if(! s.getIdClientsDeslike().contains(idClient)){
			s.setJaimeplus(s.getJaimeplus()+1);
			s.getIdClientsDeslike().add(idClient);
			surveillanceRepository.save(s);
			return s;
		}
		else {
			s.setJaimeplus(s.getJaimeplus()-1);
			s.getIdClientsDeslike().remove(idClient);
			surveillanceRepository.save(s);
			return s;
		}
	}

	@Override
	public List<Surveillance> searchSurveillanceByProvider(String name) {
		// TODO Auto-generated method stub
		return surveillanceOfficerRepository.findByUserNameLike(name).getSurveillances();
	}

	@Override
	public Surveillance searchSurveillanceByCode(String code) {
		// TODO Auto-generated method stub
		return surveillanceRepository.findByCodeSurveillanceLike(code);
	}

	@Override
	public Object updateSurveillance(String productName, String capteur, int resolution, int indiceProtection,
			int porteeInfrarouge, CategorySurveillance categorySurveillance, double price, Long surveillanceOfficerId,
			Long surveillanceId) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(surveillanceId).get();
		if(s.getSurveillanceOfficer().getIdSurveillanceOfficer()==surveillanceOfficerId){
		s.setProductName(productName);
		s.setCapteur(capteur);
		s.setResolution(resolution);
		s.setIndiceProtection(indiceProtection);
		s.setPorteeInfrarouge(porteeInfrarouge);
		s.setCategorySurveillance(categorySurveillance);
		s.setPrice(price);
		surveillanceRepository.save(s);
		return "the ad has been modified successfully :)";
		}
		else {
		return "modification failure" ;
		}
	}


}
