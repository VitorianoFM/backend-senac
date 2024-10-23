package view;

import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenuView extends JFrame {

    public JMenu cadastroMenu;
    public JMenu arquivoMenu;
 
    public JMenuItem novoItem;
    public JMenuItem pesquisarItem;
    public JMenuItem atualizarItem;
    public JMenuItem removerItem;

    public JMenuItem sobreItem;
    public JMenuItem sairItem;

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

        JMenu arquivoMenu = new JMenu("Arquivo"); // criar menu de arquivo
        arquivoMenu.setMnemonic('Q'); // definir mnemônico para F

        JMenuItem sobreItem = new JMenuItem("Sobre...");
        sobreItem.setMnemonic('S'); // definir mnemônico para A
        arquivoMenu.add(sobreItem); // adicionar item sobre ao menu de arquivo
        sobreItem.addActionListener(
           new ActionListener() // classe interna anônima
           {  
              // exibir caixa de diálogo de mensagem quando o usuário selecionar Sobre...
              @Override
              public void actionPerformed(ActionEvent event)
              {
                 JOptionPane.showMessageDialog(TelaDeMenuView.this,
                    "Sistema de Cadastro 2024",
                    "Sobre", JOptionPane.PLAIN_MESSAGE);
              } 
           } 
        ); 
          
        JMenuItem sairItem = new JMenuItem("Sair"); // criar item de saída
        sairItem.setMnemonic('I'); // definir mnemônico para x
        arquivoMenu.add(sairItem); // adicionar item de saída ao menu de arquivo
        sairItem.addActionListener(
           new ActionListener() // classe interna anônima
           {  
              // encerrar o aplicativo quando o usuário clicar em sairItem
              @Override
              public void actionPerformed(ActionEvent event)
              {
                 System.exit(0); // sair do aplicativo
              } 
           }
        ); 
  
        JMenuBar bar = new JMenuBar(); // criar barra de menu
        setJMenuBar(bar); // adicionar barra de menu ao aplicativo
        bar.add(arquivoMenu); // adicionar menu de arquivo à barra de menu
            
        lblTelaDeMenu = new JLabel("Tela de Menu", SwingConstants.CENTER);

        cadastroMenu.add(novoItem);
        cadastroMenu.add(pesquisarItem);
        cadastroMenu.add(atualizarItem);
        cadastroMenu.add(removerItem);

        barraDeMenu.add(cadastroMenu);

        arquivoMenu.add(sobreItem);
        arquivoMenu.add(sairItem);

        barraDeMenu.add(arquivoMenu);

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
    }
    

    public static String setHtmlFormat(String strTexto) { // O método setHtmlFormat recebe uma string como argumento e retorna essa string formatada como um documento HTML básico.
        return "<html><body><center>" + strTexto + "</center></body></html>";
    }
    // Método main, ponto de entrada do programa.
    public static TelaDeMenuView appTelaDeMenuView;
    public static void main(String[] args) {
        appTelaDeMenuView = new TelaDeMenuView(); // Cria uma variável da janela de menu.
        appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será encerrado.
        InterfaceView.definirIcone(appTelaDeMenuView);
    }

}
