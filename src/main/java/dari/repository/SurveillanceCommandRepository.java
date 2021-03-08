package dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dari.entity.SurveillanceCommand;


@Repository
public interface SurveillanceCommandRepository extends JpaRepository<SurveillanceCommand, Long>{

}
