package model;

import controller.*;

import java.sql.*;

public class TelaDePesquisaModel {
    public static int pesquisarModel(String textoPesquisa) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + textoPesquisa + "%' or `email` like '%" + textoPesquisa + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rstSqlPesquisa.next()) {
                rstSqlPesquisa.last();
                int rowNumbers = rstSqlPesquisa.getRow();
                rstSqlPesquisa.first();

                stmSqlPesquisa.close();
                TelaDePesquisaController.preencherCampos(rstSqlPesquisa.getString("id"), rstSqlPesquisa.getString("nome"), rstSqlPesquisa.getString("email"));
                // lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));

                // txtId.setText(rstSqlPesquisa.getString("id"));
                // txtNome.setText(rstSqlPesquisa.getString("nome"));
                // txtEmail.setText(rstSqlPesquisa.getString("email"));

                // txtUsuario = textoPesquisa;
                // btnPesquisar.setEnabled(false);
                // if (rowNumbers > 1) {
                //    btnAvancar.setEnabled(true);
                //    btnFim.setEnabled(true);
                //}  
            } else {
                // txtUsuario = textoPesquisa;
                // btnPesquisar.setEnabled(false);
                // lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\"."));
                TelaDePesquisaController.notificarUsuario("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\".");
                // return 2;
            }
        } catch (Exception e) {
            // lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
            TelaDePesquisaController.notificarUsuario("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.");
            // return 0;
        }

    }
}