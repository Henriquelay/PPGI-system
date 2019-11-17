package sistema.util;

import java.io.IOException;
import sistema.util.MyCalendar;

public class InconsistenciaQualisRegra extends IOException {
    private MyCalendar inicio;
    private String qualis;

    @Override
    public String toString() {
        return "Qualis desconhecido para regras de " + this.inicio + ": " + this.qualis + "";   // No period.
    }

    public InconsistenciaQualisRegra(MyCalendar inicio, String qualis) {
        this.inicio = inicio;
        this.qualis = qualis;
    }
}