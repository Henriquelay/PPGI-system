package sistema.util;

import java.io.IOException;

public class InconsistenciaQualisRegra extends IOException {
    private String inicio;
    private String qualis;

    @Override
    public String toString() {
        return "Qualis desconhecido para regras de " + this.inicio + ": " + this.qualis + "";   // No period.
    }

    public InconsistenciaQualisRegra(String inicio, String qualis) {
        this.inicio = inicio;
        this.qualis = qualis;
    }
}