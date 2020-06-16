package unicesumar.segundoBimestre.forum;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import unicesumar.segundoBimestre.forum.entity.Livro;
import unicesumar.segundoBimestre.forum.repository.LivroRepository;

import java.util.ArrayList;
import java.util.UUID;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class LivroControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LivroRepository livroRepository;

    @Test
    void testandoGetAll() throws Exception {
        var livros = new ArrayList<Livro>(){{
            add(new Livro("Teste1", 10, "Autor1"));
            add(new Livro("Teste2", 30, "Autor2"));
            add(new Livro("Teste3", 90, "Autor1"));
        }};

        livroRepository.saveAll(livros);

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
        Livro existente = new Livro(UUID.fromString("afe5fddd-f774-4b9d-8914-e3d795c71895"),"Teste1", 10, "Autor1");

        livroRepository.save(existente);

        mockMvc.perform(get("/api/livros/afe5fddd-f774-4b9d-8914-e3d795c71895"))
                .andExpect(jsonPath("$.title").value("Teste1"))
                .andExpect(jsonPath("$.pageNumber").value(10))
                .andExpect(jsonPath("$.author").value("Autor1"))
                .andExpect(status().isOk());
    }

    @Test
    void testandoGetOneSemDadosNoBanco() throws Exception{
        mockMvc.perform(get("/api/livros/afe5fddd-f774-4b9d-8914-e3d795c71895"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testandoPostDadosValidos() throws Exception{
        Livro novo = new Livro("Teste1", 10, "Autor1");

        var object = objectMapper.writeValueAsString(novo);

        mockMvc.perform(post("/api/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testandoPostPaginasInvalidos() throws Exception{
        Livro novo = new Livro("Teste1", 0, "Autor1");

        var object = objectMapper.writeValueAsString(novo);

        mockMvc.perform(post("/api/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testandoPostTituloInvalido() throws Exception{
        Livro novo = new Livro("", 10, "Autor1");

        var object = objectMapper.writeValueAsString(novo);

        mockMvc.perform(post("/api/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testandoPostAuthorInvalido() throws Exception{
        Livro novo = new Livro("Teste 1", 10, "");

        var object = objectMapper.writeValueAsString(novo);

        mockMvc.perform(post("/api/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testandoPutTituloInvalido() throws Exception{
        var livroSalvo = livroRepository.save(new Livro("Teste2", 10, "Autor1"));
        UUID id = livroSalvo.getId();

        Livro atualizado = new Livro(id, "", 20, "Autor2");

        var object = objectMapper.writeValueAsString(atualizado);

        mockMvc.perform(put("/api/livros/" + id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testandoPutPageNumberInvalido() throws Exception{
        var livroSalvo = livroRepository.save(new Livro("Teste1", 20, "Autor1"));
        UUID id = livroSalvo.getId();

        Livro atualizado = new Livro(id, "Teste2", 0, "Autor2");

        var object = objectMapper.writeValueAsString(atualizado);

        mockMvc.perform(put("/api/livros/" + id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testandoPutAutorInvalido() throws Exception{
        var livroSalvo = livroRepository.save(new Livro("Teste1", 10, "Autor2"));
        UUID id = livroSalvo.getId();

        Livro atualizado = new Livro(id, "Teste2", 20, "");

        var object = objectMapper.writeValueAsString(atualizado);

        mockMvc.perform(put("/api/livros/" + id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testandoPutIdsDiferentes() throws Exception{
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Livro novo = new Livro(id1,"Teste1", 10, "Autor1");

        var object = objectMapper.writeValueAsString(novo);

        mockMvc.perform(put("/api/livros/" + id2.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isPreconditionFailed());
    }

    @Test
    void testandoPutDadosValidos() throws Exception{
        UUID id = UUID.randomUUID();
        Livro novo = new Livro(id, "Teste1", 10, "Autor1");

        var object = objectMapper.writeValueAsString(novo);

        mockMvc.perform(put("/api/livros/" + id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$").value(id.toString()));
    }

    @Test
    void testandoDeleteObjetoValido() throws Exception{
        var livroSalvo = livroRepository.save(new Livro("Teste1", 10, "Autor1"));
        UUID id = livroSalvo.getId();

        mockMvc.perform(delete("/api/livros/" + id.toString()))
                .andExpect(status().isAccepted());
    }

    @Test
    void testandoDeleteObjetoInvalido() throws Exception{
        UUID id = UUID.randomUUID();

        mockMvc.perform(delete("/api/livros/" + id.toString()))
                .andExpect(status().isNotFound());
    }

}
