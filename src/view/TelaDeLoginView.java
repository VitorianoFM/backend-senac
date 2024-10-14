package view;

import controller.*;

import javax.swing.*;
import java.awt.*;

public class TelaDeLoginView extends JFrame {

private final JLabel lblLogin; // Rótulo para o campo de login.
private final JTextField txtLogin; // Campo de texto para o login.

private final JLabel lblSenha; // Rótulo para o campo de senha.
private final JPasswordField txtSenha; // Campo de texto para a senha, que oculta os caracteres digitados.

private final JButton btnEntrar; // Botão para submeter o login e a senha.

private final JLabel lblNotificacoes; // Rótulo para exibir notificações ou mensagens ao usuário.

// Construtor da classe TelaDeLogin, onde os componentes são configurados e adicionados à janela.
public TelaDeLoginView() 
{
    super("Tela de Login"); // Define o título da janela.
    setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout.

    lblLogin = new JLabel("Login"); // Cria um rótulo com o texto "Login".
    add(lblLogin); // Adiciona o rótulo à janela.

    txtLogin = new JTextField(10); // Cria um campo de texto com largura de 10 colunas.
    add(txtLogin); // Adiciona o campo de texto à janela.
    
    lblSenha = new JLabel("Senha"); // Cria um rótulo com o texto "Senha".
    add(lblSenha); // Adiciona o rótulo à janela.

    txtSenha = new JPasswordField(10); // Cria um campo de senha com largura de 10 colunas.
    add(txtSenha); // Adiciona o campo de senha à janela.

    btnEntrar = new JButton("Entrar"); // Cria um botão com o texto "Entrar".
    add(btnEntrar); // Adiciona o botão à janela.

    //add(new JLabel("     ")); // Adiciona um rótulo vazio para espaçamento.
    lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um rótulo centralizado para notificações.
    add(lblNotificacoes); // Adiciona o rótulo à janela.

    btnEntrar.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                TelaDeLoginController.logarController();
            }
        }
    );

    setSize(165, 200); // Define o tamanho da janela.
    setVisible(true); // Torna a janela visível.
    ImageIcon img = new ImageIcon("./senac-logo.png");
    setIconImage(img.getImage());
    
}

    public static String setHtmlFormat(String strTexto) { // O método setHtmlFormat recebe uma string como argumento e retorna essa string formatada como um documento HTML básico.
        return "<html><body>" + strTexto + "</body></html>";
    }
    // Método main, ponto de entrada do programa.
    public static TelaDeLoginView appTelaDeLoginView;
    public static void main(String[] args) {
    appTelaDeLoginView = new TelaDeLoginView(); // Cria uma variável da janela de login.
    appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será encerrado.
    }

}  