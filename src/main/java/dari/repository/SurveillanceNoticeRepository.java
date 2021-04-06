package dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dari.entity.SurveillanceNotice;

@Repository
public interface SurveillanceNoticeRepository extends JpaRepository<SurveillanceNotice, Long>{
	
	@Query(value = "SELECT * FROM surveillance_notice sn WHERE sn.surveillance_id_surveillance=?1" , nativeQuery=true)
	List<SurveillanceNotice> retrieveAllSurveillanceNoticeBySurveillance(long surveillanceId);

}
