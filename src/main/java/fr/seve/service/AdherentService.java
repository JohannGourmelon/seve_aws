package fr.seve.service;

import java.util.List;

import fr.seve.entities.Adherent;

public interface AdherentService {
	
	List<Adherent> findAll();
	
	Adherent save(Adherent adherent);
	
	Adherent findById (Long id);
	
	void deleteById(Long Id);

}
