package com.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import com.esprit.spring.entity.Property;

public interface IPropertyService {
	//Basic CRUD Functions---------------------------------------------------------------------------
	public int addProperty(Property prop);
	public void removeProperty(int id);
	public List<Property> getAllProperties();
	public int updateProperties(Property prop, int id);
	public Optional<Property> getProperty(int id);
	
	//JPQL functions---------------------------------------------------------------------------------

}
