package controller;

import model.*;
import view.*;

import javax.swing.*; // Importa todos os componentes do módulo Swing.

public class TelaDeRemoverController extends TelaDeRemoverView {
        public static void popularIds() {
            TelaDeRemoverModel.popularIdsModel();
            if (cbxId != null) {
                if (cbxId.getItemCount() > 0) {
                    cbxId.removeAllItems();
                    DefaultComboBoxModel<String> newMod = new DefaultComboBoxModel<String>(ids);
                    cbxId.setModel(newMod);
                    // cbxId = new JComboBox<String>(ids);
            }
        }
    }

    public static void removerId() {
        TelaDeRemoverModel.removerIdModel(cbxId.getSelectedItem().toString());
    }

    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        cbxId.setSelectedIndex(0);
    }

    public static void atualizarCampos(boolean notificar) {
        if (cbxId.getSelectedIndex() > 0) {
        } else {
            if (notificar == true) {
                lblNotificacoes.setText("Selecione um ID para continuar.");
                limparCampos();
            }
        }
    }

    public static void preencherCampos(String nome, String email) {
        txtNome.setText(nome);
        txtEmail.setText(email);
    }

    public static void enviarIds(String[] idsTemp) {
        ids = idsTemp;
    }

    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));        
    }
}