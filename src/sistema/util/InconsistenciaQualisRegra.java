package sistema.util;

/**
 * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 * @version 1.0
 */
public class InconsistenciaQualisRegra extends Exception {
    public InconsistenciaQualisRegra(String inicio, String qualis) {
        super("Qualis desconhecido para regras de " + inicio + ": " + qualis + "");
    }
}