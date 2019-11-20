package sistema.util;

/**
 * @author Henrique Coutinho Layber
 * @version 1.0
 * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 */
public class InconsistenciaCodigo extends Exception {
    public InconsistenciaCodigo(String object, String codigo) {
        super("Código repetido para " + object + ": " + codigo + ".");
    }
}