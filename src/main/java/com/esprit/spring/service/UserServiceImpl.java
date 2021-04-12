package com.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.spring.entity.User;
import com.esprit.spring.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	//Basic CRUD Functions Implementations---------------------------------------------------------------------------
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return 0;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users =new ArrayList<>();      
		userRepository.findAll().forEach(users ::add); 
		return users;
	}

	@Override
	public int updateUsers(User user, int id) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return 0;
	}

	@Override
	public Optional<User> getUser(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	
	//JPQL Functions Implementation-----------------------------------------------------------------------

	@Override
	public User login(String email, String passWord, int phoneNumber) {
		// TODO Auto-generated method stub
		return userRepository.getUserByLoginParams(email, passWord, phoneNumber);
	}
}

