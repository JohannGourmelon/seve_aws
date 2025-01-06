package fr.seve.repository;

import fr.seve.entities.AmapIndividualUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmapWorksComitteeUserRepository extends JpaRepository<AmapIndividualUser, Long> {

}
