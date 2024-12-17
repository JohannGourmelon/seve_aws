package com.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.Adherent;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {

}
