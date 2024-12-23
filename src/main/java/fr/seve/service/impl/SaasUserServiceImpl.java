package fr.seve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.seve.entities.AMAP;
import fr.seve.entities.AmapSpace;
import fr.seve.entities.SaasUser;
import fr.seve.repository.SaasUserRepository;
import fr.seve.service.AmapService;
import fr.seve.service.AmapSpaceService;
import fr.seve.service.SaasUserService;

@Service
public class SaasUserServiceImpl implements SaasUserService{

	//Injection de dépendance
	@Autowired // la plus simple
	private SaasUserRepository saasUserRepository;
	
	@Autowired 
	private AmapService amapService;
	
	@Autowired 
	private AmapSpaceService amapSpaceService;
	
	
	@Override
	public List<SaasUser> findAll() {
		
		return saasUserRepository.findAll();
	}

	@Override
	public SaasUser save(SaasUser saasUser) {
		
		return saasUserRepository.save(saasUser);
	}

	@Override
	public SaasUser findById(Long id) {
		
		return saasUserRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		saasUserRepository.deleteById(id);
		
	}

	@Override
	public void create(SaasUser saasUser) {
		AMAP amap = new AMAP();
	    amap.setSaasUser(saasUser);
	    amapService.save(amap);

	    saasUser.setAmap(amap);
	    save(saasUser);

	    AmapSpace amapSpace = new AmapSpace();
	    amapSpace.setAmap(amap);
	    amapSpaceService.save(amapSpace);
	}
	
	

}