package dari.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClient;
	
	private String username;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private List<SurveillanceCommand> SurveillanceCommands;
	
	public Client() {
		super();
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

	
	
	
	
	
}


