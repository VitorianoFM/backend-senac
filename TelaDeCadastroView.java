package view;

import controller.*;

import java.awt.*; // Importa todos os componentes do módulo AWT.
import java.awt.event.*; // import java.awt.event.*;
import java.sql.*; // Importa todos os caomponentes do modulos sql para usar o banco de dados do MySQL.
import javax.swing.*; // Importa todos os componentes do módulo Swing.

// Classe TelaDeLogin que herda de JFrame para criar uma interface gráfica de login.
public class TelaDeCadastroView extends JFrame {   
   // Declaração dos componentes da interface gráfica.
   private final JLabel lblNome; // Rótulo para o campo de nome.
   private final JTextField txtNome; // Campo de texto para o nome.

   private final JLabel lblEmail; // Rótulo para o campo de email.
   private final JTextField txtEmail; // Campo de texto para o email.

   private final JLabel lblSenha; // Rótulo para o campo de senha.
   private final JPasswordField txtSenha; // Campo de texto para a senha, que oculta os caracteres digitados.

   private final JButton btnCadastrar; // Botão para submeter o cadastro.

   private final JLabel lblNotificacoes; // Rótulo para exibir notificações ou mensagens ao usuário.

   // Construtor da classe TelaDeCadastro, onde os componentes são configurados e adicionados à janela.
   public TelaDeCadastroView() 
   {
      super("Tela de Cadastro"); // Define o título da janela.
      setLayout(new GridLayout(4, 2, 5, 5)); // Define o layout da janela como GridLayout.

      lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria um rótulo com o texto "Nome".
      add(lblNome); // Adiciona o rótulo à janela.

      txtNome = new JTextField(25); // Cria um campo de texto com largura de 25 colunas.
      add(txtNome); // Adiciona o campo de texto à janela.

      lblEmail = new JLabel("E-mail:", SwingConstants.RIGHT); // Cria um rótulo com o texto "E-mail".
      add(lblEmail); // Adiciona o rótulo à janela.

      txtEmail = new JTextField(25); // Cria um campo de texto com largura de 25 colunas.
      add(txtEmail); // Adiciona o campo de texto à janela.
      
      lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // Cria um rótulo com o texto "Senha".
      add(lblSenha); // Adiciona o rótulo à janela.

      txtSenha = new JPasswordField(25); // Cria um campo de senha com largura de 25 colunas.
      add(txtSenha); // Adiciona o campo de senha à janela.

      btnCadastrar = new JButton("Cadastrar"); // Cria um botão com o texto "Cadastrar".
      add(btnCadastrar); // Adiciona o botão à janela.

      //add(new JLabel("     ")); // Adiciona um rótulo vazio para espaçamento.
      lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um rótulo centralizado para notificações.
      add(lblNotificacoes); // Adiciona o rótulo à janela.

      btnCadastrar.addActionListener( // Configura um botão para que, ao ser clicado, ele execute uma determinada ação.
         new ActionListener() { // Definir o que acontece quando um evento de ação é gerado para aquele componente.
             @Override // Uma classe herda características de outra classe (classe pai), ela pode "reescrever" ou "sobrepor" métodos que já existem na classe pai. Essa ação é chamada de sobrescrita de método.
             public void actionPerformed(ActionEvent event) { // Define um método que será executado quando um evento de ação acontecer em um componente da interface gráfica.
                 if (txtNome.getText().trim().length() <= 3) { // Verifica se um campo de texto, identificado por txtNome, contém algum valor válido antes de prosseguir com um cadastro.
                     lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Nome para o cadastro. Por favor, digite um nome e tente novamente."));
                     txtNome.requestFocus();
                     return;
                 }

                 if (txtEmail.getText().trim().length() <= 5) { // Verifica se um campo de texto, identificado por txtEmail, contém algum valor válido antes de prosseguir com um cadastro.
                     lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Email para o cadastro. Por favor, digite um Email e tente novamente."));
                     txtEmail.requestFocus();
                     return;
                 }

                 if (String.valueOf(txtSenha.getPassword()).trim().length() <= 7) { // Verifica se um campo de texto, identificado por txtSenha, contém algum valor válido antes de prosseguir com um cadastro.
                     lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha com 8 digitos para o cadastro. Por favor, digite uma Senha e tente novamente."));
                     txtSenha.requestFocus();
                     return;
                 }

                 try { // O programa está tentando se conectar ao banco de dados MySQL, executar uma consulta SQL para buscar registros com um determinado endereço de email e armazenar o resultado em um objeto ResultSet.
                     Connection conexao = MySQLConnector.conectar();
                     String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtEmail.getText() + "';";
                     Statement stmSqlEmail = conexao.createStatement();
                     ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);
                     if (rstSqlEmail.next()) { // Verifica a existência de um usuário com determinado e-mail em um banco de dados.
                         lblNotificacoes.setText(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digite outro email e tente novamente."));
                     } else { // Verifica se o login é válido. Caso não seja, ele permite que o usuário realize um cadastro. Os dados do cadastro são inseridos em um banco de dados e uma mensagem de confirmação é exibida para o usuário.
                         lblNotificacoes.setText(setHtmlFormat("Login liberado para cadastro."));
                         String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + txtNome.getText() + "', '" + txtEmail.getText() + "', '" + String.valueOf(txtSenha.getPassword()) + "');";
                         // System.out.println(strSqlCadastrar);
                         Statement stmSqlCadastrar = conexao.createStatement();
                         stmSqlCadastrar.addBatch(strSqlCadastrar);
                         stmSqlCadastrar.executeBatch();
                         lblNotificacoes.setText(setHtmlFormat("Cadastro realizado com sucesso"));
                     }
                     stmSqlEmail.close(); // Encerra a comunicação com o banco de dados que estava sendo utilizada para realizar as operações relacionadas ao envio de e-mails.
                 } catch (Exception e) { // Se der algum problema ao cadastrar, mostrar uma mensagem de erro para o usuário e imprimir uma mensagem feinha para o programador.
                     lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com o cadastro! Por favor, verifique e tente novamente."));
                     System.err.println("Erro: " + e);
                 }
             }
         }
     );
   
      setSize(270, 220); // Define o tamanho da janela para 270 pixels de largura e 220 pixels de altura.
      setVisible(true); // Torna a janela visível.

      
   }
   
   private String setHtmlFormat(String strTexto) { // O método setHtmlFormat recebe uma string como argumento e retorna essa string formatada como um documento HTML básico.
      return "<html><body>" + strTexto + "</body></html>";
   }
   // Método main, ponto de entrada do programa.
   public static void main(String[] args) {
      TelaDeCadastroView appTelaDeCadastroView = new TelaDeCadastroView(); // Cria uma variável da janela de login.
      appTelaDeCadastroView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será encerrado.
   }
}