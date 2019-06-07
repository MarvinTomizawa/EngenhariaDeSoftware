package repository;

import java.util.List;

public interface Repository<T> {
    void excluirTodos();
    void commit();
    void excluir(int id);
    void alterar(T objeto);
    List<T> obterTodas();
    void inserir(T objeto);
}
