package com.esprit.spring.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entity.User;
import com.esprit.spring.service.IUserService;

@RestController
public class UserRestController {
	@Autowired
	private IUserService userService;
	
	// http://localhost:8087/SpringMVC/servlet/add-user
	@PostMapping("/add-user")
	@ResponseBody
	public User adduser(@RequestBody User user){
		userService.addUser(user);
		return user;
	}
	
	// http://localhost:8087/SpringMVC/servlet/display-all-user
	@GetMapping("/display-all-user")
	@ResponseBody
	public List<User> showUsers(){
		return userService.getAllUsers();
	}
	
	// http://localhost:8087/SpringMVC/servlet/del-user-by-id
    @DeleteMapping("/del-user-by-id/{id-user}")
	@ResponseBody
	public void deleteUserById(@PathVariable("id-user")int id) {
		userService.removeUser(id);
	}
    // http://localhost:8087/retrieve-user-by-id/{user-id}
	@GetMapping("/retrieve-user-by-id/{user-id}")
	@ResponseBody
	public Optional<User> retrieveUser(@PathVariable("user-id") int id){
	return userService.getUser(id);
	} 
	// http://localhost:8087/SpringMVC/servlet/update-user
	@PutMapping("/update-user")
	@ResponseBody
	public void updateUser(){
		User user=new User();
		userService.updateUsers(user , user.getUserId());
	}
 

 		 
 		 
 		 
 		 
 		 
 		 
 		 
 		 
}
