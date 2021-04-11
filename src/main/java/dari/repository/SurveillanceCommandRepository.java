package dari.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dari.entity.StateCommand;
import dari.entity.SurveillanceCommand;
import dari.entity.SurveillanceOfficer;


@Repository
public interface SurveillanceCommandRepository extends JpaRepository<SurveillanceCommand, Long>{
	
	@Query("SELECT DISTINCT so.userName FROM SurveillanceOfficer so "
			+ "JOIN so.Surveillances s "
			+ "JOIN s.LigneCommands lc "
			+ "WHERE lc.idLigneCommand=?1")
	public String findProviderOfCommand(Long idLigneCommand);
	
	@Query("SELECT sc FROM SurveillanceCommand sc "
			+ "WHERE sc.client=?1 "
			+ "AND sc.stateCommand=?2 "
			+ "AND sc.staterequest=?3")
	public List<SurveillanceCommand> afficherCommandClientByPara(Long idClient , StateCommand st , boolean staterequest);
	
	@Query(value="SELECT DISTINCT sc.codeCommande FROM SurveillanceCommand sc "
			+ " JOIN sc.ligneCommands lc "
			+ " JOIN lc.surveillance s"
			+ "WHERE s.surveillanceOfficer=?1",nativeQuery=true)
	public List<String> trouverCodeCommandeAgent(Long idAgent);
	
	@Query(value="SELECT sc FROM SurveillanceCommand sc "
			+ "WHERE sc.codeCommande=?1 "
			+ "AND sc.stateCommand=?2 "
			+ "AND sc.staterequest=?3",nativeQuery=true)
	public SurveillanceCommand afficherCommandAgentByPara(String codeCommand , StateCommand st , boolean staterequest);
	
	@Query("SELECT DISTINCT so FROM SurveillanceOfficer so "
			+ "JOIN so.Surveillances s "
			+ "JOIN s.LigneCommands lc "
			+ "JOIN lc.surveillanceCommand sc "
			+ "WHERE sc.idCommand=?1")
	public SurveillanceOfficer findOfficerOfCommand(Long idCommand);
	
}
