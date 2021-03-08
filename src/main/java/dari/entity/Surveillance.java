package dari.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Surveillance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSurveillance ; 
	
	private String capteur;
	
	private int resolution ;
	
	private int indiceProtection;
	
	private int porteeInfrarouge;
	
	private double price;
	
	private boolean availability;
	
	@ManyToOne
	private SurveillanceOfficer agent;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="surveillance")
	private Collection<SurveillanceNotice> SurveillanceNotices;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<SurveillanceCommand> SurveillanceCommands;
	
	public Surveillance() {
		super();
	}

	public Surveillance(Long idSurveillance, String capteur, int resolution, int indiceProtection, int porteeInfrarouge,
			double price, boolean availability, SurveillanceOfficer agent,
			Collection<SurveillanceNotice> surveillanceNotices, Collection<SurveillanceCommand> surveillanceCommands) {
		super();
		this.idSurveillance = idSurveillance;
		this.capteur = capteur;
		this.resolution = resolution;
		this.indiceProtection = indiceProtection;
		this.porteeInfrarouge = porteeInfrarouge;
		this.price = price;
		this.availability = availability;
		this.agent = agent;
		SurveillanceNotices = surveillanceNotices;
		SurveillanceCommands = surveillanceCommands;
	}

	public Long getIdSurveillance() {
		return idSurveillance;
	}

	public void setIdSurveillance(Long idSurveillance) {
		this.idSurveillance = idSurveillance;
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

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public SurveillanceOfficer getAgent() {
		return agent;
	}

	public void setAgent(SurveillanceOfficer agent) {
		this.agent = agent;
	}

	public Collection<SurveillanceNotice> getSurveillanceNotices() {
		return SurveillanceNotices;
	}

	public void setSurveillanceNotices(Collection<SurveillanceNotice> surveillanceNotices) {
		SurveillanceNotices = surveillanceNotices;
	}

	public Collection<SurveillanceCommand> getSurveillanceCommands() {
		return SurveillanceCommands;
	}

	public void setSurveillanceCommands(Collection<SurveillanceCommand> surveillanceCommands) {
		SurveillanceCommands = surveillanceCommands;
	}
	
	

}
