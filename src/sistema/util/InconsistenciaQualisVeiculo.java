package sistema.util;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 * @version 1.0
 */
public class InconsistenciaQualisVeiculo extends Exception {
    public InconsistenciaQualisVeiculo(String sigla, int ano, String qualis) {
        super("Qualis desconhecido para qualificação do de veículo não é nenhuma das categorias veículo " + sigla + " no ano " + ano + ": " + qualis + ".");
    }
}