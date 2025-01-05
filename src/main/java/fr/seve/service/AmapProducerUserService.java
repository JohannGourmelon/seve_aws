package fr.seve.service;

import fr.seve.entities.AmapProducerUser;
import java.util.List;

public interface AmapProducerUserService extends AmapUserService {
    AmapProducerUser createProducerUser(AmapProducerUser amapProducerUser, Long amapSpaceId);
    AmapProducerUser updateProducerUser(AmapProducerUser amapProducerUser);
    void deleteProducerUser(Long id);
    List<AmapProducerUser> findByAmapSpaceId(Long amapSpaceId);
}
