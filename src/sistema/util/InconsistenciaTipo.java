package sistema.util;

/**
 * @author Henrique Coutinho Layber
 * @version 1.0
 * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 */
public class InconsistenciaTipo extends Exception {
    public InconsistenciaTipo(String sigla, String tipo) {
        super("Tipo de veículo desconhecido para veículo " + sigla + "”: " + tipo + ".");     
    }
}