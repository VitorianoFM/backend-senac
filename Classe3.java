public class Classe3 {

    private static final String[] operadoresMatematicos = {"Soma", "Subtração", "Multiplicação", "Divisão"};

    public static String[] pegarOpcoes() {
        return operadoresMatematicos;
    }

    public static float somar(float numero1, float numero2) {
        return numero1 + numero2;
    }

    public static float subtrair(float numero1, float numero2) {
        return numero1 - numero2;
    }

    public static float multiplicar(float numero1, float numero2) {
        return numero1 * numero2;
    }

    public static float dividir(float numero1, float numero2) {
        return numero1 / numero2;
    }
}