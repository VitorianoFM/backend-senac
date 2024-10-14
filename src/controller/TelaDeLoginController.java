package controller;

import model.*;
import view.*;

public class TelaDeLoginController {
    public static String[] retornoUsuario = {
        "Conectado com sucesso!", // resposta 0
        "Login ou senha incorretos!", // resposta 1
        "Não foi possível encontrar o login e/ou senha digitados/informados! Por favor, verifique e tente novamente. Veja o erro: " + e, // resposta 2
    };

    public static String logarController(String login, String senha) {
        return retornoUsuario[TelaDeLoginModel.logarModel(login, senha)];
    }
}