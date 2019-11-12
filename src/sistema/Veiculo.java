package sistema;

import sistema.Publicacao;
import java.io.Serializable;
import java.util.Map;
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
    public double getFatorDeImpacto() {return this.fatorDeImpacto;}
    public TreeMap<Integer,String> getQualis() {return this.Qualis;}
    public TreeMap<Integer,Publicacao> getPublicacoes() {return this.publicacao;}
    private void setTitulo(String titulo) {this.titulo = titulo;}
    private void setSigla(String sigla) {this.sigla = sigla;}
    private void setFatorDeImpacto(double fatorDeImpacto) {this.fatorDeImpacto = fatorDeImpacto;}
    // empty means package-private
    void setQualis(int ano, String Qualis) {this.getQualis().put(new Integer(ano), Qualis);}
    void setPublicacao(int numero, Publicacao publicacao) {this.getPublicacoes().put(new Integer(numero), publicacao);}

    // To print with standard function
    @Override
    public String toString() {
        String str = "╔Título veículo: " + this.getTitulo() +
        "\n╠Sigla: " + this.getSigla() +
        "\n╠Fator de Impacto: " + this.fatorDeImpacto +
        "\n║Qualificação";
        for(Map.Entry<Integer,String> e : this.getQualis().entrySet())
            str += "\n╠═"  + e.getKey() + ":" + e.getValue();
        if(!this.getPublicacoes().isEmpty()) {
            str += "\n║Publicações:\n╠═";
            for(Map.Entry<Integer, Publicacao> e : this.getPublicacoes().entrySet()) {
                str += e.getValue().getNumero();
                if(e.getKey() != this.getPublicacoes().lastEntry().getKey())
                    str += ",";
            }
        }
        return str;
    }
    
    // Constructor
    public Veiculo(String titulo, String sigla, double fatorDeImpacto) {
        this.setTitulo(titulo);
        this.setSigla(sigla);
        this.setFatorDeImpacto(fatorDeImpacto);
        this.Qualis = new TreeMap<Integer,String>();
        this.publicacao = new TreeMap<Integer,Publicacao>();
    }
}