package sistema.util.inconsistency;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 * 
 */
public class InconsistenciaCodigo extends Inconsistencia {
    public InconsistenciaCodigo(String object, String codigo) {
        super("Código repetido para " + object + ": " + codigo + ".");
    }
}