package com.escalade.victor.controller;

import com.escalade.victor.model.Utilisateur;

import com.escalade.victor.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UtilisateurController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("utilisateurs", this.utilisateurRepository.findAll());
        return "home";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String ajouter(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "add";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute Utilisateur utilisateur, Model model, BindingResult result) {

        if (result.hasErrors()) {
            return "add";
        } else {
            this.utilisateurRepository.save(utilisateur);
            model.addAttribute("utilisateurs", this.utilisateurRepository.findAll());
            return "redirect:home";
        }
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String detail(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("utilisateur", this.utilisateurRepository.findById(id).get());
        return "details";

    }

    @RequestMapping(value = "/edition", method = RequestMethod.GET)
    public String edition(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("utilisateur", this.utilisateurRepository.findById(id).get());
        return "edition";

    }

    @RequestMapping(value = "/edition", method = RequestMethod.POST)
    public String edition2(@RequestParam(value = "id") long id, @Valid @ModelAttribute Utilisateur utilisateur, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "edition";
        } else {
        this.utilisateurRepository.save(utilisateur);
        model.addAttribute("utilisateurs", this.utilisateurRepository.findAll());
        return "redirect:/";
        }
    }


}
