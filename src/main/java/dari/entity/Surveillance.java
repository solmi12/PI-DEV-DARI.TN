package dari.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Surveillance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSurveillance ; 
	
	private String providerName;
	
	private String capteur;
	
	private int resolution ;
	
	private int indiceProtection;
	
	private int porteeInfrarouge;
	
	private double price;
	
	private int jaime;
	
	private int jaimeplus;
	
	private CategorySurveillance categorySurveillance;
		
	@Temporal(TemporalType.DATE)
	private Date dateAdd;
	
	@ManyToOne
	private SurveillanceOfficer surveillanceOfficer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="surveillance")
	private List<SurveillanceNotice> SurveillanceNotices;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="surveillance")
	private List<LigneCommand> LigneCommands;
	
	public Surveillance(Long idSurveillance, String providerName, String capteur, int resolution, int indiceProtection,
			int porteeInfrarouge, double price, int like, int deslike, CategorySurveillance categorySurveillance,
			Date dateAdd) {
		super();
		this.idSurveillance = idSurveillance;
		this.providerName = providerName;
		this.capteur = capteur;
		this.resolution = resolution;
		this.indiceProtection = indiceProtection;
		this.porteeInfrarouge = porteeInfrarouge;
		this.price = price;
		this.jaime = like;
		this.jaimeplus = deslike;
		this.categorySurveillance = categorySurveillance;
		this.dateAdd = dateAdd;
	}
	
	public Surveillance() {
		super();
	}

	public Long getIdSurveillance() {
		return idSurveillance;
	}

	public void setIdSurveillance(Long idSurveillance) {
		this.idSurveillance = idSurveillance;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getCapteur() {
		return capteur;
	}

	public void setCapteur(String capteur) {
		this.capteur = capteur;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public int getIndiceProtection() {
		return indiceProtection;
	}

	public void setIndiceProtection(int indiceProtection) {
		this.indiceProtection = indiceProtection;
	}

	public int getPorteeInfrarouge() {
		return porteeInfrarouge;
	}

	public void setPorteeInfrarouge(int porteeInfrarouge) {
		this.porteeInfrarouge = porteeInfrarouge;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getLike() {
		return jaime;
	}

	public void setLike(int like) {
		this.jaime = like;
	}

	public int getDeslike() {
		return jaimeplus;
	}

	public void setDeslike(int deslike) {
		this.jaimeplus = deslike;
	}

	public CategorySurveillance getCategorySurveillance() {
		return categorySurveillance;
	}

	public void setCategorySurveillance(CategorySurveillance categorySurveillance) {
		this.categorySurveillance = categorySurveillance;
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public void setSurveillanceOfficer(SurveillanceOfficer surveillanceOfficer) {
		this.surveillanceOfficer = surveillanceOfficer;
	}
	
	
	/*public List<LigneCommand> getLigneCommands() {
		return LigneCommands;
	}*/

	
	
	


	
	
	
	
	

}
