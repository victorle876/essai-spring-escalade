package com.escalade.victor.controller;

import com.escalade.victor.model.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UtilisateurController {

    private List <Utilisateur> utilisateurs = new ArrayList<Utilisateur>() {{
        add(new Utilisateur(1, "Jack", "Smith", 32, "M", "jack.smith@yahoo.us"));
        add(new Utilisateur(2, "Jack", "Spvdc", 12, "M", "jack.smith2@yahoo.fr"));
        add(new Utilisateur(3, "Michel", "Spvdc", 29, "M", "michel.smith2@yahoo.fr"));
    }};

   /* private List <Utilisateur> utilisateurs = new ArrayList<Utilisateur>();*/

     private Utilisateur utilisateur2 = new Utilisateur();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("utilisateurs", this.utilisateurs);
        return "home.html";
    }


   @RequestMapping(value = "/add", method = RequestMethod.GET)
   public String ajouter (Model model) {

       model.addAttribute("utilisateur", utilisateur2);
        return "add.html";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String sauver (@Valid @ModelAttribute Utilisateur utilisateur2, Model model) {

        utilisateurs.add(utilisateur2);
        model.addAttribute("utilisateur", utilisateur2);
        return "add.html";
    }



    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String detail(@RequestParam(value = "id") Integer id, Model model) {
       // model.addAttribute("id", id);

        for (Utilisateur utilisateur : this.utilisateurs) {
            if (utilisateur.getId().equals(id)) {

               model.addAttribute("utilisateur", utilisateur);
               return "details.html";

            }
        }
          return null;

    }

/*   @RequestMapping(value = "/edition", method = RequestMethod.GET)
    public String edition(@RequestParam(value = "id") Integer id, Model model) {
        // model.addAttribute("id", id);

        for (Utilisateur utilisateur : this.utilisateurs) {
            if (utilisateur.getId().equals(id)) {
                utilisateurs.set(id-1, utilisateur);
                model.addAttribute("utilisateur", utilisateur);
                return "edition.html";

            }
        }
        return null;

    }*/
}
