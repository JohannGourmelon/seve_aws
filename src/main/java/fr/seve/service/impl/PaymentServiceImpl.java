package fr.seve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.seve.entities.Payment;
import fr.seve.repository.PaymentRepository;

import fr.seve.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired // la plus simple
	private PaymentRepository paymentrepository;

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentrepository.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		// TODO Auto-generated method stub
		return paymentrepository.save(payment);
	}

	@Override
	public Payment findById(Long id) {
		// TODO Auto-generated method stub
		return paymentrepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long Id) {
		paymentrepository.deleteById(Id);
	}

}
