package sistema.util;

/**
 * @author Henrique Coutinho Layber
 * @version 1.0
 * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 */
public class InconsistenciaSiglaVeiculoPublicacao extends Exception {
    public InconsistenciaSiglaVeiculoPublicacao(String titulo, String sigla) {
        super("Sigla de veículo não definida usada na publicação não foi definida na planilha de publicação “" + titulo + "”: " + sigla + ".");
    }
}