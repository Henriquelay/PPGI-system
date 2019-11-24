package sistema.util.inconsistency;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public abstract class Inconsistencia extends Exception {
    Inconsistencia(String message) {
        super(message);
    }
}