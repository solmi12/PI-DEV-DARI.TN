package dari.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dari.entity.CategorySurveillance;
import dari.entity.Surveillance;




@Repository
public interface SurveillanceRepository extends JpaRepository<Surveillance, Long> {
	
	List<Surveillance> findByPriceBetween(double Price1 , double Price2);
	
	List<Surveillance> findByCategorySurveillanceLike(CategorySurveillance category);
	
	Surveillance findByProductNameLike(String name);
	
	Surveillance findByCodeSurveillanceLike(String code);
	
	@Query("SELECT s FROM Surveillance AS s ORDER BY s.price")
    List<Surveillance> SurveillanceByPriceAsc();
	
	@Query("SELECT s FROM Surveillance s ORDER BY s.price DESC")
     List<Surveillance> SurveillanceByPriceDesc();
	
	@Query("SELECT s FROM Surveillance s ORDER BY s.dateAdd DESC")
     List<Surveillance> SurveillanceByDate();
	
	@Query("SELECT s FROM Surveillance s ORDER BY s.jaime DESC")
    public List<Surveillance> SurveillanceByLike();



	
	
	



}
