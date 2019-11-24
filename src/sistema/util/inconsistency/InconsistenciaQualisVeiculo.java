package sistema.util.inconsistency;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public class InconsistenciaQualisVeiculo extends Inconsistencia {
    public InconsistenciaQualisVeiculo(String sigla, int ano, String qualis) {
        super("Qualis desconhecido para qualificação do de veículo não é nenhuma das categorias veículo " + sigla + " no ano " + ano + ": " + qualis + ".");
    }
}