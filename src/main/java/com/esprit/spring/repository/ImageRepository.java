package com.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.esprit.spring.entity.ImageModel;
@Service
public interface ImageRepository extends JpaRepository<ImageModel, Long>{
	
	 Optional<ImageModel> findByName(String name);

}
