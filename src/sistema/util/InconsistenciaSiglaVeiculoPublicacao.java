package sistema.util;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public class InconsistenciaSiglaVeiculoPublicacao extends Exception {
    public InconsistenciaSiglaVeiculoPublicacao(String titulo, String sigla) {
        super("Sigla de veículo não definida usada na publicação não foi definida na planilha de publicação “" + titulo + "”: " + sigla + ".");
    }
}