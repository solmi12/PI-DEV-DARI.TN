package dari.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valeurs implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idValeur")
	private Long idValeur;
	
	@Column
    @ElementCollection(targetClass=Long.class)
	private List<Long> valeurs;

	public Long getIdValeur() {
		return idValeur;
	}

	public void setIdValeur(Long idValeur) {
		this.idValeur = idValeur;
	}

	public List<Long> getValeurs() {
		return valeurs;
	}

	public void setValeurs(List<Long> valeurs) {
		this.valeurs = valeurs;
	}

	public Valeurs() {
		super();
		this.valeurs=new ArrayList<>();
	}
	
	

}
