package com.escalade.victor.controller;

import com.escalade.victor.exception.ResourceNotFoundException;
import com.escalade.victor.model.Utilisateur;
import com.escalade.victor.repository.UtilisateurRepository;
import org.springframework.stereotype.Controller;
/*import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/*@Controller
public class UtilisateurController {*/

    /*    private List <Utilisateur> utilisateurs = new ArrayList<Utilisateur>() {{
            add(new Utilisateur(1, "Jack", "Smith", 32, "M", "jack.smith@yahoo.us"));
            add(new Utilisateur(2, "Jack", "Spvdc", 12, "M", "jack.smith2@yahoo.fr"));
            add(new Utilisateur(3, "Michel", "Spvdc", 29, "M", "michel.smith2@yahoo.fr"));
        }};

       *//* private List <Utilisateur> utilisateurs = new ArrayList<Utilisateur>();*//*

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("utilisateurs", this.utilisateurs);
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
        model.addAttribute("utilisateurs", this.utilisateurs);
        return "home.html";
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

   @RequestMapping(value = "/edition", method = RequestMethod.GET)
    public String edition(@RequestParam(value = "id") Integer id, Model model) {
        // model.addAttribute("id", id);

        System.out.println(id);
        for (Utilisateur utilisateur : this.utilisateurs) {
            if (utilisateur.getId().equals(id)) {
                // utilisateurs.set(id-1, utilisateur);
                model.addAttribute("utilisateur", utilisateur);
                return "edition.html";

            }
        }
        return null;

    }

    @RequestMapping(value = "/edition2", method = RequestMethod.POST)
    public String edition2 (@RequestParam(value = "id") Integer id, @Valid @ModelAttribute Utilisateur utilisateur, BindingResult errors, Model model) {

        System.out.println(utilisateur);
        for (Utilisateur u : this.utilisateurs) {
            if (u.getId().equals(id)) {
                this.utilisateurs.set(id-1, utilisateur);

                model.addAttribute("utilisateurs", this.utilisateurs);
                return "home.html";

            }
        }return null;
        }*/
    @RestController
    @RequestMapping("/api")
    public class UtilisateurController {

        @Autowired
        UtilisateurRepository utilisateurRepository;

        @GetMapping("/utilisateurs")
        public List<Utilisateur> getAllUtilisateur() {
            return utilisateurRepository.findAll();
        }

        @PostMapping("/utilisateurs")
        public Utilisateur createNote(@Valid @RequestBody Utilisateur utilisateur) {
            return utilisateurRepository.save(utilisateur);
        }

        @GetMapping("/utilisateurs/{id}")
        public Utilisateur getNoteById(@PathVariable(value = "id") Long utilisateurId) {
            return utilisateurRepository.findById(utilisateurId)
                    .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));
        }

        @PutMapping("/utilisateurs/{id}")
        public Utilisateur updateUtilisateur(@PathVariable(value = "id") Long utilisateurId,
                               @Valid @RequestBody Utilisateur utilisateurDetails) {

            Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                    .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));

            utilisateur.setId(utilisateurDetails.getId());
            utilisateur.setNom(utilisateurDetails.getNom());
            utilisateur.setPrenom(utilisateurDetails.getPrenom());
            utilisateur.setSexe(utilisateurDetails.getSexe());
            utilisateur.setAge(utilisateurDetails.getAge());
            utilisateur.setMail(utilisateurDetails.getMail());
            utilisateur.setUpdatedAt(utilisateurDetails.getUpdatedAt());
            utilisateur.setCreatedAt(utilisateurDetails.getCreatedAt());

            Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
            return updatedUtilisateur;
        }

        @DeleteMapping("/utilisateurs/{id}")
        public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
            Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                    .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));

            utilisateurRepository.delete(utilisateur);

            return ResponseEntity.ok().build();
        }


    }
