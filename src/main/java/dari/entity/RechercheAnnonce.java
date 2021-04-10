package dari.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RechercheAnnonce implements Serializable{

	


	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RECH_ID")
	private long rech_id;
	@Column(name="CLIENT_ID")
	private long client_id;
	@Column(name="REGION")
	@Enumerated(EnumType.STRING)
	private AnnonceRegion region;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getRech_id() {
		return rech_id;
	}
	
	public void setRech_id(long rech_id) {
		this.rech_id = rech_id;
	}
	public long getClient_id() {
		return client_id;
	}
	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}
	public AnnonceRegion getRegion() {
		return region;
	}
	public void setRegion(AnnonceRegion region) {
		this.region = region;
	}
	
	
	public RechercheAnnonce() {
		super();
	}
	public RechercheAnnonce(long rech_id, long client_id, AnnonceRegion region) {
		super();
		this.rech_id = rech_id;
		this.client_id = client_id;
		this.region = region;
	}
	
	public RechercheAnnonce(long client_id, AnnonceRegion region) {
		super();
		this.client_id = client_id;
		this.region = region;
	}
	public RechercheAnnonce(long client_id) {
		super();
		this.client_id = client_id;
	}
	
	
	
	

	
	
	
}
