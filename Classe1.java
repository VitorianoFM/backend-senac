import java.util.*;

public class Classe1 {
    public static void main(String[] args) {
        Scanner scnInputUsuario = new Scanner(System.in); // Input de entrada via terminal do usuario
        System.out.println("Olá! Bem vindo a calculadora de JaVa. Digite o primeiro número a ser somado e tecle: \"Enter\"");
        int intInputUsuario1 = scnInputUsuario.nextInt(); // captura o que o usuario registrar no terminal
        System.out.println("Agora digite o segundo número a ser somado e tecle: \"Enter\"");
        int intInputUsuario2 = scnInputUsuario.nextInt(); // captura o que o usuario registrar no terminal
        System.out.println("O resultado da soma é: " + (intInputUsuario1 + intInputUsuario2));
        scnInputUsuario.close();
    }
}