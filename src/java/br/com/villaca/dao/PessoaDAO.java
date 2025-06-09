package br.com.villaca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import br.com.villaca.model.Pessoa;

public class PessoaDAO {

    private final String url = "jdbc:mysql://localhost:3306/javaweb1";
    private final String user = "root";
    private final String password = "root";

    public void salvar(Pessoa pessoa) {
        // Implementar a lógica para salvar a pessoa no banco de dados
        // Exemplo: usar JDBC para inserir os dados na tabela 'pessoa'

        String sql = "INSERT INTO pessoa (nome, email, telefone) VALUES (?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getEmail());
            preparedStatement.setString(3, pessoa.getTelefone());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}


/*


package br.com.villaca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import br.com.villaca.model.Pessoa;

public class PessoaDAO {

    private final String url = "jdbc:postgresql://localhost:5432/javaweb1"; // PostgreSQL usa 'postgresql' e porta 5432
    private final String user = "postgres"; // seu usuário do PostgreSQL
    private final String password = "postgres"; // sua senha do PostgreSQL

    public void salvar(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, email, telefone) VALUES (?, ?, ?)";

        try {
            Class.forName("org.postgresql.Driver"); // driver PostgreSQL
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getEmail());
            preparedStatement.setString(3, pessoa.getTelefone());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



*/
