package fr.seve.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.seve.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
//	@Query("SELECT o FROM Order o WHERE o.amapSpace.id = :amapSpaceId")
//	List<Order> findByAmapSpaceId(@Param("amapSpaceId")Long amapSpaceId);
}