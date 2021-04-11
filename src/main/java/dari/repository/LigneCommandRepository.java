package dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dari.entity.LigneCommand;


@Repository
public interface LigneCommandRepository extends JpaRepository<LigneCommand, Long>{
	
	@Query("SELECT DISTINCT so.idSurveillanceOfficer FROM SurveillanceOfficer so "
			+ "JOIN so.Surveillances s "
			+ "JOIN s.LigneCommands lc "
			+ "WHERE lc.idLigneCommand=?1")
	public Long returnIdAgentByLigneCommande(Long idlc);
	
	
}
