import java.util.*;

public class Classe1 {
    public static void main(String[] args) {
        Scanner scnInputUsuario = new Scanner(System.in); // Input de entrada via terminal do usuario
        System.out.println("Olá! Bem vindo a calculadora de JaVa. Digite o primeiro número a ser calculado e tecle: \"Enter\"");
        float fltInputUsuario1 = scnInputUsuario.nextFloat(); // captura o que o usuario registrar no terminal
        System.out.println("Agora digite o segundo número a ser calculado e tecle: \"Enter\"");
        float fltInputUsuario2 = scnInputUsuario.nextFloat(); // captura o que o usuario registrar no terminal
        System.out.println("Digite o número da opção desejada e tecle: \"Enter\".");
        String[] opcoes = Classe2.mostrarOpcoes();

        for (int count = 0; count < opcoes.length; count++){
            System.out.println(count + " - " + opcoes[count]);
        }

        int opcaoEscolhida = scnInputUsuario.nextInt();


        System.out.println("O resultado da " + opcoes[opcaoEscolhida] + " é: " + Classe2.resuldado(fltInputUsuario1, fltInputUsuario2, opcaoEscolhida));
        scnInputUsuario.close();
    }
}