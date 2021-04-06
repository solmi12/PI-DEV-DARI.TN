package dari.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dari.entity.CategorySurveillance;
import dari.entity.Surveillance;




@Repository
public interface SurveillanceRepository extends JpaRepository<Surveillance, Long> {
	
	@Query(value = "SELECT * FROM surveillance s WHERE s.surveillance_officer_id_surveillance_officer=?1" , nativeQuery=true)
	public List<Surveillance> retrieveAllSurveillanceByOfficer(int officerId);
	
	List<Surveillance> findByPriceBetween(double Price1 , double Price2);
	
	List<Surveillance> findByCategorySurveillanceLike(CategorySurveillance category);
	
	List<Surveillance> findByProviderNameLike(String name);
	
	@Query(value = "SELECT * FROM surveillance s ORDER BY s.price" , nativeQuery=true)
    public List<Surveillance> SurveillanceByPriceAsc();
	
	@Query(value = "SELECT * FROM surveillance s ORDER BY s.price DESC" , nativeQuery=true)
    public List<Surveillance> SurveillanceByPriceDesc();
	
	@Query(value = "SELECT * FROM surveillance s ORDER BY s.date_add DESC" , nativeQuery=true)
    public List<Surveillance> SurveillanceByDate();
	
	@Query(value = "SELECT * FROM surveillance s ORDER BY s.jaime DESC" , nativeQuery=true)
    public List<Surveillance> SurveillanceByLike();



	
	
	



}
