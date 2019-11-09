package sistema;

import java.io.Serializable;
import java.util.Date;
import java.util.TreeMap;

/**
 * Classe para implementação do sistema de controle PPGI
 * @author Henrique Layber
 * @version 1.0
 */
public class SistemaPPGI implements Serializable {
    // Relations
    TreeMap<Date, Regra> regras;    // Data início, Regras
    TreeMap<String, Veiculo> veiculos;  // Sigla, Veiculos
    TreeMap<Integer, Docente> docentes; // Código docente, Docentes

    // Getters e Setters
    public TreeMap<Date,Regra> getRegras() {return this.regras;}
    public TreeMap<String,Veiculo> getVeiculos() {return this.veiculos;}
    public TreeMap<Integer,Docente> getDocentes() {return this.docentes;}
    private void setRegras(Date key,Regra regra) {this.getRegras().put(key, regra);}
    private void setVeiculos(String key,Veiculo veiculo) {this.getVeiculos().put(key, veiculo);}
    private void setDocentes(int key,Docente docente) {this.getDocentes().put(new Integer(key), docente);}

    // Constructor
    public SistemaPPGI() {}

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