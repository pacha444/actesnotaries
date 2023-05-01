package com.econsan.actesnotaries.controller;

import com.econsan.actesnotaries.model.ActeNotaire;
import com.econsan.actesnotaries.service.ActeNotaireService;
import com.econsan.actesnotaries.service.impl.ActeNotaireServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actenotaire")
public class ActeNotaireController {

    private ActeNotaireServiceImpl acteNotaireService;

    public ActeNotaireController(ActeNotaireServiceImpl acteNotaireServiceimpl) {
        this.acteNotaireService = acteNotaireServiceimpl;
    }

    @PostMapping()
    public ResponseEntity<ActeNotaire> saveActeNotaire(@RequestBody ActeNotaire acteNotaire){
        return new ResponseEntity<ActeNotaire>(acteNotaireService.saveActeNotaire(acteNotaire), HttpStatus.CREATED);
    }

    // build update droitreel REST API
    // http://localhost:8080/api/actenotaire/1
    @PutMapping("{codeactenotaire}")
    public ResponseEntity<ActeNotaire> updateActeNotaire(@PathVariable("codeActeNotaire") Integer codeactenotaire,@RequestBody ActeNotaire acteNotaire){

        return new ResponseEntity<ActeNotaire>(acteNotaireService.saveFormaliteNatureActe(acteNotaire,codeactenotaire), HttpStatus.OK);
    }
}
