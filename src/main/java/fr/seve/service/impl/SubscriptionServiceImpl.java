package fr.seve.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.seve.entities.Subscription;
import fr.seve.repository.SubscriptionRepository;
import fr.seve.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired 
	private SubscriptionRepository subscriptionRepository;

	@Override
	public List<Subscription> findAll() {
		
		return subscriptionRepository.findAll();
	}

	@Override
	public Subscription findById(Long id) {
	
		return subscriptionRepository.findById(id).orElse(null);
	}

	@Override
	public Subscription save(Subscription subscription) {
		
		return subscriptionRepository.save(subscription);
	}

	@Override
	public Subscription initialize(Subscription subscription) {
		Subscription essential = new Subscription();
		Subscription standard = new Subscription();
		Subscription premium = new Subscription();
		
		essential.setName("Essentiel");
		essential.setDescription("Gestion des Paniers");
		essential.setPrice("9.99€/mois");
	//Mettre Function
		essential.setSubscribeDate(LocalDateTime.now().toString());
		subscriptionRepository.save(essential);
		
		
		
		return null;
	}

	

}
