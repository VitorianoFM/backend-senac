import java.util.*;

public class Classe1 {
    public static void main(String[] args) {
        Scanner scnInputUsuario = new Scanner(System.in); // Input de entrada via terminal do usuario
        System.out.println("Olá! Bem vindo a calculadora de JaVa. Digite o primeiro número a ser somado e tecle: \"Enter\"");
        float fltInputUsuario1 = scnInputUsuario.nextFloat(); // captura o que o usuario registrar no terminal
        System.out.println("Agora digite o segundo número a ser somado e tecle: \"Enter\"");
        float fltInputUsuario2 = scnInputUsuario.nextFloat(); // captura o que o usuario registrar no terminal
        System.out.println("O resultado da soma é: " + (fltInputUsuario1 + fltInputUsuario2));
        scnInputUsuario.close();
    }
}