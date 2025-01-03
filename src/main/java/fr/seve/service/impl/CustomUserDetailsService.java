package fr.seve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import fr.seve.entities.SaasUser;
import fr.seve.repository.SaasUserRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SaasUserRepository saasUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SaasUser saasUser = saasUserRepository.findByEmail(email)
              .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(
            saasUser.getEmail(),
            saasUser.getPassword(),
            getAuthorities(saasUser) // Récupère les autorités
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(SaasUser saasUser) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")); // Ajustez selon vos besoins en matière de rôles
    }
}

