package br.com.cotiinformatica.api_agenda.infrastructure.repositories;

import br.com.cotiinformatica.api_agenda.domain.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
