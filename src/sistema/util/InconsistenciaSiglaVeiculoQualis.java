package sistema.util;

public class InconsistenciaSiglaVeiculoQualis extends Exception {
    public InconsistenciaSiglaVeiculoQualis(String ano, String sigla) {
        super("Sigla de veículo não definida usada na publicação não foi definida na qualificação do ano “" + ano + "”: " + sigla + ".");
    }
}