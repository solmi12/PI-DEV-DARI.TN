package dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dari.entity.AnnonceImmobilier;
import dari.entity.AnnonceRegion;
import dari.entity.AnnonceType;
import dari.entity.TypeTransaction;

@Repository
public interface AnnonceRepository extends JpaRepository<AnnonceImmobilier, Long> {

	
	
		
@Query("select A from AnnonceImmobilier A where A.annonce_region = :region")
public List<AnnonceImmobilier> retrieveByRegion(@Param("region") AnnonceRegion region);


@Query("select A from AnnonceImmobilier A where A.annonce_type = :type ")
public List<AnnonceImmobilier> retrieveByType(@Param("type") AnnonceType type);

@Query("select A from AnnonceImmobilier A where A.annonce_type_trans = :typeTrans")
public List<AnnonceImmobilier> retrieveByTypeTrans(@Param("typeTrans")TypeTransaction typeTrans);

@Query("select A from AnnonceImmobilier A where A.annonce_prix < :prixMax ")
public List<AnnonceImmobilier> retrieveByPrixMax(@Param("prixMax")long prixMax);

@Query("select A from AnnonceImmobilier A where A.annonce_prix > :prixMin ")
public List<AnnonceImmobilier> retrieveByPrixMin(@Param("prixMin")long prixMin);

 @Query("select count(A) from AnnonceImmobilier A where A.annonce_region = :region ")
public long statByRegion(@Param("region") AnnonceRegion region);

@Query("select count(A) from AnnonceImmobilier A where A.annonce_type = :type")
public long statByType(@Param("type") AnnonceType type);

@Query("select count(A) from AnnonceImmobilier A where A.annonce_type_trans = :typeTrans")
long statByTypeTrans(@Param("typeTrans") TypeTransaction typeTrans);

/*@Query("select count(A) from AnnonceImmobilier A where A.annonce_prix < :prixMax")
long stateByPrixMax(@Param("PrixMax") long prixMax);

@Query("select count(A) from AnnonceImmobilier A where A.annonce_prix > :prixMin")
long stateByPrixMin(@Param("PrixMin") long prixMin);*/

@Query("select A from AnnonceImmobilier A")
List<AnnonceImmobilier> findAllAnnonces();


}
