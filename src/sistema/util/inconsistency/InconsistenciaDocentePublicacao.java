package sistema.util.inconsistency;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public class InconsistenciaDocentePublicacao extends Inconsistencia {
    public InconsistenciaDocentePublicacao(String publicacao, String cod) {
        super("Código de docente não definido usado na publicação \"" + publicacao + "\": " + cod + ".");
    }
}
