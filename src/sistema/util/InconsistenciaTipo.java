package sistema.util;

import java.io.IOException;

public class InconsistenciaTipo extends IOException {
    private String tipo;
    private String sigla;

    @Override
    public String toString() {
        return "Tipo de veículo desconhecido para veículo " + this.sigla + "”: " + this.tipo + ".";
    }

    public InconsistenciaTipo(String sigla, String tipo) {
        this.tipo = tipo;
        this.sigla = sigla;       
    }
}