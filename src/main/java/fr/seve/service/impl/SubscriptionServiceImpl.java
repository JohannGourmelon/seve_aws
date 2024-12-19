package fr.seve.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.seve.entities.Subscription;
import fr.seve.repository.SubscriptionRepository;
import fr.seve.service.SubscriptionService;

@Service
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
	public List<Subscription> initialize(List<Subscription> subscriptions) {
		
		Subscription essential = new Subscription();
		Subscription standard = new Subscription();
		Subscription premium = new Subscription();
		
		essential.setName("Essentiel");
		essential.setDescription("Gestion des Paniers");
		essential.setPrice("9.99€/mois");
		essential.setSubscribeDate(LocalDateTime.now().toString());
		
		standard.setName("Standard");
		standard.setDescription("Gestion des Paniers et boutique en ligne");
		standard.setPrice("19.99€/mois");
		standard.setSubscribeDate(LocalDateTime.now().toString());
		
		premium.setName("Premium");
		premium.setDescription("Gestion des Paniers, boutique en ligne et ateliers");
		premium.setPrice("29.99€/mois");
		premium.setSubscribeDate(LocalDateTime.now().toString());
		System.out.println("Initialisation faite");
		
		subscriptionRepository.save(essential);
		System.out.println("Initialisation essential faite");
		subscriptionRepository.save(standard);
		System.out.println("Initialisation standard faite");
		subscriptionRepository.save(premium);
		System.out.println("Initialisation premium faite");
		return null;
		
	}

	

}
