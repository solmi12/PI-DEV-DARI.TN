package dari.service;


import java.util.List;
import java.util.Map;

import dari.entity.Client;
import dari.entity.LigneCommand;
import dari.entity.StateCommand;
import dari.entity.SurveillanceCommand;
import dari.entity.SurveillanceOfficer;



public interface ISurveillanceCommandService {
	
	//##################################################################################
	
	public String generateCodeCommande(); //:)
	
	public List<LigneCommand> detailsCommand(Long idCommand); //:)
	
	public void removeCommand(Long idCommand);
	
	public boolean verifeCommand(List<LigneCommand> lc);
	
	//#################################### DISPLAY #####################################
	
	public List<SurveillanceCommand> displayCommandClientByState(Long idClient, StateCommand sc , boolean stateRequest);
	
	public List<SurveillanceCommand> displayCommandAgentByState(Long idAgent, StateCommand sc , boolean stateRequest);
	
	//#################################### DEVIS #######################################
	
    public SurveillanceCommand demandeDevis(List<LigneCommand> lc , Long idClient);
	
	public SurveillanceCommand ReponseDevis(Long idCommand , String description , double bonus);
	
	//#################################### COMMANDE #####################################
	
	public SurveillanceCommand requestPasseCommand(Long idCommand);
	
	public SurveillanceCommand responsePasseCommand(Long idCommand , String description);
	
	public void annulerPassCommand(Long idCommand);
	
	public void CommandConfirmer(Long idCommand);
	
	//#################################### AVOIRS #####################################
	
	public SurveillanceCommand requestRetourCommand(Long idCommand);
	
	public SurveillanceCommand responseRetourCommand(Long idCommand , String description , boolean avoir);
	
	public Map<SurveillanceOfficer, Double> AvoirClient(Long idCommand);
	
	public Map<Client, Double> AvoirAgent(Long idCommand);
	
}
