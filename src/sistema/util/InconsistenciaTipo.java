package sistema.util;

import java.io.IOException;

public class InconsistenciaTipo extends IOException {
    private char tipo;
    private String sigla;

    @Override
    public String toString() {
        return "Tipo de veículo desconhecido para veículo " + this.sigla + "”: " + this.tipo + ".";
    }

    public InconsistenciaTipo(String sigla, char tipo) {
        this.tipo = tipo;
        this.sigla = sigla;       
    }
}