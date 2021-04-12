package com.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.spring.entity.Property;
import com.esprit.spring.repository.IPropertyRepository;

@Service
public class PropertyServiceImpl implements IPropertyService{

	@Autowired
	private IPropertyRepository propertyRepository;
	//Basic CRUD Functions Implementations---------------------------------------------------------------------------
	@Override
	public int addProperty(Property prop) {
		// TODO Auto-generated method stub
		propertyRepository.save(prop);
		return 0;
	}

	@Override
	public void removeProperty(int id) {
		// TODO Auto-generated method stub
		propertyRepository.deleteById(id);
	}

	@Override
	public List<Property> getAllProperties() {
		// TODO Auto-generated method stub
		List<Property> properties =new ArrayList<>();      
		propertyRepository.findAll().forEach(properties ::add); 
		return properties;
	}

	@Override
	public int updateProperties(Property prop, int id) {
		// TODO Auto-generated method stub
		propertyRepository.save(prop);
		return 0;
	}

	@Override
	public Optional<Property> getProperty(int id) {
		// TODO Auto-generated method stub
		return propertyRepository.findById(id);
	}

}
