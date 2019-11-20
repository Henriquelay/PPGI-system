package sistema.util;

public class InconsistenciaCodigo extends Exception {
    public InconsistenciaCodigo(String object, String codigo) {
        super("Código repetido para " + object + ": " + codigo + ".");
    }
}