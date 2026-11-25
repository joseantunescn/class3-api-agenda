package br.com.cotiinformatica.api_agenda.application.services;

import br.com.cotiinformatica.api_agenda.application.dtos.ContatoRequest;
import br.com.cotiinformatica.api_agenda.application.dtos.ContatoResponse;
import br.com.cotiinformatica.api_agenda.domain.entities.Contato;
import br.com.cotiinformatica.api_agenda.infrastructure.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Page<ContatoResponse> consultar(int pagina, int tamanho) {
        //Definir um tamanho máximo de 20
        if(tamanho > 20)
            tamanho = 20;

        //Criando a regra de paginação (pagina | tamanho | ordenação)
        var paginacao = PageRequest.of(pagina, tamanho, Sort.by("nome").ascending());

        //Executando a consulta no repositório e já copiar os dados
        //de cada contato obtido para um objeto ContatoResponse
        return contatoRepository.findAll(paginacao)
                .map(this::toResponse);


    }

    public ContatoResponse obterPorId(Integer id) {

        //Buscar o contato baseado no ID
        var contato = contatoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado."));

        //Retornar os dados
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
