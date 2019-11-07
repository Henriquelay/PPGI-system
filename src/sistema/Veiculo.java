package sistema;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Henrique Layber
 * @version 1.0
 * Classe abstrata para implementação dos veículos de publicações
 */
public abstract class Veiculo implements Serializable {
    protected String titulo;
    protected String sigla;
    protected float fatorDeImpacto;

    // Setters and Getters
    public String getTitulo() {return this.titulo;}
    public String getSigla() {return this.sigla;}
    public float getFatorDeImpacto() {return this.fatorDeImpacto;}
    private void setTitulo(String titulo) {this.titulo = titulo;}
    private void setSigla(String sigla) {this.sigla = sigla;}
    private void setFatorDeImpacto(float fatorDeImpacto) {this.fatorDeImpacto = fatorDeImpacto;}

    // To compare with standard function
    @Override
    public boolean equals(Object o) {
        if (o == this)
        return true;
        if (!(o instanceof Veiculo)) {
            return false;
        }
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(titulo, veiculo.titulo) && Objects.equals(sigla, veiculo.sigla) && fatorDeImpacto == veiculo.fatorDeImpacto;
    }

    // To print with standard function
    @Override
    public String toString() {
        return "Título: " + this.getTitulo() +
        "\nSigla: " + this.getSigla() +
        "\nFator de Impacto: " + this.fatorDeImpacto;
    }
    
    // Constructor
    public Veiculo(String titulo, String sigla, float fatorDeImpacto) {
        this.setTitulo(titulo);
        this.setSigla(sigla);
        this.setFatorDeImpacto(fatorDeImpacto);
    }
}