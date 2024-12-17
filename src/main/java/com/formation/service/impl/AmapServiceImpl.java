package com.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.entities.AMAP;
import com.formation.repository.AmapRepository;
import com.formation.service.AmapService;

@Service
public class AmapServiceImpl implements AmapService{
	
	@Autowired
	private AmapRepository amapRepository;

	@Override
	public List<AMAP> findAll() {
		
		return amapRepository.findAll();
	}

	@Override
	public AMAP save(AMAP amap) {
		
		return amapRepository.save(amap);
	}

	@Override
	public AMAP findById(Long id) {
		
		return amapRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long Id) {

		amapRepository.deleteById(Id);
		
	}

}
