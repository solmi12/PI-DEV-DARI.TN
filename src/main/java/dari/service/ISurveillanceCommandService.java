package dari.service;


import java.util.List;

import dari.entity.LigneCommand;
import dari.entity.StateCommand;
import dari.entity.SurveillanceCommand;



public interface ISurveillanceCommandService {
	
	//##################################################################################
	
	public String generateCodeCommande();
	
	public List<LigneCommand> detailsCommand(Long idCommand);
	
	public void removeCommand(Long idCommand);
	
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
	
	public SurveillanceCommand responseRetourCommand(Long idCommand);
	
}
