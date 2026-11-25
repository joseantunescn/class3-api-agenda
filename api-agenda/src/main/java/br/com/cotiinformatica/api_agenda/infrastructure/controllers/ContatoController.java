package br.com.cotiinformatica.api_agenda.infrastructure.controllers;

import br.com.cotiinformatica.api_agenda.application.dtos.ContatoRequest;
import br.com.cotiinformatica.api_agenda.application.dtos.ContatoResponse;
import br.com.cotiinformatica.api_agenda.application.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public ResponseEntity<ContatoResponse> post(@RequestBody ContatoRequest contatoRequest) {
        var response = contatoService.criar(contatoRequest);
        return ResponseEntity.status(201).body(response);
    }


}
