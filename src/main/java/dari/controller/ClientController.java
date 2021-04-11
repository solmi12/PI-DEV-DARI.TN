package dari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import dari.entity.Client;
import dari.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService cs;
	
	@PostMapping("/addClient") 
	@ResponseBody
	public Client addClient() { 
    
		
		return cs.add();
	
	}
}
