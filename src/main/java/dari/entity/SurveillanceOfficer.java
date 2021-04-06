package dari.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class SurveillanceOfficer implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSurveillanceOfficer;
	
	private String userName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="surveillanceOfficer")
	private List<Surveillance> Surveillances;

	public SurveillanceOfficer() {
		super();
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
	
	

	
	


}
