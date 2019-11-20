package sistema.util;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 * @version 1.0
 */
public class InconsistenciaCodigo extends Exception {
    public InconsistenciaCodigo(String object, String codigo) {
        super("Código repetido para " + object + ": " + codigo + ".");
    }
}