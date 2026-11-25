package br.com.cotiinformatica.api_agenda.infrastructure.controllers;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
public class OpenAiController {

    @Autowired
    private ChatClient chatClient;

    @GetMapping()
    public String perguntar(@RequestParam String pergunta) {

        var resposta = chatClient.prompt()
                .system("Responda de forma clara e objetiva.")
                .user(pergunta)
                .call()
                .content();

        return resposta;
    }
}
