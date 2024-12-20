package fr.seve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.seve.entities.Payment;

public interface PaymentRepository extends JpaRepository <Payment, Long>{

}
