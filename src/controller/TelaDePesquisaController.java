package controller;

import model.*;
import view.*;

public class TelaDePesquisaController extends TelaDePesquisaView {
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao));
    }

    public static void preencherCampos(String id, String nome, String email) {
        txtId.setText(id);
        txtNome.setText(nome);
        txtEmail.setText(email);
    }

    public static void registrarPesquisa() {
        txtUsuario = txtPesquisa.getText();
    }

    public static void pesquisar() { // Define um método público e estático chamado pesquisar que não retorna nenhum valor. Esse método pode ser chamado de qualquer lugar do seu código e provavelmente realiza alguma operação de pesquisa, mas o comportamento específico do método dependerá da implementação dentro das suas chaves {}.
        String textoPesquisa = txtPesquisa.getText().trim();
        if (textoPesquisa.equals(txtUsuario) == false) {
            limparCampos("");
            TelaDePesquisaModel.pesquisarModel(textoPesquisa);
        }
    }

    public static void primeiroRegistro() {
        TelaDePesquisaModel.primeiroRegistroModel(txtPesquisa.getText());
    }

    public static void registroAnterior() {
        TelaDePesquisaModel.registroAnteriorModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText());
    }

    public static void proximoRegistro() {
        TelaDePesquisaModel.proximoRegistroModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText());
    }

    public static void ultimoRegistro() {
        TelaDePesquisaModel.ultimoRegistroModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText());
    }

    public static void limparCamposController(String txt) {
        limparCampos(txt);
    }

    public static void desabilitarTodos() {
        btnComeco.setEnabled(false);
        btnVoltar.setEnabled(false);
        btnAvancar.setEnabled(false);
        btnFim.setEnabled(false);
    }

    public static void habilitarVoltar() {
        desabilitarTodos();
        btnComeco.setEnabled(true);
        btnVoltar.setEnabled(true);
    }

    public static void habilitarTodos() {
        btnComeco.setEnabled(true);
        btnVoltar.setEnabled(true);
        btnAvancar.setEnabled(true);
        btnFim.setEnabled(true);
    }

    public static void habilitarAvancar() {
        desabilitarTodos();
        btnAvancar.setEnabled(true);
        btnFim.setEnabled(true);
    }

    public static void desabilitarPesquisar() {
        btnPesquisar.setEnabled(false);
    }
}