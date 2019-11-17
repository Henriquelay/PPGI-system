package sistema.util;

import java.io.IOException;

public class InconsistenciaCodigo extends IOException {
    private String objeto;
    private String codigo;

    @Override
    public String toString() {
        return "Código repetido para " + this.objeto + ": " + this.codigo + ".";
    }

    public InconsistenciaCodigo(Object o, Number codigo) {
        this.objeto = o.getClass().getName();
        this.codigo = codigo.toString();        
    }
}