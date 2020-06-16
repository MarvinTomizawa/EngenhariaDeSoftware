package unicesumar.segundoBimestre.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicesumar.segundoBimestre.forum.entity.Livro;
import unicesumar.segundoBimestre.forum.exception.LivroIdsDiferentException;
import unicesumar.segundoBimestre.forum.exception.LivroInvalidException;
import unicesumar.segundoBimestre.forum.exception.LivroNotFoundException;
import unicesumar.segundoBimestre.forum.repository.LivroRepository;

import java.util.List;
import java.util.UUID;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    public Livro getById(UUID id) {
        return livroRepository.findById(id).orElseThrow(LivroNotFoundException::new);
    }

    public UUID saveNewLivro(Livro livro) {
        validateLivro(livro);
        return livroRepository.save(livro).getId();
    }

    public UUID updateLivro(UUID id, Livro livro) {
        validateLivro(livro);
        return livroRepository.save(livro).getId();
    }

    public UUID deleteLivro(UUID uuid) {
        var livroDeletado = livroRepository.findById(uuid).orElseThrow(LivroNotFoundException::new);

        livroRepository.delete(livroDeletado);
        return uuid;
    }

    private void validateLivro(Livro livro){
        if(livro.getTitle().isEmpty()){
            throw new LivroInvalidException("Titulo");
        }

        if(livro.getPageNumber() <= 0){
            throw new LivroInvalidException("Numero de paginas");
        }

        if(livro.getAuthor().isEmpty()){
            throw new LivroInvalidException("Numero de paginas");
        }
    }
}
