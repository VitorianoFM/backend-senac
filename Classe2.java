public class Classe2 {
    public static float calcularSoma(float numero1, float numero2) {
        return numero1 + numero2;
    }

    public static String[] mostrarOpcoes() {
        return Classe3.pegarOpcoes();
    }

    public static String resuldado(float fltInputUsuario1, float fltInputUsuario2, int opcaoEscolhida) {
        return Classe3.processarDados(fltInputUsuario1, fltInputUsuario2, opcaoEscolhida);
    }
}