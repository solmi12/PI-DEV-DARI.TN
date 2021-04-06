package dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dari.entity.LigneCommand;
import dari.entity.Surveillance;

@Repository
public interface LigneCommandRepository extends JpaRepository<LigneCommand, Long>{
	
	@Query(value = "DELETE FROM ligne_command lc WHERE lc.id_command=?1" , nativeQuery=true)
	public void deleteLigneCommandByCommand(Long idCommand);

}
