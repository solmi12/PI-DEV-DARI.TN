package dari.entity;

import java.io.Serializable;
//import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import dari.entity.AnnonceImmobilier;
import dari.entity.Feedback;

@Entity
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClient;
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Collection<SurveillanceCommand> SurveillanceCommands;*/
	private String adresseEmail;
	@Column(name="tel")
	private long tel;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	@JsonManagedReference
	private Set<AnnonceImmobilier> AnnoncesImmobiliers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	@JsonManagedReference
	private List<Feedback> feedbacks;
	
	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getAdresseEmail() {
		return adresseEmail;
	}
	

	public Client(long idClient) {
		super();
		this.idClient = idClient;
	}

	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public Set<AnnonceImmobilier> getAnnoncesImmobiliers() {
		return AnnoncesImmobiliers;
	}

	public void setAnnoncesImmobiliers(Set<AnnonceImmobilier> annoncesImmobiliers) {
		AnnoncesImmobiliers = annoncesImmobiliers;
	}

	public Client(long idClient, String adresseEmail, long tel, Set<AnnonceImmobilier> annoncesImmobiliers,
			List<Feedback> feedbacks) {
		super();
		this.idClient = idClient;
		this.adresseEmail = adresseEmail;
		this.tel = tel;
		AnnoncesImmobiliers = annoncesImmobiliers;
		this.feedbacks = feedbacks;
	}

	public Client() {
		super();
	}
	
}
