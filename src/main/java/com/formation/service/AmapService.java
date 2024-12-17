package com.formation.service;

import java.util.List;

import com.formation.entities.AMAP;


public interface AmapService {
	
List<AMAP> findAll();
	
	AMAP save(AMAP amap);
	
	AMAP findById (Long id);
	
	void deleteById(Long Id);

}
