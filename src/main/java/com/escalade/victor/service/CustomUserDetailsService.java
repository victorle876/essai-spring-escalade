package com.escalade.victor.service;

import java.util.Collection;

import com.escalade.victor.model.Utilisateur;
import com.escalade.victor.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository UtilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Utilisateur utilisateur = UtilisateurRepository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(utilisateur.getMail(), utilisateur.getPassword(),
                getAuthorities(utilisateur));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Utilisateur utilisateur) {
        String[] userRoles = utilisateur.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
