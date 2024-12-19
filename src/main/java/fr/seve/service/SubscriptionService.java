package fr.seve.service;

import java.util.List;

import fr.seve.entities.Subscription;

public interface SubscriptionService {
	
	List<Subscription> findAll();
	
	Subscription findById(Long id);
	
	Subscription save(Subscription subscription);
	
	Subscription initialize(Subscription subscription);

}
