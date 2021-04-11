package dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.Client;
import dari.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository cr;
	
	public Client add(){
		Client c = new Client();
		return cr.save(c);
	}

}
