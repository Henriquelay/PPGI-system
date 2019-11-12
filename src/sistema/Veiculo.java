package sistema;

import sistema.Publicacao;
import java.io.Serializable;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Classe abstrata para implementação dos veículos de publicações
 * @author Henrique Layber
 * @version 1.0
 */
public abstract class Veiculo implements Serializable {
    protected String titulo;
    protected String sigla;
    protected double fatorDeImpacto;
    protected TreeMap<Integer,String> Qualis;   // ano, qualis

    // Relation
    TreeMap<Integer,Publicacao> publicacao;     // numero da publicação, publicação

    // Setters and Getters
    public String getTitulo() {return this.titulo;}
    public String getSigla() {return this.sigla;}
    public TreeMap<Integer,String> getQualis() {return this.Qualis;}
    public TreeMap<Integer,Publicacao> getPublicacao() {return this.publicacao;}
    public double getFatorDeImpacto() {return this.fatorDeImpacto;}
    private void setTitulo(String titulo) {this.titulo = titulo;}
    private void setSigla(String sigla) {this.sigla = sigla;}
    private void setFatorDeImpacto(double fatorDeImpacto) {this.fatorDeImpacto = fatorDeImpacto;}
    private void setQualis(int ano, String Qualis) {this.getQualis().put(new Integer(ano), Qualis);}
    private void setPublicacao(int numero, Publicacao publicacao) {this.getPublicacao().put(new Integer(numero), publicacao);}

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
        "\n╠Sigla: " + this.getSigla() +
        "\n╚Fator de Impacto: " + this.fatorDeImpacto;
    }
    
    // Constructor
    public Veiculo(String titulo, String sigla, double fatorDeImpacto) {
        this.setTitulo(titulo);
        this.setSigla(sigla);
        this.setFatorDeImpacto(fatorDeImpacto);
    }
}