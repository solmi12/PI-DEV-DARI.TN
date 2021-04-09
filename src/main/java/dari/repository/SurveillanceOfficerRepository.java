package dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dari.entity.Surveillance;
import dari.entity.SurveillanceOfficer;

@Repository
public interface SurveillanceOfficerRepository extends JpaRepository<SurveillanceOfficer, Long> {
	
	/*@Query(value = "DELETE FROM surveillance s WHERE s.surveillance_officer_id_surveillance_officerIndex=?1" , nativeQuery=true)
	public void deleteSurveillanceOfficerAndtheirServeillance(Long id);*/
	
	public SurveillanceOfficer findByUserNameLike(String name);

}
