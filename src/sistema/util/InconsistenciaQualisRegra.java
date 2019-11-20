package sistema.util;

public class InconsistenciaQualisRegra extends Exception {
    public InconsistenciaQualisRegra(String inicio, String qualis) {
        super("Qualis desconhecido para regras de " + inicio + ": " + qualis + "");
    }
}