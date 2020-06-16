package unicesumar.segundoBimestre.forum.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Livro {

    protected Livro(){}

    public Livro(String title, int pageNumber, String author) {
        this.title = title;
        this.pageNumber = pageNumber;
        this.author = author;
    }

    public Livro(UUID id, String title, int pageNumber, String author) {
        this.id = id;
        this.title = title;
        this.pageNumber = pageNumber;
        this.author = author;
    }

    @Id
    private UUID id = UUID.randomUUID();

    private String title;

    private int pageNumber;

    private String author;
}
