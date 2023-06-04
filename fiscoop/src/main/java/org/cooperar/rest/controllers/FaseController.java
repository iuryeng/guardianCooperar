package org.cooperar.rest.controllers;

import org.cooperar.domain.entites.Fase;
import org.cooperar.domain.services.FaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fases")
public class FaseController {

    private final FaseService faseService;

    @Autowired
    public FaseController(FaseService faseService) {
        this.faseService = faseService;
    }

    @PostMapping("/")
    public ResponseEntity<Fase> criarFase(@RequestBody Fase fase) {
        Fase novaFase = faseService.criarFase(fase);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFase);
    }

    // Outros métodos do controlador de fases, como obter uma fase por ID, atualizar fase, etc.
}
