package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.spring.entity.User;

public interface IUserRepository extends CrudRepository<User,Integer>{
	
	@Query("SELECT u FROM User u WHERE"
			+ "((u.email=:email and u.passWord=:passWord)"
			+ "or(u.phoneNumber=:phoneNumber and u.passWord=:passWord))")
	public User getUserByLoginParams(@Param("email")String email, @Param("passWord")String passWord,@Param("phoneNumber")int phoneNumber);
	

}
