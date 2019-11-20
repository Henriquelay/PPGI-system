package sistema.util;

public class InconsistenciaQualisVeiculo extends Exception {
    public InconsistenciaQualisVeiculo(String sigla, int ano, String qualis) {
        super("Qualis desconhecido para qualificação do de veículo não é nenhuma das categorias veículo " + sigla + " no ano " + ano + ": " + qualis + ".");
    }
}