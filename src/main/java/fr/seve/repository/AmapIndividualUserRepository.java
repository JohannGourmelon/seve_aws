package fr.seve.repository;

import fr.seve.entities.AmapIndividualUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmapIndividualUserRepository extends JpaRepository<AmapIndividualUser, Long> {

	List<AmapIndividualUser> findByAmapSpaceId(Long amapSpaceId);

}
