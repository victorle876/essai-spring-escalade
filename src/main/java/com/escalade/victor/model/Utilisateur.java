package com.escalade.victor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static java.util.Arrays.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/*@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {*/

@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable , UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*    @NotBlank(message = "Le nom est requis.")
    private String nom;*/

    private String username;

    @NotBlank(message = "Le prenom est requis.")
    private String prenom;

    @NotNull(message = "L'âge est requis.")
    private Integer age;

    @NotBlank(message = "Le sexe est requis.")
    private String sexe;

    @NotBlank(message = "L'adresse mail est requis.")
    private String mail;

    private String password ;

/*    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;*/

    public Utilisateur() {

    }

/*//    public Utilisateur(Long id, String nom, String prenom, Integer age, String sexe, String mail) {
        public Utilisateur(Long id, String username, String prenom, Integer age, String sexe, String mail) {
        this.id = id;
//        this.nom = nom;
        this.username = username;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.mail = mail;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

/*    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    /*public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


/*    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", sexe='" + sexe + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + username + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", sexe='" + sexe + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}