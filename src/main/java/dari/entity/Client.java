package dari.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Client implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClient;
	
	private String username;
	
	
    @JoinTable(
    		name = "avoirClient", 
    		joinColumns = {@JoinColumn( referencedColumnName = "idClient")})
    @MapKeyJoinColumn(name = "idAgent")
    @ElementCollection
	private Map<SurveillanceOfficer,Double> avoirs ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private List<SurveillanceCommand> SurveillanceCommands;
	
	public Client() {
		super();
		this.avoirs=new HashMap<>();
	}

	public Client(Long idClient, String username, Collection<SurveillanceCommand> surveillanceCommands) {
		super();
		this.idClient = idClient;
		this.username = username;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	 
	public List<SurveillanceCommand> getSurveillanceCommands() {
		return SurveillanceCommands;
	}

	public void setSurveillanceCommands(List<SurveillanceCommand> surveillanceCommands) {
		SurveillanceCommands = surveillanceCommands;
	}

	public Map<SurveillanceOfficer, Double> getAvoirs() {
		return avoirs;
	}

	public void setAvoirs(Map<SurveillanceOfficer, Double> avoirs) {
		this.avoirs = avoirs;
	}
	
}


