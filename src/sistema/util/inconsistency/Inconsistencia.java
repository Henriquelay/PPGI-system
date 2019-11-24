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
    Inconsistencia() {
        super();
    }
    Inconsistencia(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}