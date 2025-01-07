package fr.seve.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import fr.seve.entities.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long>{
	
	@Query("SELECT b FROM Box b WHERE b.amapSpace.id = :amapSpaceId")
	List<Box> findByAmapSpaceId(@Param("amapSpaceId")Long amapSpaceId);
}