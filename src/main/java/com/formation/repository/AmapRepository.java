package com.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.AMAP;

@Repository
public interface AmapRepository extends JpaRepository<AMAP, Long>{

}