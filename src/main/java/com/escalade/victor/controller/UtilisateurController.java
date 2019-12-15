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
    private List <Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("utilisateurs", this.utilisateurRepository.findAll());
        return "home.html";
    }


   @RequestMapping(value = "/add", method = RequestMethod.GET)
   public String ajouter (Model model) {
       model.addAttribute("utilisateur", new Utilisateur());
        return "add.html";
    }
    //

    //  utilisateur remplace par note

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String sauver (@Valid @ModelAttribute Utilisateur utilisateur2, Model model) {

        utilisateurs.add(utilisateur2);
        System.out.println(utilisateur2);
//        model.addAttribute("utilisateurs", this.utilisateurs);
        model.addAttribute("utilisateurs", this.utilisateurRepository.save(utilisateur2));
        return "home.html";
    }

    /*@RequestMapping(value = "/details", method = RequestMethod.GET)
    public String detail(@RequestParam(value = "id") Integer id, Model model) {*/
        @RequestMapping(value = "/details", method = RequestMethod.GET)
        public String detail(@RequestParam(value = "id") Long id, Model model) {

/*        for (Utilisateur utilisateur : this.utilisateurs) {
            if (utilisateur.getId().equals(id)) {

               model.addAttribute("utilisateur", utilisateur);
               return "details.html";

            }
        }
          return null;*/
        System.out.println(id);
        model.addAttribute("utilisateur", this.utilisateurRepository.findById(id));
        return "details.html";

    }

   @RequestMapping(value = "/edition", method = RequestMethod.GET)
//    public String edition(@RequestParam(value = "id") Integer id, Model model) {
      public String edition(@RequestParam(value = "id") Long id, Model model) {

/*        System.out.println(id);
        for (Utilisateur utilisateur : this.utilisateurs) {
            if (utilisateur.getId().equals(id)) {
                // utilisateurs.set(id-1, utilisateur);
                model.addAttribute("utilisateur", utilisateur);
                return "edition.html";

            }
        }
        return null;*/

       model.addAttribute("utilisateur", this.utilisateurRepository.findById(id));
       return "edition.html";

    }

    @RequestMapping(value = "/edition2", method = RequestMethod.POST)
//    public String edition2 (@RequestParam(value = "id") Integer id, @Valid @ModelAttribute Utilisateur utilisateur, BindingResult errors, Model model) {
      public String edition2 (@RequestParam(value = "id") int id, @Valid @ModelAttribute Utilisateur utilisateur, BindingResult errors, Model model) {
/*        System.out.println(utilisateur);
        for (Utilisateur u : this.utilisateurs) {
            if (u.getId().equals(id)) {
                this.utilisateurs.set(id-1, utilisateur);

                model.addAttribute("utilisateurs", this.utilisateurs);
                return "home.html";

            }
        }return null; 4*/


         this.utilisateurs.set(id-1, utilisateur);
         model.addAttribute("utilisateur", this.utilisateurRepository.save(utilisateur));
       return "home.html";
        }




    }
