package unicesumar.segundoBimestre.forum;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import unicesumar.segundoBimestre.forum.controller.LivrosController;
import unicesumar.segundoBimestre.forum.entity.Livro;
import unicesumar.segundoBimestre.forum.exception.LivroInvalidException;
import unicesumar.segundoBimestre.forum.exception.LivroNotFoundException;
import unicesumar.segundoBimestre.forum.service.LivroService;

import java.util.ArrayList;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LivrosController.class)
@AutoConfigureMockMvc
public class LivroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LivroService livroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testandoGetAll() throws Exception {
        var livros = new ArrayList<Livro>(){{
            add(new Livro("Teste1", 10, "Autor1"));
            add(new Livro("Teste2", 30, "Autor2"));
            add(new Livro("Teste3", 90, "Autor1"));
        }};

        when(livroService.getAll()).thenReturn(livros);

        mockMvc.perform(get("/api/livros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.[0].id").isNotEmpty())
                .andExpect(jsonPath("$.[1].id").isNotEmpty())
                .andExpect(jsonPath("$.[2].id").isNotEmpty())
                .andExpect(jsonPath("$.[0].title").value("Teste1"))
                .andExpect(jsonPath("$.[1].title").value("Teste2"))
                .andExpect(jsonPath("$.[2].title").value("Teste3"))
                .andExpect(jsonPath("$.[0].author").value("Autor1"))
                .andExpect(jsonPath("$.[1].author").value("Autor2"))
                .andExpect(jsonPath("$.[2].author").value("Autor1"));
    }

    @Test
    void testandoGetByIdComDadoExistente() throws Exception {
        Livro existente = new Livro("Teste1", 10, "Autor1");

        when(livroService.getById(any())).thenReturn(existente);

        mockMvc.perform(get("/api/livros/afe5fddd-f774-4b9d-8914-e3d795c71895"))
                .andExpect(jsonPath("$.title").value("Teste1"))
                .andExpect(jsonPath("$.pageNumber").value(10))
                .andExpect(jsonPath("$.author").value("Autor1"))
                .andExpect(status().isOk());
    }

    @Test
    void testandoGetOneSemDadosNoBanco() throws Exception{
        when(livroService.getById(any())).thenThrow(LivroNotFoundException.class);

        mockMvc.perform(get("/api/livros/afe5fddd-f774-4b9d-8914-e3d795c71895"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testandoPostDadosValidos() throws Exception{
        UUID newUuid = UUID.randomUUID();
        Livro novo = new Livro("Teste1", 10, "Autor1");

        var object = objectMapper.writeValueAsString(novo);

        when(livroService.saveNewLivro(any())).thenReturn(newUuid);

        mockMvc.perform(post("/api/livros")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(object))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value(newUuid.toString()));
    }

    @Test
    void testandoPostDadosInvalidos() throws Exception{
        Livro novo = new Livro("Teste1", 0, "Autor1");

        var object = objectMapper.writeValueAsString(novo);

        when(livroService.saveNewLivro(any())).thenThrow(LivroInvalidException.class);

        mockMvc.perform(post("/api/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testandoPutDadosInvalidos() throws Exception{
        UUID id = UUID.randomUUID();
        Livro novo = new Livro("Teste1", 0, "Autor1");
        novo.setId(id);

        var object = objectMapper.writeValueAsString(novo);

        when(livroService.updateLivro(any(), any())).thenThrow(LivroInvalidException.class);

        mockMvc.perform(put("/api/livros/" + id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testandoPutIdsDiferentes() throws Exception{
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Livro novo = new Livro("Teste1", 0, "Autor1");
        novo.setId(id1);

        var object = objectMapper.writeValueAsString(novo);

        when(livroService.updateLivro(any(), any())).thenThrow(LivroInvalidException.class);

        mockMvc.perform(put("/api/livros/" + id2.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isPreconditionFailed());
    }

    @Test
    void testandoPutDadosValidos() throws Exception{
        UUID id = UUID.randomUUID();
        Livro novo = new Livro("Teste1", 10, "Autor1");
        novo.setId(id);

        var object = objectMapper.writeValueAsString(novo);

        when(livroService.updateLivro(any(), any())).thenReturn(id);

        mockMvc.perform(put("/api/livros/" + id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$").value(id.toString()));
    }

    @Test
    void testandoDeleteObjetoValido() throws Exception{
        UUID id = UUID.randomUUID();

        mockMvc.perform(delete("/api/livros/" + id.toString()))
                .andExpect(status().isAccepted());
    }

    @Test
    void testandoDeleteObjetoInvalido() throws Exception{
        UUID id = UUID.randomUUID();

        when(livroService.deleteLivro(any())).thenThrow(LivroNotFoundException.class);

        mockMvc.perform(delete("/api/livros/" + id.toString()))
                .andExpect(status().isNotFound());
    }
}
