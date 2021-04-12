package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.spring.entity.Property;

public interface IPropertyRepository extends CrudRepository<Property,Integer>{

}
