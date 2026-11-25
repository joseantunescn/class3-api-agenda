package br.com.cotiinformatica.api_agenda.application.services;

import br.com.cotiinformatica.api_agenda.application.dtos.ContatoRequest;
import br.com.cotiinformatica.api_agenda.application.dtos.ContatoResponse;
import br.com.cotiinformatica.api_agenda.domain.entities.Contato;
import br.com.cotiinformatica.api_agenda.infrastructure.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public ContatoResponse criar(ContatoRequest contatoRequest) {
        var contato = new Contato();

        contato.setNome(contatoRequest.nome());
        contato.setEmail(contatoRequest.email());
        contatoRepository.save(contato);

        return toResponse(contato);

    }

    private ContatoResponse toResponse(Contato contato) {
        return new ContatoResponse(
                contato.getId(),
                contato.getNome(),
                contato.getEmail()
        );
    }

}
