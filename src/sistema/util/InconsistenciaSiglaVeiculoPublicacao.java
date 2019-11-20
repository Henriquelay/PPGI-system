package sistema.util;

public class InconsistenciaSiglaVeiculoPublicacao extends Exception {
    public InconsistenciaSiglaVeiculoPublicacao(String titulo, String sigla) {
        super("Sigla de veículo não definida usada na publicação não foi definida na planilha de publicação “" + titulo + "”: " + sigla + ".");
    }
}