package sistema;

import java.io.Serializable;
import sistema.util.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * Classe para implementação do sistema de controle PPGI
 * @author Henrique Layber
 * @version 1.0
 */
public class SistemaPPGI implements Serializable {
    // Relations
    private TreeMap<MyCalendar, Regra> regras;    // Data início, Regras
    private TreeMap<String, Veiculo> veiculos;  // Sigla, Veiculos
    private TreeMap<Integer, Docente> docentes; // Código docente, Docentes
    private TreeMap<Integer, Publicacao> publicacoes; // Código docente, Docentes

    // Getters e Setters
    public TreeMap<MyCalendar,Regra> getRegras() {return this.regras;}
    public TreeMap<String,Veiculo> getVeiculos() {return this.veiculos;}
    public TreeMap<Integer,Docente> getDocentes() {return this.docentes;}
    public TreeMap<Integer,Publicacao> getPublicacoes() {return this.publicacoes;}
    public void setRegras(MyCalendar key,Regra regra) {this.getRegras().put(key, regra);}
    public void setVeiculos(String key,Veiculo veiculo) {this.getVeiculos().put(key, veiculo);}
    public void setDocentes(int key,Docente docente) {this.getDocentes().put(new Integer(key), docente);}
    public void setPublicacoes(int key,Publicacao publicacao) {this.getPublicacoes().put(new Integer(key), publicacao);}

    // To print with standard function
    @Override
    public String toString() {
        String str = "";
        for(Map.Entry<MyCalendar, Regra> e : this.getRegras().entrySet())
            str += "\n" + e.getValue().toString();
        for(Map.Entry<String, Veiculo> e : this.getVeiculos().entrySet())
            str += "\n" + e.getValue().toString();
        for(Map.Entry<Integer, Docente> e : this.getDocentes().entrySet())
            str += "\n" + e.getValue().toString(); 
        for(Map.Entry<Integer, Publicacao> e : this.getPublicacoes().entrySet())
            str += "\n" + e.getValue().toString();
        return str;
    }

    // Constructor
    public SistemaPPGI() {
        this.regras = new TreeMap<MyCalendar, Regra>();
        this.veiculos = new TreeMap<String, Veiculo>();
        this.docentes = new TreeMap<Integer, Docente>();
        this.publicacoes = new TreeMap<Integer, Publicacao>();
    }

    // File ingest
    public void lerArquivoDocentes(String filename) {
    }
    public void lerArquivoVeiculos(String filename) {
    }
    public void lerArquivoPublicacoes(String filename) {
    }
    public void lerArquivoQualis(String filename) {
    }
    public void lerArquivoRegras(String filename) {
    }

    // Reports
    public void printarRelatorioRecredenciamento(String filename) {
    }
    public void printarRelatorioPublicacoes(String filename) {
    }
    public void printarEstatisticas(String filename) {
    }
}