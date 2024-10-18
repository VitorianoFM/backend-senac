package controller;

import model.*;
import view.*;

public class TelaDeLoginController extends TelaDeLoginView {
    public static String[] retornoUsuario = {
        "Conectado com sucesso!", // resposta 0
        "Login ou senha incorretos!", // resposta 1
        "Não foi possível encontrar o login e/ou senha digitados/informados! Por favor, verifique e tente novamente." // resposta 2
    };

    public static int logarController(String login, String senha) {
        return TelaDeLoginModel.logarModel(login, senha);
    }
}