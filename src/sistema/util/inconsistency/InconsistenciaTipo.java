package sistema.util.inconsistency;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public class InconsistenciaTipo extends Inconsistencia {
    public InconsistenciaTipo(String sigla, String tipo) {
        super("Tipo de veículo desconhecido para veículo " + sigla + "”: " + tipo + ".");     
    }
}