package sistema;

import sistema.Veiculo;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe para implementação dos veículos tipo conferência
 * @author Henrique Layber
 * @version 1.0
 */
public class Conferencia extends Veiculo implements Serializable {

    // Getter and Setter
    public char getTipo() {return 'C';}

    // To print with standard function
    @Override
    public String toString() {
        return super.toString();
    }

    // Constructor
    public Conferencia(String titulo, String sigla, double fatorDeImpacto) {
        super(titulo, sigla, fatorDeImpacto);
    }
}