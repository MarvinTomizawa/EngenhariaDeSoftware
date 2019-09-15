package br.com.unicesumar.aep3.aep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "aluno")
public class Aluno {

    private UUID uuid = UUID.randomUUID();

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "nome")
    private String nome;

    public String getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
