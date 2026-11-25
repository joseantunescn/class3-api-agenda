package br.com.cotiinformatica.api_agenda.domain.entities;

import br.com.cotiinformatica.api_agenda.domain.enums.Categoria;
import br.com.cotiinformatica.api_agenda.domain.enums.Prioridade;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "TAREFAS")
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime hora;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Prioridade prioridade;

    @Column(nullable = false)
    private Boolean finalizado;

    @ManyToMany
    @JoinTable(
            name = "TAREFAS_CONTATOS",
            joinColumns = @JoinColumn(name = "contato_id")
    )
    private List<Contato> contatos;


}
