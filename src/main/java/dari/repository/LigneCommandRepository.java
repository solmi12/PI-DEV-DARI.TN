package dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dari.entity.LigneCommand;


@Repository
public interface LigneCommandRepository extends JpaRepository<LigneCommand, Long>{
	
}
