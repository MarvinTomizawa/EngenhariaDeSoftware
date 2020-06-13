package unicesumar.segundoBimestre.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import unicesumar.segundoBimestre.forum.entity.Livro;
import unicesumar.segundoBimestre.forum.exception.LivroIdsDiferentException;
import unicesumar.segundoBimestre.forum.service.LivroService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/livros")
public class LivrosController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAll()
    {
        return livroService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro getOne(@PathVariable("id")UUID id ){
        return livroService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID post(@RequestBody Livro livro){
        return livroService.saveNewLivro(livro);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UUID put(@RequestBody Livro livro, @PathVariable("id") UUID id){
        if(!id.equals(livro.getId())){
            throw new LivroIdsDiferentException();
        }
        return livroService.updateLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") UUID uuid){
        livroService.deleteLivro(uuid);
    }
}
