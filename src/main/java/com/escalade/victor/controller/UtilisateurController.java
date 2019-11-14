package com.escalade.victor.controller;

import com.escalade.victor.model.Utilisateur;
import com.escalade.victor.model.UtilisateursUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UtilisateurController {

    //private Object UtilisateursUtils;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home (Model model) {

        List<Utilisateur> utilisateurs = new ArrayList<>();
        Utilisateur utilisateur1 = new Utilisateur(1, "Jack", "Smith", 32, "M", "jack.smith@yahoo.fr");
        Utilisateur utilisateur2 = new Utilisateur(1, "Jack", "Spvdc", 12, "M", "jack.smith2@yahoo.fr");
        utilisateurs.add(utilisateur1);
        utilisateurs.add(utilisateur2);
        model.addAttribute("utilisateurs", utilisateurs);

        return "home.html";
    }

}
