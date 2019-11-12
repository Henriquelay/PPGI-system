package sistema;

import sistema.Docente;
import sistema.Veiculo;
import java.util.TreeMap;
import java.util.Objects;

/**
 * Classe para implementação das publicação de docentes
 * @author Henrique Layber
 * @version 1.0
 */
public class Publicacao {
    private int ano;
    private String titulo;
    private int numero;

    // Relations
    Veiculo veiculo;
    TreeMap<Integer, Docente> docentes; // código do docente, docente;

    // Getters e Setters
    public int getAno() {return this.ano;}
    public String getTitulo() {return this.titulo;}
    public int getNumero() {return this.numero;}
    public Veiculo getVeiculo() {return this.veiculo;}
    public TreeMap<Integer, Docente> getDocentes() {return this.docentes;}
    private void setAno(int ano) {this.ano = ano;}
    private void setTitulo(String titulo) {this.titulo = titulo;}
    private void setNumero(int numero) {this.numero = numero;}
    private void setVeiculo(Veiculo veiculo) {this.veiculo = veiculo;}
    private void setDocente(int codigo, Docente docente) {this.getDocentes().put(new Integer(codigo), docente);}

    // To compare with standard function
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Publicacao)) {
            return false;
        }
        Publicacao publicacao = (Publicacao) o;
        return ano == publicacao.ano && Objects.equals(titulo, publicacao.titulo) && numero == publicacao.numero;
    }

    // To print with standard function
    @Override
    public String toString() {
        return "Título: " + this.getTitulo() +
            "\n╠Ano: " + this.getAno() +
            "\n╚Número: " + this.getNumero();
    }

    // Constructor
    public Publicacao(int ano, String titulo, int numero) {
        this.setAno(ano);
        this.setTitulo(titulo);
        this.setNumero(numero);
        this.docentes = new TreeMap<Integer, Docente>();
    }
    public Publicacao(int ano, String titulo, int numero, Veiculo veiculo, TreeMap<Integer, Docente> docentes) {
        this.setAno(ano);
        this.setTitulo(titulo);
        this.setNumero(numero);
        this.setVeiculo(veiculo);
        this.docentes = docentes;
    }
}