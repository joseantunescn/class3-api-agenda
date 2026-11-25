package br.com.cotiinformatica.api_agenda.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "CONTATOS")
@Data
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String email;

    @ManyToMany(
            mappedBy = "contatos"
    )
    private List<Tarefa> tarefas;

}
