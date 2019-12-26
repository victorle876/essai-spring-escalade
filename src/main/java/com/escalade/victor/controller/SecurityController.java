package com.escalade.victor.controller;

import com.escalade.victor.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateur")
public class SecurityController {

    @GetMapping
    public ResponseEntity<Utilisateur> getUser(){

        Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return  new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
    }
}
