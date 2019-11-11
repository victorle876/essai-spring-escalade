package com.escalade.victor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

@Controller
public class UtilisateurController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;


    @RequestMapping(value = "/saveUtilisateur", method = RequestMethod.POST)
    public String saveUtilisateur(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult errors, Model model) {
        if (!errors.hasErrors()) {
            // get mock objects
            //List<Utilisateur> utilisateurs = UtilisateurUtils.buildStudents();
            utilisateur.setFirst_Name(first_name);
            utilisateur.setFirst_Name(family_name);
            utilisateur.setDate_Naissance(date_naissance);
            utilisateur.setGender(gender);
            utilisateur.setMail(mail);
            utilisateur.setPassword(password);
            // add current utilisateur
            //utilisateurs.add(utilisateur);
            model.addAttribute("utilisateur", utilisateur);
        }
        return ((errors.hasErrors()) ? "addUtilisateur.html" : "listUtilisateur.html");
    }

    @RequestMapping(value = "/addUtilisateur", method = RequestMethod.GET)
    public String addUtilisateur (Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "addUtilisateur.html";
    }

    @RequestMapping(value = "/listUtilisateurs", method = RequestMethod.GET)
    public String listUtilisateurs(Model model) {

        model.addAttribute("utilisateur", UtilisateurUtils.buildUtilisateurs());

        return "listUtilisateur.html";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String listUtilisateur(Model model) {

        model.addAttribute("utilisateur", UtilisateurUtils.buildUtilisateurs());

        return "detail.html";
    }

}
