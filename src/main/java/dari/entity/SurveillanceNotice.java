package dari.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class SurveillanceNotice implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idNotice;
	
	private String description;
	
	@ManyToOne
	private Surveillance surveillance;
	
	public SurveillanceNotice() {
		super();
	}

	public SurveillanceNotice(String description) {
		super();	
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

	@JsonIgnore
	public Surveillance getSurveillance() {
		return surveillance;
	}

	public void setSurveillance(Surveillance surveillance) {
		this.surveillance = surveillance;
	}
	
	

	
	
	
	

}
