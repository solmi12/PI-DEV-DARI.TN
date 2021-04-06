package dari.entity;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long idLigneCommand ;
	
	private double lignePrice;
	
	private double unitPrice;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn( name="idCommand")
	private SurveillanceCommand surveillanceCommand;
	
	@ManyToOne
	@JoinColumn(name="idSurveillance")
	private Surveillance surveillance;
	
	public LigneCommand() {
		super();
	}
	
	
	public LigneCommand(int quantity, Surveillance surveillance) {
		super();
		this.quantity = quantity;
		this.surveillance = surveillance;
		this.unitPrice=this.surveillance.getPrice();
		this.lignePrice=this.quantity*this.unitPrice;
	}


	public Long getIdLigneCommand() {
		return idLigneCommand;
	}
	public void setIdLigneCommand(Long idLigneCommand) {
		this.idLigneCommand = idLigneCommand;
	}
	public double getLignePrice() {
		return lignePrice;
	}
	
	public void setLignePrice(double lignePrice) {
		this.lignePrice = lignePrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@JsonIgnore
	public SurveillanceCommand getSurveillanceCommand() {
		return surveillanceCommand;
	}
	public void setSurveillanceCommand(SurveillanceCommand surveillanceCommand) {
		this.surveillanceCommand = surveillanceCommand;
	}
	
	
	public Surveillance getSurveillance() {
		return surveillance;
	}
	public void setSurveillance(Surveillance surveillance) {
		this.surveillance = surveillance;
	}
	
	
	
	
	


}
