package sistema;

import sistema.Docente;
import sistema.Veiculo;
import java.util.TreeMap;
import java.util.Map;

/**
 * Classe para implementação das publicação de docentes
 * @author Henrique Layber
 * @version 1.0
 */
public abstract class Publicacao {
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