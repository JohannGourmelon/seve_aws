package fr.seve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.seve.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
