package br.com.zupacademy.ggwadera.casadocodigo.controller;

import br.com.zupacademy.ggwadera.casadocodigo.autor.Autor;
import br.com.zupacademy.ggwadera.casadocodigo.autor.AutorController;
import br.com.zupacademy.ggwadera.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.ggwadera.casadocodigo.autor.NovoAutorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutorController.class)
class AutorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private AutorRepository repository;

    @Test
    public void deveRetornarStatus200() throws Exception {
        NovoAutorDTO form = new NovoAutorDTO();
        form.setEmail("autor@email.com");
        form.setNome("Autor Autoria");
        form.setDescricao("Descrição do livro");
        mvc.perform(post("/autores").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(form)))
            .andExpect(status().isOk());
        verify(repository, times(1)).save(any(Autor.class));
    }

    @Test
    public void deveRetornarErro400ComValoresInvalido() throws Exception {
        NovoAutorDTO form = new NovoAutorDTO();
        mvc.perform(post("/autores").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(form)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.length()").value(greaterThan(0)));
        verify(repository, never()).save(any(Autor.class));
    }

}