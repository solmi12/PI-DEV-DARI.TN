package dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dari.entity.StateCommand;
import dari.entity.Surveillance;
import dari.entity.SurveillanceCommand;


@Repository
public interface SurveillanceCommandRepository extends JpaRepository<SurveillanceCommand, Long>{
	
	@Query(value="SELECT surveillance_officer.user_name FROM surveillance_officer "
			+ "INNER JOIN surveillance ON (surveillance_officer.id_surveillance_officer=surveillance.surveillance_officer_id_surveillance_officer)"
			+ "INNER JOIN ligne_command ON(surveillance.id_surveillance=ligne_command.id_surveillance)"
			+ "WHERE ligne_command.id_ligne_command=?1",nativeQuery=true)
	public String findProviderOfCommand(Long idLigneCommand);
	
	@Query(value="SELECT * FROM surveillance_command "
			+ "WHERE surveillance_command.client_id_client=?1 "
			+ "AND surveillance_command.state_command=?2 "
			+ "AND surveillance_command.staterequest=?3",nativeQuery=true)
	public List<SurveillanceCommand> afficherCommandClientByPara(Long idClient , StateCommand st , boolean staterequest);
	
	@Query(value="SELECT DISTINCT surveillance_command.code_commande FROM surveillance_command "
			+ "INNER JOIN ligne_command ON (surveillance_command.id_command=ligne_command.id_command)"
			+ "INNER JOIN surveillance ON(surveillance.id_surveillance=ligne_command.id_surveillance)"
			+ "WHERE (surveillance.surveillance_officer_id_surveillance_officer)=?1",nativeQuery=true)
	public List<String> trouverCodeCommandeAgent(Long idAgent);
	
	@Query(value="SELECT * FROM surveillance_command WHERE surveillance_command.code_commande=?1 "
			+ "AND surveillance_command.state_command=?2 "
			+ "AND surveillance_command.staterequest=?3",nativeQuery=true)
	public SurveillanceCommand afficherCommandAgentByPara(String codeCommand , StateCommand st , boolean staterequest);
	
	
}
