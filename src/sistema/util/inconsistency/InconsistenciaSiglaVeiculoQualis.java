package sistema.util.inconsistency;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public class InconsistenciaSiglaVeiculoQualis extends Inconsistencia {
    public InconsistenciaSiglaVeiculoQualis(String ano, String sigla) {
        super("Sigla de veículo não definida usada na publicação não foi definida na qualificação do ano “" + ano + "”: " + sigla + ".");
    }
}