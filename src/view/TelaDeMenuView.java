package view;

import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenuView extends JFrame {

    public JMenu cadastroMenu;

    public JMenuItem novoItem;
    public JMenuItem pesquisarItem;
    public JMenuItem atualizarItem;
    public JMenuItem removerItem;

    public JMenuBar barraDeMenu;

    public JLabel lblTelaDeMenu;

    public TelaDeMenuView() {
        super("Tela de Menu");

        barraDeMenu = new JMenuBar();

        cadastroMenu = new JMenu("Cadastro");
        cadastroMenu.setMnemonic('C');

        novoItem = new JMenuItem("Novo");
        novoItem.setMnemonic('N');

        pesquisarItem = new JMenuItem("Pesquisar");
        pesquisarItem.setMnemonic('P');

        atualizarItem = new JMenuItem("Atualizar");
        atualizarItem.setMnemonic('A');

        removerItem = new JMenuItem("Remover");
        removerItem.setMnemonic('R');

        lblTelaDeMenu = new JLabel("Tela de Menu", SwingConstants.CENTER);

        cadastroMenu.add(novoItem);
        cadastroMenu.add(pesquisarItem);
        cadastroMenu.add(atualizarItem);
        cadastroMenu.add(removerItem);

        barraDeMenu.add(cadastroMenu);

        setJMenuBar(barraDeMenu);

        add(lblTelaDeMenu, BorderLayout.CENTER);

        novoItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeCadastroView();
                }
            }
        );

        pesquisarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDePesquisaView();
                }
            }
        );

        atualizarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeAtualizarView();
                }
            }
        );

        removerItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeRemoverView();
                }
            }
        );

        setSize(270, 300); // Define o tamanho da janela.
        setVisible(true); // Torna a janela visível.
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
    }
    

    public static String setHtmlFormat(String strTexto) { // O método setHtmlFormat recebe uma string como argumento e retorna essa string formatada como um documento HTML básico.
        return "<html><body><center>" + strTexto + "</center></body></html>";
    }
    // Método main, ponto de entrada do programa.
    public static TelaDeMenuView appTelaDeMenuView;
    public static void main(String[] args) {
        appTelaDeMenuView = new TelaDeMenuView(); // Cria uma variável da janela de menu.
        appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será encerrado.
    }

}
