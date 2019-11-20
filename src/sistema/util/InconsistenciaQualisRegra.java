package sistema.util;

/**
 * @author Henrique Coutinho Layber
 * @version 1.0
 * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 */
public class InconsistenciaQualisRegra extends Exception {
    public InconsistenciaQualisRegra(String inicio, String qualis) {
        super("Qualis desconhecido para regras de " + inicio + ": " + qualis + "");
    }
}