package model;

// import controller.*;

import java.sql.*;

public class TelaDeLoginModel {
    public static int logarModel(String login, String senha) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + login + "' and `senha` = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) { // Verifica a existência de um usuário com determinado e-mail em um banco de dados.
                return 0;
            } else { // Verifica se o login é válido. Caso não seja, ele permite que o usuário realize um cadastro. Os dados do cadastro são inseridos em um banco de dados e uma mensagem de confirmação é exibida para o usuário.
                stmSqlLogin.close(); // Encerra a comunicação com o banco de dados que estava sendo utilizada para realizar as operações relacionadas ao envio de e-mails.
                return 1;
            }
        } catch (Exception e) { // Se der algum problema ao cadastrar, mostrar uma mensagem de erro para o usuário e imprimir uma mensagem feinha para o programador.
            System.err.println("Erro: " + e);
            return 2;
        }
    }
}