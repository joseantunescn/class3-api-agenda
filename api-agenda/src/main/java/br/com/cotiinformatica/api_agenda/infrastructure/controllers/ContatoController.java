package br.com.cotiinformatica.api_agenda.infrastructure.controllers;

import br.com.cotiinformatica.api_agenda.application.dtos.ContatoRequest;
import br.com.cotiinformatica.api_agenda.application.dtos.ContatoResponse;
import br.com.cotiinformatica.api_agenda.application.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping()
    public ResponseEntity<Page<ContatoResponse>> getAll(
            @RequestParam(name = "pagina", defaultValue = "0") int pagina,
            @RequestParam(name = "tamanho", defaultValue = "20") int tamanho
    ) {
        var response = contatoService.consultar(pagina, tamanho);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponse> getById(@PathVariable Integer id) {
        var response = contatoService.obterPorId(id);
        return ResponseEntity.status(200).body(response);

    }


}
