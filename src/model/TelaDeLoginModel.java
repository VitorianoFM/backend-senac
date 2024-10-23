package model;

import controller.*;

import java.sql.*;

public class TelaDeLoginModel {
    public static void logarModel(String login, String senha) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + login + "' and `senha` = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) { // Verifica a existência de um usuário com determinado e-mail em um banco de dados.
                TelaDeLoginController.notificarUsuario("Conectado com sucesso!!!");
                TelaDeLoginController.abrirTelaDeMenu();
            } else { // Verifica se o login é válido. Caso não seja, ele permite que o usuário realize um cadastro. Os dados do cadastro são inseridos em um banco de dados e uma mensagem de confirmação é exibida para o usuário.
                TelaDeLoginController.notificarUsuario("Login e/ou senha não encontrado! Por favor, verifique e tente novamente.");
            }
            stmSqlLogin.close(); // Encerra a comunicação com o banco de dados que estava sendo utilizada para realizar as operações relacionadas ao envio de e-mails.
        } catch (Exception e) { // Se der algum problema ao cadastrar, mostrar uma mensagem de erro para o usuário e imprimir uma mensagem feinha para o programador.
            TelaDeLoginController.notificarUsuario("Houve um problema e não será possível realizar o login agora. Por favor, tente novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }
}