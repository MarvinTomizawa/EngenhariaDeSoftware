package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T> {

    Repository(){
        try {
            Connection connection = iniciaConeccao();
            criaTabela(connection);
            finalizaConeccao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection iniciaConeccao() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://192.168.99.100:5432/aep",
                "marvin",
                "docker");
    }

    private void finalizaConeccao(Connection connection) throws SQLException{
        connection.close();
    }

    public final void inserir(T objeto){
        try {
            Connection connection = iniciaConeccao();
            inserirSql(connection, objeto);
            finalizaConeccao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final List<T> obterTodas(){
        List<T> objetos = new ArrayList<>();
        try {
            Connection connection = iniciaConeccao();
            objetos = obterTodasSql(connection);
            finalizaConeccao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public final void alterar(T objeto) {
        try {
            Connection connection = iniciaConeccao();
            alterarSql(connection,objeto);
            finalizaConeccao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final void excluir(int id) {
        try {
            Connection connection = iniciaConeccao();
            excluirSql(connection,id);
            finalizaConeccao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    abstract void inserirSql(Connection connection, T objeto);
    abstract void criaTabela(Connection connection);
    abstract List<T> obterTodasSql(Connection connection);
    abstract void alterarSql(Connection connection, T objeto);
    abstract void excluirSql(Connection connection, int id);

}