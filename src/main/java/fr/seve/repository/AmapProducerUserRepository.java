package fr.seve.repository;

import fr.seve.entities.AmapWorksComitteeUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmapProducerUserRepository extends JpaRepository<AmapWorksComitteeUser, Long> {

}
