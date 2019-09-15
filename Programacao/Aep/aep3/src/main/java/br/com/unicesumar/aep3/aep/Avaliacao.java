package br.com.unicesumar.aep3.aep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "nome")
    private String nome;

    @Column(name = "semestre")
    private int semstre;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemstre() {
        return semstre;
    }

    public void setSemstre(int semstre) {
        this.semstre = semstre;
    }
}
