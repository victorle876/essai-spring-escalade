package com.escalade.victor.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static java.util.Arrays.*;

import java.util.Collection;

/*@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {*/

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*    @NotBlank(message = "Le nom est requis.")
    private String nom;*/

    @NotBlank(message = "Le nom est requis.")
    private String username;

    @NotBlank(message = "Le prenom est requis.")
    private String prenom;

    @NotNull(message = "L'âge est requis.")
    private Integer age;

    @NotBlank(message = "Le sexe est requis.")
    private String sexe;

    @NotBlank(message = "L'adresse mail est requis.")
    private String mail;

    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;

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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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