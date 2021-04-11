package dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dari.entity.SurveillanceNotice;

@Repository
public interface SurveillanceNoticeRepository extends JpaRepository<SurveillanceNotice, Long>{
	

}
