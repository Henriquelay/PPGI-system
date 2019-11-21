package sistema.util;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public class InconsistenciaTipo extends Exception {
    public InconsistenciaTipo(String sigla, String tipo) {
        super("Tipo de veículo desconhecido para veículo " + sigla + "”: " + tipo + ".");     
    }
}