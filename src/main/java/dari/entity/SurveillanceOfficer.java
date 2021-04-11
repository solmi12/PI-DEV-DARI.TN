package dari.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;


@Entity
public class SurveillanceOfficer implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSurveillanceOfficer;
	
	private String userName;
	
	@JoinTable(
    		name = "avoirAgent", 
    		joinColumns = {@JoinColumn( referencedColumnName = "idSurveillanceOfficer")})
    @MapKeyJoinColumn(name = "idClient")
    @ElementCollection
	private Map<Client,Double> avoirs ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="surveillanceOfficer")
	private List<Surveillance> Surveillances;

	public SurveillanceOfficer() {
		super();
		this.avoirs=new HashMap<>();
	}


	public SurveillanceOfficer(Long idSurveillanceOfficer, String userName) {
		super();
		this.idSurveillanceOfficer = idSurveillanceOfficer;
		this.userName = userName;
	}
	
	
	
	public SurveillanceOfficer(Long idSurveillanceOfficer, String userName, List<Surveillance> surveillances) {
		super();
		this.idSurveillanceOfficer = idSurveillanceOfficer;
		this.userName = userName;
		Surveillances = surveillances;
	}


	public SurveillanceOfficer(String userName) {
		super();
		this.userName = userName;
	}



	public Long getIdSurveillanceOfficer() {
		return idSurveillanceOfficer;
	}

	public void setIdSurveillanceOfficer(Long idSurveillanceOfficer) {
		this.idSurveillanceOfficer = idSurveillanceOfficer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public List<Surveillance> getSurveillances() {
		return Surveillances;
	}


	public void setSurveillances(List<Surveillance> surveillances) {
		Surveillances = surveillances;
	}


	public Map<Client, Double> getAvoirs() {
		return avoirs;
	}


	public void setAvoirs(Map<Client, Double> avoirs) {
		this.avoirs = avoirs;
	}
	
	

	
	


}
