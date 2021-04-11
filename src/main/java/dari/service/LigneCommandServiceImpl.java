package dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dari.entity.LigneCommand;
import dari.repository.LigneCommandRepository;


@Service
public class LigneCommandServiceImpl implements ILigneCommandService{
	
	@Autowired
	LigneCommandRepository LigneCommandRepository;
	
	@Autowired
	ISurveillanceService surveillanceService;

	@Override
	public LigneCommand addLigneCommand(Long idSurveillance, int quantity) {
		// TODO Auto-generated method stub
		LigneCommand lc = new LigneCommand(quantity,surveillanceService.retrieveSurveillance(idSurveillance));
		LigneCommandRepository.save(lc);
		return lc;
	}

	@Override
	public LigneCommand deleteLigneCommand(Long idLigneCommand) {
		// TODO Auto-generated method stub
		LigneCommandRepository.deleteById(idLigneCommand);
		return null ;
	}

	@Override
	public LigneCommand retrieveLigneCommand(Long lcId) {
		// TODO Auto-generated method stub
		return LigneCommandRepository.findById(lcId).get();
	}

	@Override
	public LigneCommand updateLigneCommandBySurveillance(Long lc, Long idSurveillance) {
		// TODO Auto-generated method stub
		LigneCommand ligne = LigneCommandRepository.findById(lc).get();
		ligne.setSurveillance(surveillanceService.retrieveSurveillance(idSurveillance));
		ligne.setUnitPrice(surveillanceService.retrieveSurveillance(idSurveillance).getPrice());
		ligne.setLignePrice(ligne.getQuantity()*ligne.getUnitPrice());
		LigneCommandRepository.save(ligne);
		return ligne;
	}

	@Override
	public LigneCommand updateLigneCommandByQuantity(Long lc, int quantity) {
		// TODO Auto-generated method stub
		LigneCommand ligne = LigneCommandRepository.findById(lc).get();
		ligne.setQuantity(quantity);
		ligne.setLignePrice(ligne.getQuantity()*ligne.getUnitPrice());
		LigneCommandRepository.save(ligne);
		return ligne;
	}

	

	
	

}
