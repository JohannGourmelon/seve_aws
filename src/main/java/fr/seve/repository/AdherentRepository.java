package fr.seve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.seve.entities.Adherent;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {

}
