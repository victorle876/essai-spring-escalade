package com.escalade.victor.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * Simple student POJO with few fields
 *
 */
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = -8582553475226281591L;

    @NotNull(message = "Utilisateur ID is required.")
    @Min(value = 1000, message = "Utilisateur ID must be at least 4 digits.")
    private Integer id;

    @NotNull(message = "Utilisateur name is requis.")
    private String first_name;
	
	@NotNull(message = "Utilisateur name est requis.")
    private String family_name;

    @NotNull(message = "Utilisateur gender is required.")
    private Character gender;
	
	private String Date_Naissance;
	
	private String mail;
	
	private String Password;
	

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
        this.Date_Naissance = Date_Naissance;
    }
	
	public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
	
		public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
