package model;

import controller.*;

import java.sql.*;

public class TelaDeCadastroModel {
    public static int cadastrarModel(String nome, String email, String senha) {
        try { // O programa está tentando se conectar ao banco de dados MySQL, executar uma consulta SQL para buscar registros com um determinado endereço de email e armazenar o resultado em um objeto ResultSet.
            Connection conexao = MySQLConnector.conectar();
            String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + email + "';";
            Statement stmSqlEmail = conexao.createStatement();
            ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);
            if (rstSqlEmail.next()) { // Verifica a existência de um usuário com determinado e-mail em um banco de dados.
                return 0;
                // lblNotificacoes.setText(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digite outro email e tente novamente."));
            } else { // Verifica se o login é válido. Caso não seja, ele permite que o usuário realize um cadastro. Os dados do cadastro são inseridos em um banco de dados e uma mensagem de confirmação é exibida para o usuário.
                // lblNotificacoes.setText(setHtmlFormat("Login liberado para cadastro."));
                String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + nome + "', '" + email + "', '" + senha + "');";
                // System.out.println(strSqlCadastrar);
                Statement stmSqlCadastrar = conexao.createStatement();
                stmSqlCadastrar.addBatch(strSqlCadastrar);
                stmSqlCadastrar.executeBatch();
                stmSqlEmail.close(); // Encerra a comunicação com o banco de dados que estava sendo utilizada para realizar as operações relacionadas ao envio de e-mails.
                return 2;
                // lblNotificacoes.setText(setHtmlFormat("Cadastro realizado com sucesso"));
            }
        } catch (Exception e) { // Se der algum problema ao cadastrar, mostrar uma mensagem de erro para o usuário e imprimir uma mensagem feinha para o programador.
            // lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com o cadastro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
            return 1;
        }
    }
}