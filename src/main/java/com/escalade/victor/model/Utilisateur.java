package com.escalade.victor.model;

public class Utilisateur {

    private static final long serialVersionUID = -8582553475226281591L;

    @NotNull(message = "Utilisateur ID is required.")
    @Min(value = 1000, message = "Utilisateur ID must be at least 4 digits.")
    private Integer id;

    //

    @NotNull(message = "Le prénom de l'utilisateur is requis.")
    private String first_name;

    @NotNull(message = " Le nom de famille est requis.")
    private String family_name;

    @NotNull(message = "Le sexe est requis.")
    private Character gender;

    private String date_naissance;

    private String mail;

    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_name;
    }

    public void setFirst_Name(String name) {
        this.first_name = first_name;
    }

    public String getFamily_Name() {
        return family_name;
    }

    public void setFamily_Name(String name) {
        this.family_name = family_name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }


    public String getDate_Naissance() {
        return Date_Naissance;
    }

    public void setDate_Naissance(String Date_Naissance) {
        this.date_naissance = date_naissance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
