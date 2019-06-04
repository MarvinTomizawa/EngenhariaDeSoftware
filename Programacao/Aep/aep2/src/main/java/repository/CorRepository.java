package repository;

import entity.Cor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorRepository extends Repository<Cor>{

    @Override
    void criaTabela(Connection connection) {
        String sql = "create table if not exists cor ("
                + "id integer not null primary key,"
                + "nome varchar(255) not null unique,"
                + ")";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void inserirSql(Connection connection, Cor objeto) {
        String sql = "insert into cor(id,nome) values (?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,objeto.getId());
            statement.setString(2,objeto.getNome());
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    List<Cor> obterTodasSql(Connection connection) {
        List<Cor> cores = new ArrayList<>();

        String sql = "select id, nome from cor";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            statement.close();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cor = resultSet.getString("cor");
                cores.add(new Cor(id, cor));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cores;
    }

    @Override
    void alterarSql(Connection connection, Cor objeto) {
        String sql = "update cor set nome = ? where id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,objeto.getNome());
            statement.setInt(2,objeto.getId());
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void excluirSql(Connection connection, int id) {
        String sql = "delete cor where id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
