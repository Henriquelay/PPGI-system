package sistema.util.inconsistency;

/**
 * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public class InconsistenciaQualisRegra extends Inconsistencia {
    public InconsistenciaQualisRegra(String inicio, String qualis) {
        super("Qualis desconhecido para regras de " + inicio + ": " + qualis + "");
    }
}