package br.com.cotiinformatica.api_agenda.infrastructure.repositories;

import br.com.cotiinformatica.api_agenda.domain.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
