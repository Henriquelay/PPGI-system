package sistema;

import sistema.Docente;
import sistema.Veiculo;
import java.util.TreeMap;
import java.util.Map;
import java.io.Serializable;
import java.util.Comparator;

/**
 * Classe para implementação das publicação de docentes
 * @author Henrique Layber
 *
 */
public abstract class Publicacao implements Comparable<Publicacao>, Serializable {
    private int ano;
    private String titulo;
    private int numero;
    private int pagInicial;
    private int pagFinal;
    
    // Relations
    Veiculo veiculo;
    TreeMap<Long, Docente> docentes; // código do docente, docente;
    
    // Getters e Setters
    public int getAno() {return this.ano;}
    public String getTitulo() {return this.titulo;}
    public int getNumero() {return this.numero;}
    public int getPagInicial() {return this.pagInicial;}
    public int getPagFinal() {return this.pagFinal;}
    public Veiculo getVeiculo() {return this.veiculo;}
    public TreeMap<Long, Docente> getDocentes() {return this.docentes;}
    public char getTipo() {return '\0';}
    private void setAno(int ano) {this.ano = ano;}
    private void setTitulo(String titulo) {this.titulo = titulo;}
    private void setNumero(int numero) {this.numero = numero;}
    private void setVeiculo(Veiculo veiculo) {this.veiculo = veiculo;}
    private void setPagInicial(int pagInicial) {this.pagInicial = pagInicial;}
    private void setPagFinal(int pagFinal) {this.pagFinal = pagFinal;}
    private void setDocente(int codigo, Docente docente) {this.getDocentes().put(new Long(codigo), docente);}
    
    // To print with standard function
    @Override
    public String toString() {
        String str = "╔Título:\t" + this.getTitulo() +
        "\n╠Ano:\t" + this.getAno() +
        "\n╠PagInicial:" + this.getPagInicial() +
        "\n╠PagFinal:\t" + this.getPagFinal() +
        "\n╠Número:\t" + this.getNumero() +
        "\n╠Autores:\t";
        for(Map.Entry<Long, Docente> e : this.getDocentes().entrySet()) {
            str += e.getValue().getNome();
            if(e.getKey() != this.getDocentes().lastEntry().getKey())
                str += ",";
        }
            str += "\n╠Veículo:\t" + this.getVeiculo().getSigla();
            return str;
    }

    public String toCSV(int ano) {
        String fatorImpacto = String.format("%.3f", this.getVeiculo().getFatorDeImpacto());
        String str = this.getAno() + ";" + this.getVeiculo().getSigla() + ";" + this.getVeiculo().getTitulo() + ";" + this.getVeiculo().selectQualis(ano) + ";" + fatorImpacto.replace(".", ",") + ";" + this.getTitulo() + ";";
        for(Docente d : this.getDocentes().values()) {
            str += d.getNome();
            if(d != this.getDocentes().lastEntry().getValue())
                str += ",";
        }
        str += "\n";
        return str;
    }

    public int compareTo(Publicacao p) {
        int compQualis = this.getVeiculo().selectQualis(this.getAno()).compareTo(p.getVeiculo().selectQualis(p.getAno()));
        if(compQualis == 0) {
            Integer pAno = new Integer(p.getAno());
            int compAno = pAno.compareTo(this.getAno());
            if(compAno == 0) {
                int compVeiculo = this.getVeiculo().getSigla().compareTo(p.getVeiculo().getSigla());
                if(compVeiculo == 0) {
                    int compTitulo = this.getTitulo().compareTo(p.getTitulo());
                    return compTitulo;
                }
                return compVeiculo;
            }
            return compAno;
        }
        return compQualis;
    }

    public static Comparator<Publicacao> ComparadorPublicacao = new Comparator<Publicacao>() {
        public int compare(Publicacao p1, Publicacao p2) {
            return p1.compareTo(p2);
        }
    };

    // Constructor
    public Publicacao(int ano, Veiculo veiculo, String titulo, int numero, int pagInicial, int pagFinal) {
        this.setAno(ano);
        this.setTitulo(titulo);
        this.setNumero(numero);
        this.setPagInicial(pagInicial);
        this.setPagFinal(pagFinal);
        this.setVeiculo(veiculo);
        this.docentes = new TreeMap<Long, Docente>();
    }
    public Publicacao(int ano, Veiculo veiculo, String titulo, TreeMap<Long, Docente> docentes, int numero, int pagInicial, int pagFinal) {
        this.setAno(ano);
        this.setTitulo(titulo);
        this.setNumero(numero);
        this.setPagInicial(pagInicial);
        this.setPagFinal(pagFinal);
        this.setVeiculo(veiculo);
        this.docentes = docentes;
    }
}