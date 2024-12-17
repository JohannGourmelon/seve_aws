package com.formation.service;

import java.util.List;

import com.formation.entities.Adherent;

public interface AdherentService {
	
	List<Adherent> findAll();
	
	Adherent save(Adherent adherent);
	
	Adherent findById (Long id);
	
	void deleteById(Long Id);

}
