package dari.entity;

import java.io.Serializable;
import java.util.Collection;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SurveillanceCommand implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCommand;
	
	@Temporal(TemporalType.DATE)
	private Date dateCammand;
	
	private double priceCommand;
	
	private double finalPriceCommand;
	
	private double discountprice;
	
	private String fournisseurCommand;
	
	private String description;
	
	private StateCommand stateCommand;
	
	private boolean staterequest;
	
	private String codeCommande;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="surveillanceCommand")
	private List<LigneCommand> ligneCommands ;
	
	@ManyToOne
	private Client client ;
	
	public SurveillanceCommand() {
		super();
	}

	public SurveillanceCommand(Long idCommand, Date dateCammand, double priceCommand, double finalPriceCommand,
			String fournisseurCommand, String description, StateCommand stateCommand, String codeCommande) {
		super();
		this.idCommand = idCommand;
		this.dateCammand = dateCammand;
		this.priceCommand = priceCommand;
		this.finalPriceCommand = finalPriceCommand;
		this.fournisseurCommand = fournisseurCommand;
		this.description = description;
		this.stateCommand = stateCommand;
		this.codeCommande = codeCommande;
	}

	public Long getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(Long idCommand) {
		this.idCommand = idCommand;
	}

	public Date getDateCammand() {
		return dateCammand;
	}

	public void setDateCammand(Date dateCammand) {
		this.dateCammand = dateCammand;
	}

	public double getPriceCommand() {
		return priceCommand;
	}

	public void setPriceCommand(double priceCommand) {
		this.priceCommand = priceCommand;
	}
	
	public double getFinalPriceCommand() {
		return finalPriceCommand;
	}

	public void setFinalPriceCommand(double finalPriceCommand) {
		this.finalPriceCommand = finalPriceCommand;
	}
	
	public double getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(double discountprice) {
		this.discountprice = discountprice;
	}

	public StateCommand getStateCommand() {
		return stateCommand;
	}

	public void setStateCommand(StateCommand stateCommand) {
		this.stateCommand = stateCommand;
	}
	
	@JsonIgnore
	public List<LigneCommand> getLigneCommands() {
		return ligneCommands;
	}

	public boolean isStaterequest() {
		return staterequest;
	}

	public void setStaterequest(boolean staterequest) {
		this.staterequest = staterequest;
	}

	public void setLigneCommands(List<LigneCommand> ligneCommands) {
		this.ligneCommands = ligneCommands;
	}

	/*public Client getClient() {
		return client;
	}*/

	public void setClient(Client client) {
		this.client = client;
	}

	public String getFournisseurCommand() {
		return fournisseurCommand;
	}

	public void setFournisseurCommand(String fournisseurCommand) {
		this.fournisseurCommand = fournisseurCommand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCodeCommande() {
		return codeCommande;
	}

	public void setCodeCommande(String codeCommande) {
		this.codeCommande = codeCommande;
	}
	
	
	
	
	
	

}
