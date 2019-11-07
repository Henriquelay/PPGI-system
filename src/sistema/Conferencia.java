package sistema;

import sistema.Veiculo;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Henrique Layber
 * @version 1.0
 * @category veículo
 * Classe para implementação dos veículos tipo conferência
 */
public class Conferencia extends Veiculo implements Serializable {
    private String local;

    // Getter and Setter
    public String getLocal() {return this.local;}
    private void setLocal(String local) {this.local = local;}

    // To compare with standard function
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Conferencia))
            return false;
        Conferencia conferencia = (Conferencia) o;
        return Objects.equals(local, conferencia.local);
    }

    // To print with standard function
    @Override
    public String toString() {
        return super.toString() +
        "\nLocal: " + this.getLocal();
    }

    // Constructor
    public Conferencia(String titulo, String sigla, float fatorDeImpacto, String local) {
        super(titulo, sigla, fatorDeImpacto);
        this.setLocal(local);
    }
}