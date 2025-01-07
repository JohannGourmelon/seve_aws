package fr.seve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.seve.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}