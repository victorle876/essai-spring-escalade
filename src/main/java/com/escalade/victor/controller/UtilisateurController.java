package com.escalade.victor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.escalade.victor.*;
import com.escalade.victor.model.Utilisateur;

@Controller
public class UtilisateurController {

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveUtilisateur(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult errors, Model model) {
        if (!errors.hasErrors()) {
            // get mock objects
            List<Utilisateur> utilisateurs = UtilisateurUtils.buildStudents();
            // add current student
            utilisateurs.add(utilisateur);
            model.addAttribute("utilisateurs", utilisateurs);
        }
        return ((errors.hasErrors()) ? "addUtilistaeurs.html" : "listUtilisateurs.html");
    }

    @RequestMapping(value = "/addUtilisateur", method = RequestMethod.GET)
    public String addStudent(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "addUtilisateur.html";
    }

    @RequestMapping(value = "/listUtilisateur", method = RequestMethod.GET)
    public String listStudent(Model model) {

        model.addAttribute("utilisateur", UtilisateurUtils.buildUtilisateurs());

        return "listUtilisateur.html";
    }
	
	    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String listUtilisateur(Model model) {

        model.addAttribute("utilisateur", UtilisateurUtils.buildUtilisateurs());

        return "detail.html";
    }

}
