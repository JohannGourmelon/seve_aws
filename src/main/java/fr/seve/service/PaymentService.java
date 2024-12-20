package fr.seve.service;

import java.util.List;

import fr.seve.entities.Payment;


public interface PaymentService {

	
List<Payment> findAll();
	
	Payment save(Payment payment);
	
	Payment findById (Long id);
	
	void deleteById(Long Id);
}
