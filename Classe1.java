import java.util.*;

public class Classe1 {
    public static void main(String[] args) {
        Scanner scnInputUsuario = new Scanner(System.in); // Input de entrada via terminal do usuario
        System.out.println("Olá! Bem vindo. Digite algo e tecle: \"Enter\"");
        String strInputUsuario = scnInputUsuario.nextLine(); // captura o que o usuario registrar no terminal
        System.out.println("Você digitou: " + strInputUsuario);
        scnInputUsuario.close();
    }
}