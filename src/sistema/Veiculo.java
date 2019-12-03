package sistema;

import sistema.Publicacao;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe abstrata para implementação dos veículos de publicações
 * @author Henrique Layber
 * @author Ezequiel Schneider Reinholtz
 */
public abstract class Veiculo implements Serializable {
    protected String titulo;
    protected String sigla;
    protected double fatorDeImpacto;
    protected TreeMap<Integer,String> Qualis;   // ano, qualis

    // Relation
    TreeMap<String,Publicacao> publicacao;     // numero da publicação, publicação

    // Setters and Getters
    public String getTitulo() {return this.titulo;}
    public String getSigla() {return this.sigla;}
    public double getFatorDeImpacto() {return this.fatorDeImpacto;}
    public TreeMap<Integer,String> getQualis() {return this.Qualis;}
    public TreeMap<String,Publicacao> getPublicacoes() {return this.publicacao;}
    private void setTitulo(String titulo) {this.titulo = titulo;}
    private void setSigla(String sigla) {this.sigla = sigla;}
    private void setFatorDeImpacto(double fatorDeImpacto) {this.fatorDeImpacto = fatorDeImpacto;}

    // To print with standard function
    @Override
    public String toString() {
        String str = "╔Título veículo:\t" + this.getTitulo() +
        "\n╠Sigla:\t\t" + this.getSigla() +
        "\n╠Fator de Impacto:\t" + this.fatorDeImpacto +
        "\n║Qualificação";
        for(Map.Entry<Integer,String> e : this.getQualis().entrySet())
            str += "\n╠═"  + e.getKey() + ":" + e.getValue();
        if(!this.getPublicacoes().isEmpty()) {
            str += "\n║Publicações:\n╠═";
            for(Map.Entry<String, Publicacao> e : this.getPublicacoes().entrySet()) {
                str += e.getValue().getNumero();
                if(e.getKey() != this.getPublicacoes().lastEntry().getKey())
                    str += ",";
            }
        }
        return str;
    }

    public String selectQualis(int ano) {
        String qualis = "";
        for(Map.Entry<Integer,String> e : this.getQualis().entrySet())
            if(e.getKey().intValue() <= ano)
                qualis = e.getValue();
        return qualis;
    }
    
    // Constructor
    public Veiculo(String titulo, String sigla, double fatorDeImpacto) {
        this.setTitulo(titulo);
        this.setSigla(sigla);
        this.setFatorDeImpacto(fatorDeImpacto);
        this.Qualis = new TreeMap<Integer,String>();
        this.publicacao = new TreeMap<String,Publicacao>();
    }

}