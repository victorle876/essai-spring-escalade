package com.escalade.victor.repository;

import com.escalade.victor.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

/*@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>  {

}*/
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query(" select username, password from Utilisateur u " +
            " where u.username = ?1")
    Optional<Utilisateur> findUserWithName(String username);

    Optional<Utilisateur> findByMail(String mail);

}
