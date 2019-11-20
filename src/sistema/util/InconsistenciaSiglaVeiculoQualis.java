package sistema.util;

/**
 * @author Henrique Coutinho Layber
 * @version 1.0
 * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 */
public class InconsistenciaSiglaVeiculoQualis extends Exception {
    public InconsistenciaSiglaVeiculoQualis(String ano, String sigla) {
        super("Sigla de veículo não definida usada na publicação não foi definida na qualificação do ano “" + ano + "”: " + sigla + ".");
    }
}