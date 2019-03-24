package DBClasses;

import Interfaces.IOperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseClass implements IOperations {

    Connection conexao;

    public boolean ConnectDataBase(String usuario, String senha) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/DataBase_01";
            conexao = DriverManager.getConnection(url, usuario, senha);
            return true;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void Save(String nome, int matricula, String area) {

        String statement = "Insert into professores(nome, matricula, area)";
        statement += " VALUES (?,?,?)";
        try {
            PreparedStatement insert = conexao.prepareStatement(statement);
            insert.setString(1, nome);
            insert.setInt(2, matricula);
            insert.setString(3, area);
            int retorno = insert.executeUpdate();
            System.out.println("Registro retornado: " + retorno);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    @Override
    public void Delete(long id) {
        String statement = "DELETE FROM professores WHERE id=?";
        try {
            PreparedStatement delete = conexao.prepareStatement(statement);
            delete.setLong(1, id);
            int retorno = delete.executeUpdate();
            System.out.println("Registros apagados: " + retorno);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    @Override
    public void Update(Long id, String nome, int matricula, String area) {
        String statement = "UPDATE professores SET nome=?, matricula=?, area=? WHERE id=?";

        try {
            PreparedStatement update = conexao.prepareStatement(statement);
            update.setString(1, nome);
            update.setInt(2, matricula);
            update.setString(3, area);
            update.setLong(4, id);
            int retorno = update.executeUpdate();
            System.out.println("Registros atualizados: " + retorno);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

    }

    @Override
    public void Consult() {
        String statement = "SELECT * FROM professores";
        try {
            PreparedStatement query = conexao.prepareStatement(statement);
            ResultSet result = query.executeQuery();
            System.out.println("Professores: ");
            while (result.next()) {
                long id = result.getLong("id");
                String nome = result.getString("nome");
                int matricula = result.getInt("matricula");
                String area = result.getString("area");
                System.out.println(id + " - " + nome + " - " + matricula + " - " + area + ".");
            }
            result.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

    }

    public void CloseConection() {
        try {
            conexao.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

    }

}
