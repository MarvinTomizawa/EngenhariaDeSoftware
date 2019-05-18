package pessoa;

import java.util.UUID;

public abstract class Pessoa {
    private final UUID id;
    private String nome;


    public Pessoa(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
