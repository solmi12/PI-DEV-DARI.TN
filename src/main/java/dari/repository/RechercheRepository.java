package dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dari.entity.AnnonceImmobilier;
import dari.entity.RechercheAnnonce;


public interface RechercheRepository extends JpaRepository<RechercheAnnonce, Long> {
	
	
	
	@Query("select distinct A from AnnonceImmobilier A "
			+ "inner join RechercheAnnonce R "
			+ "on R.region = A.annonce_region "
			+ " where R.client_id = :id")
	public List<AnnonceImmobilier> getpub(@Param("id")long id) ;

}
