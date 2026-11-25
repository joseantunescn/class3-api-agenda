package br.com.cotiinformatica.api_agenda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ApiAgendaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Deve criar um contato com sucesso na API")
	void criarContatoTest() throws Exception {

		// arrange
		var request = """
				{
					"nome" : "Jose A C Neto",
					"email" : "antunes@gmail.com"
				}
				""";

		// act
		var response = mockMvc.perform(post("/api/v1/contato")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request));

		// assert
		response.andExpect(status().isCreated());
		response.andExpect(jsonPath("$.id").isNumber());
		response.andExpect(jsonPath("$.nome").value("Jose A C Neto"));
		response.andExpect(jsonPath("$.email").value("antunes@gmail.com"));

	}

}
