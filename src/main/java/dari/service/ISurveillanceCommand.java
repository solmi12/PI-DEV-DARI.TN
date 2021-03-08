package dari.service;

import java.util.Collection;

import dari.entity.SurveillanceCommand;



public interface ISurveillanceCommand {
	
	public Collection<SurveillanceCommand> retrieveAllSurveillanceCommand();
	public SurveillanceCommand retrieveSurveillancerCommand(Long id);
	public SurveillanceCommand addSurveillanceCommand(SurveillanceCommand s);
	public void deleteSurveillanceCommand(Long id);
	public SurveillanceCommand updateCommand(SurveillanceCommand s);

}
