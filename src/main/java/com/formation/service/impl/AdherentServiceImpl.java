package com.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.entities.Adherent;
import com.formation.repository.AdherentRepository;
import com.formation.service.AdherentService;

@Service
public class AdherentServiceImpl implements AdherentService{

	//Injection de dépendance
	@Autowired // la plus simple
	private AdherentRepository adherentRepository;
	
	
	@Override
	public List<Adherent> findAll() {
		
		return adherentRepository.findAll();
	}

	@Override
	public Adherent save(Adherent adherent) {
		
		return adherentRepository.save(adherent);
	}

	@Override
	public Adherent findById(Long id) {
		
		return adherentRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		adherentRepository.deleteById(id);
		
	}
	
	

}