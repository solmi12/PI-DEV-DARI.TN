package com.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import com.esprit.spring.entity.User;

public interface IUserService {
	//Basic CRUD Functions---------------------------------------------------------------------------
	public int addUser(User user);
	public void removeUser(int id);
	public List<User> getAllUsers();
	public int updateUsers(User user, int id);
	public Optional<User> getUser(int id);
	
	//JPQL functions---------------------------------------------------------------------------------
	public User login(String email, String passWord ,int phoneNumber);

}
