package sistema.util;

import java.io.IOException;

public class InconsistenciaQualisVeiculo extends IOException {
    private String sigla;
    private int ano;
    private String qualis;

    @Override
    public String toString() {
        return "Qualis desconhecido para qualificação do de veículo não é nenhuma das categorias veículo " + this.sigla + " no ano " + this.ano + ": " + this.qualis + ".";
    }

    public InconsistenciaQualisVeiculo(String sigla, int ano, String qualis) {
        this.sigla = sigla;
        this.ano = ano;
        this.qualis = qualis;
    }
}