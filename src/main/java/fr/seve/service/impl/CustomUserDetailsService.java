package fr.seve.service.impl;

import fr.seve.entities.SaasUser;
import fr.seve.repository.SaasUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final SaasUserRepository userRepository;

    public CustomUserDetailsService(SaasUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SaasUser saasUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec cet email : " + email));

        return User.builder()
                .username(saasUser.getEmail())
                .password(saasUser.getPassword())
                .authorities(Collections.emptyList()) // Ajouter les rôles ici si nécessaire
                .build();
    }
}
