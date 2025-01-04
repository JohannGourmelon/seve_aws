package fr.seve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.seve.entities.AMAP;
import fr.seve.entities.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long>{
	
}