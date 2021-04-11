package dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dari.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback , Long> {


}
