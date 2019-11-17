package sistema.util;

import java.io.IOException;

public class InconsistenciaSiglaVeiculo extends IOException {
    private String titulo;
    private String sigla;

    @Override
    public String toString() {
        return "Sigla de veículo não definida usada na publicação não foi definida na planilha de publicação “" + this.titulo + "”: " + this.sigla + ".";
    }

    public InconsistenciaSiglaVeiculo(String titulo, String sigla) {
        this.titulo = titulo;
        this.sigla = sigla;       
    }
}