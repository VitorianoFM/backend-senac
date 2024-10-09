package view;

import controller.*;

import java.awt.*; // Importa todos os componentes do módulo AWT.
import java.awt.event.*; // Importa todos os componentes do módulo AWT.event;
import javax.swing.*; // Importa todos os componentes do módulo Swing.

public class TelaDeRemoverView extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JLabel lblNotificacoes;

    public static JButton btnRemover;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public TelaDeRemoverView()
    {
        super("Tela de Atualização");
        setLayout(new GridLayout(5,1,5,5));

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        TelaDeRemoverController.popularIds();
        cbxId = new JComboBox<String>(ids);
        linha_id.add(cbxId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);
        txtNome.setEditable(false);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);
        txtEmail.setEditable(false);
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnRemover = new JButton("Remover");
        linha_botoes.add(btnRemover);

        btnCancelar = new JButton("Cancelar");
        linha_botoes.add(btnCancelar);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        btnRemover.addActionListener( // Adiciona um ouvinte de ação (ActionListener) ao botão btnRemover. Isso significa que quando o botão for clicado, o método actionPerformed() será executado.
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeRemoverController.removerId();
                }
            }
        );

        btnCancelar.addActionListener( // Adiciona um ouvinte de ação ao botão btnCancelar que chama o método limparCampos quando o botão é clicado. Isso provavelmente é usado para cancelar uma operação e limpar os dados de entrada.
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeRemoverController.limparCampos();
                }
            }
        );

        cbxId.addItemListener( // Adiciona um listener de item ao componente cbxId. Quando um item é selecionado, o método atualizarCampos é chamado para atualizar os campos de registro com os dados correspondentes ao item selecionado.
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        TelaDeRemoverController.atualizarCampos(false);
                    }
                } 
            }
        );

        setSize(285, 300); // Define o tamanho da janela para 285 pixels de largura e 300 pixels de altura.
        ImageIcon img = new ImageIcon("./senac-logo.png"); // Cria um novo objeto ImageIcon chamado "img" e carrega a imagem "senac-logo.png" localizada no mesmo diretório que o código.
        setIconImage(img.getImage()); // Define a imagem carregada no objeto "img" como o ícone da janela.
        setVisible(true); // Torna a janela visível na tela.
        cbxId.requestFocus(); // Dá foco ao componente chamado "cbxId", geralmente um JComboBox (caixa de combinação), fazendo com que ele seja selecionado e pronto para receber entrada do usuário.
    }

    public static String setHtmlFormat(String strTexto) { // Essa função pega uma string de entrada e a insere dentro de tags HTML para criar um documento HTML completo.
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) { // Cria um programa simples que abre uma janela de atualização e configura essa janela para que, ao ser fechada, o programa se encerre.
        TelaDeRemoverView appTelaDeRemoverView = new TelaDeRemoverView();
        appTelaDeRemoverView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}