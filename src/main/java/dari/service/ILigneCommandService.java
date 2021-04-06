package dari.service;


import dari.entity.LigneCommand;


public interface ILigneCommandService {
	
	public LigneCommand addLigneCommand(Long idSurveillance , int quantity);
	public LigneCommand updateLigneCommandBySurveillance(Long lc , Long idSurveillance);
	public LigneCommand updateLigneCommandByQuantity(Long lc , int quantity);
	public LigneCommand deleteLigneCommand(Long idLigneCommand);
	public LigneCommand retrieveLigneCommand(Long  SurveillanceId); 





}
