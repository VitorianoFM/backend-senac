package model;

// import controller.*;

import java.sql.*;

public class TelaDeLoginModel {
    public boolean logarModel(String login, String senha) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `email` = '" + login + "' AND `senha` = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            boolean isAuthenticated = rstSqlLogin.next();
            stmSqlLogin.close();
            return isAuthenticated;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}