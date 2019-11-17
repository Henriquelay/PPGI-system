
package sistema.util;

import java.io.IOException;

public class InconsistenciaSiglaVeiculoQualis extends IOException {
    private String ano;
    private String sigla;

    @Override
    public String toString() {
        return "Sigla de veículo não definida usada na publicação não foi definida na qualificação do ano “" + this.ano + "”: " + this.sigla + ".";
    }

    public InconsistenciaSiglaVeiculoQualis(String ano, String sigla) {
        this.ano = ano;
        this.sigla = sigla;       
    }
}