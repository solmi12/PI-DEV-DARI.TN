package dari.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dari.entity.Surveillance;



@Repository
public interface SurveillanceRepository extends JpaRepository<Surveillance, Long> {
	
	@Query(value = "SELECT * FROM surveillance s WHERE s.capteur=?1" , nativeQuery=true)
	public Collection<Surveillance> searchByCapteur(String capteur);
	
	@Query(value = "SELECT * FROM surveillance s WHERE s.resolution=?1" , nativeQuery=true)
    public Collection<Surveillance> searchByResolution(int resolution);
	
	@Query(value = "SELECT * FROM surveillance s WHERE s.price BETWEEN ?1 and ?2" , nativeQuery=true)
	public Collection<Surveillance> searchSurveillanceByPrice(int Price1 , int Price2);


}
