package dari.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.LigneCommand;
import dari.entity.StateCommand;
import dari.entity.SurveillanceCommand;
import dari.repository.ClientRepository;
import dari.repository.LigneCommandRepository;
import dari.repository.SurveillanceCommandRepository;

@Service
public class SurveillanceCommandServiceImpl2 implements ISurveillanceCommandService{
	
	@Autowired
	SurveillanceCommandRepository surveillanceCommandRepository; 
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	LigneCommandRepository ligneCommandRepository;

	@Override
	public String generateCodeCommande() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().toUpperCase().substring(0, 18);
	}
	
	@Override
	public void removeCommand(Long idCommand) {
		// TODO Auto-generated method stub
		surveillanceCommandRepository.deleteById(idCommand);
		ligneCommandRepository.deleteLigneCommandByCommand(idCommand);
		
	}
	
	@Override
	public List<LigneCommand> detailsCommand(Long idCommand) {
		// TODO Auto-generated method stub
		
		return surveillanceCommandRepository.findById(idCommand).get().getLigneCommands();
	}
	
	@Override
	public List<SurveillanceCommand> displayCommandClientByState(Long idClient, StateCommand sc, boolean stateRequest) {
		// TODO Auto-generated method stub
		return surveillanceCommandRepository.afficherCommandClientByPara(idClient, sc, stateRequest);
	}

	@Override
	public List<SurveillanceCommand> displayCommandAgentByState(Long idAgent, StateCommand sc, boolean stateRequest) {
		// TODO Auto-generated method stub
		List<String> codes = surveillanceCommandRepository.trouverCodeCommandeAgent(idAgent);
		List<SurveillanceCommand> liste = new ArrayList<>();
		for (String code : codes) {
			
		liste.add(surveillanceCommandRepository.afficherCommandAgentByPara(code,sc,stateRequest));
			
		}
		return liste;
	}

	@Override
	public SurveillanceCommand demandeDevis(List<LigneCommand> lc, Long idClient) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = new SurveillanceCommand();
		surveillanceCommandRepository.save(sc);	
		sc.setCodeCommande(generateCodeCommande());
		sc.setDateCammand(new Date());
		sc.setStateCommand(StateCommand.DEVIS);
		sc.setStaterequest(false);
		sc.setFournisseurCommand(surveillanceCommandRepository.findProviderOfCommand(lc.get(0).getIdLigneCommand()));
		double pc=0;
		for (LigneCommand ligneCommand : lc) {
			ligneCommand.setSurveillanceCommand(sc);
			pc+=ligneCommand.getLignePrice();
		}
		sc.setPriceCommand(pc);	
		sc.setFinalPriceCommand(pc);
		sc.setClient(clientRepository.findById(idClient).get());
		return surveillanceCommandRepository.save(sc);
	}
	
	@Override
	public SurveillanceCommand ReponseDevis(Long idCommand, String description, double bonus) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setDescription(description);
		sc.setDiscountprice(bonus);
		sc.setFinalPriceCommand(sc.getPriceCommand()-sc.getDiscountprice());
		sc.setStaterequest(true);
		surveillanceCommandRepository.save(sc);
		return sc;
	}
	
	@Override
	public SurveillanceCommand requestPasseCommand(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setDateCammand(new Date());
		sc.setStaterequest(false);
		sc.setStateCommand(StateCommand.PASSECOMMAND);
		surveillanceCommandRepository.save(sc);
		return sc;
	}
	
	@Override
	public SurveillanceCommand responsePasseCommand(Long idCommand , String description) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setStaterequest(true);
		sc.setDescription(description);
		surveillanceCommandRepository.save(sc);
		return sc;
	}

	@Override
	public void annulerPassCommand(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setStateCommand(StateCommand.ANNULER);
		sc.setStaterequest(true);
		surveillanceCommandRepository.save(sc);
		
	}

	@Override
	public void CommandConfirmer(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setStateCommand(StateCommand.OK);
		sc.setStaterequest(true);
		surveillanceCommandRepository.save(sc);
	}

	@Override
	public SurveillanceCommand requestRetourCommand(Long idCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SurveillanceCommand responseRetourCommand(Long idCommand) {
		// TODO Auto-generated method stub
		return null;
	}


	


}
