package fr.seve.service;

import java.util.List;

import fr.seve.entities.Box;


public interface BoxService {
	
	List<Box> findAll();

	Box save(Box box);

	Box findById(Long id);

	void deleteById(Long Id);

}
