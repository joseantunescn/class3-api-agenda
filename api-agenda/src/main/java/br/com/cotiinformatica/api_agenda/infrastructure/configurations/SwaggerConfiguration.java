package br.com.cotiinformatica.api_agenda.infrastructure.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("API de Agenda de Contatos e Tarefas")
                        .version("v1")
                        .description("""
                            API REST desenvolvida com Java, Spring Boot e Spring Data
                            para gerenciamento de agenda de contatos e tarefas.

                            Projeto: api-agenda

                            Funcionalidades:
                            - Cadastro, edição, exclusão e consulta de contatos.
                            - Cadastro, edição, exclusão e consulta de tarefas.
                            - Associação de tarefas e contatos.
                            - Integração com IA para relatorios inteligentes.
                            
                            Projeto desenvolvido para fins educacionais
                            durante o curso Java WebDeveloper Fullstack
                            da COTI Informática.

                            Esta documentação apresenta os endpoints,
                            parâmetros, modelos de dados e respostas HTTP
                            disponibilizados pela aplicação.
                            """)
                        .contact(new Contact()
                                .name("COTI Informática")
                                .url("https://www.cotiinformatica.com.br")
                        )
                );
    }
}

