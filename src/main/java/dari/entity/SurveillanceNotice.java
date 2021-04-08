package dari.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class SurveillanceNotice implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idNotice;
	
	private String description;
	
    private int jaime;
	
	private int jaimeplus;
	
	@ManyToOne
	private Surveillance surveillance;
	
	public SurveillanceNotice() {
		super();
	}

	public SurveillanceNotice(Long idNotice, String description) {
		super();
		this.idNotice = idNotice;
		this.description = description;
	}

	public Long getIdNotice() {
		return idNotice;
	}

	public void setIdNotice(Long idNotice) {
		this.idNotice = idNotice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getJaime() {
		return jaime;
	}

	public void setJaime(int jaime) {
		this.jaime = jaime;
	}

	public int getJaimeplus() {
		return jaimeplus;
	}

	public void setJaimeplus(int jaimeplus) {
		this.jaimeplus = jaimeplus;
	}

	public Surveillance getSurveillance() {
		return surveillance;
	}

	public void setSurveillance(Surveillance surveillance) {
		this.surveillance = surveillance;
	}
	
	

	
	
	
	

}
