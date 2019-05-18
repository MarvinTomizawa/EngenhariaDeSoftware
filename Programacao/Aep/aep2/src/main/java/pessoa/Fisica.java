package pessoa;

import java.util.UUID;

public class Fisica extends Pessoa{
    private CPF cpf;
    private RG rg;

    public Fisica(UUID id, String nome, RG rg, CPF cpf) {
        super(id, nome);
        this.cpf = cpf;
        this.rg = rg;
    }

    public Fisica(String nome, RG rg, CPF cpf ) {
        super(nome);
        this.cpf = cpf;
        this.rg = rg;
    }

    public CPF getCpf() {
        return cpf;
    }

    public RG getRg() {
        return rg;
    }

}
