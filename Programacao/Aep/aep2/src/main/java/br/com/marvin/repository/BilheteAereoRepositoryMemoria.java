package br.com.marvin.repository;

import br.com.marvin.entity.BilheteAereo;
import br.com.marvin.exception.BilheteAereoNotFound;

import java.util.ArrayList;
import java.util.List;

public class BilheteAereoRepositoryMemoria implements Repository<BilheteAereo> {

    private List<BilheteAereo> repositoryList;

    public BilheteAereoRepositoryMemoria() {
        this.repositoryList = new ArrayList<>();
    }

    @Override
    public void excluirTodos() {
        this.repositoryList.clear();
    }

    @Override
    public void excluir(int id) {
        BilheteAereo bilheteRemovido = this.repositoryList.stream()
                .filter(bilheteAereo -> bilheteAereo.getId().equals(id))
                .findAny().orElseThrow(BilheteAereoNotFound::new);
        this.repositoryList.remove(bilheteRemovido);
    }

    @Override
    public void alterar(BilheteAereo objeto) {
        excluir(objeto.getId());
        inserir(objeto);
    }

    @Override
    public List<BilheteAereo> obterTodas() {
        return new ArrayList<>(this.repositoryList);
    }

    @Override
    public void inserir(BilheteAereo objeto) {
        this.repositoryList.add(objeto);
    }
}
