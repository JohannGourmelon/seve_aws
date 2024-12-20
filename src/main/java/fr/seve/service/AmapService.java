package fr.seve.service;

import java.util.List;

import fr.seve.entities.AMAP;


public interface AmapService {
	
	List<AMAP> findAll();

	AMAP save(AMAP amap);

	AMAP findById(Long id);

	void deleteById(Long Id);

}
