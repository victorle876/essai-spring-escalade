package com.escalade.victor.model;

import java.util.ArrayList;
import java.util.List;

public class UtilisateursUtils {
   public List<Utilisateur> AfficherUtilisateur() {
       List<Utilisateur> utilisateurs = new ArrayList<>();


       Utilisateur utilisateur1 = new Utilisateur(1, "Jack", "Smith", 32, "M", "jack.smith@yahoo.fr");
       Utilisateur utilisateur2 = new Utilisateur(1, "Jack", "Spvdc", 12, "M", "jack.smith2@yahoo.fr");

        utilisateurs.add(utilisateur1);
        utilisateurs.add(utilisateur2);
        System.out.println("List 1......");
        for (Utilisateur temp : utilisateurs) {
            System.out.println(temp);
        }
        return utilisateurs;

   }
}

