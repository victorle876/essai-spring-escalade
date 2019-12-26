package com.escalade.victor.service;
import com.escalade.victor.model.Utilisateur;
import com.escalade.victor.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class UtilisateurService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        Utilisateur utilisateur = utilisateurRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return (UserDetails) utilisateur;
    }

}
