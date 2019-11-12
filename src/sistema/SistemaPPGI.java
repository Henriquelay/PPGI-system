package sistema;

import sistema.util.*;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe para implementação do sistema de controle PPGI
 * @author Henrique Layber
 * @version 1.0
 */
public class SistemaPPGI implements Serializable {
    // Relations
    private TreeMap<MyCalendar, Regra> regras;    // Data início, Regras
    private TreeMap<String, Veiculo> veiculos;  // Sigla, Veiculos
    private TreeMap<Long, Docente> docentes; // Código docente, Docentes
    private TreeMap<Integer, Publicacao> publicacoes; // Código docente, Docentes

    // Getters e Setters
    public TreeMap<MyCalendar,Regra> getRegras() {return this.regras;}
    public TreeMap<String,Veiculo> getVeiculos() {return this.veiculos;}
    public TreeMap<Long,Docente> getDocentes() {return this.docentes;}
    public TreeMap<Integer,Publicacao> getPublicacoes() {return this.publicacoes;}
    public void setRegras(MyCalendar key,Regra regra) {this.getRegras().put(key, regra);}
    public void setVeiculos(String key,Veiculo veiculo) {this.getVeiculos().put(key, veiculo);}
    public void setDocentes(Long key,Docente docente) {this.getDocentes().put(key, docente);}
    public void setPublicacoes(int key,Publicacao publicacao) {this.getPublicacoes().put(new Integer(key), publicacao);}

    // To print with standard function
    @Override
    public String toString() {
        String str = "";
            str += "\n=-=-=-=-=-=-=- Imprimindo Docentes =-=-=-=-=-=-=-\n\n";
        for(Map.Entry<Long, Docente> e : this.getDocentes().entrySet())
            str += e.getValue().toString() + "\n";
            str += "\n=-=-=-=-=-=-=- Imprimindo Veículos =-=-=-=-=-=-=-\n\n";
        for(Map.Entry<String, Veiculo> e : this.getVeiculos().entrySet())
            str += e.getValue().toString() + "\n";
            str += "\n=-=-=-=-=-=-=- Imprimindo Publicações =-=-=-=-=-=-=-\n\n";
        for(Map.Entry<Integer, Publicacao> e : this.getPublicacoes().entrySet())
            str += e.getValue().toString() + "\n";
            str += "\n=-=-=-=-=-=-=- Imprimindo Regras =-=-=-=-=-=-=-\n\n";
        for(Map.Entry<MyCalendar, Regra> e : this.getRegras().entrySet())
            str += e.getValue().toString() + "\n";
        return str;
    }

    // Constructor
    public SistemaPPGI() {
        this.regras = new TreeMap<MyCalendar, Regra>();
        this.veiculos = new TreeMap<String, Veiculo>();
        this.docentes = new TreeMap<Long, Docente>();
        this.publicacoes = new TreeMap<Integer, Publicacao>();
    }

    // File ingest
    private void lerArquivoDocentes(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        String str = "";
        String[] strTok;
        scanner.nextLine(); // Ignora primeira linha

        while(scanner.hasNext()) {
            str = scanner.nextLine();
            strTok = str.split(";");
            if(strTok.length != 4 && strTok.length != 5)
                throw new IllegalArgumentException("Length '" + strTok.length + "'' not 4 or 5");

            long key = Long.parseLong(strTok[0]);
            Docente docente = new Docente(strTok[1], key, strTok[2], strTok[3], strTok.length == 5);
            this.setDocentes(new Long(key), docente);
        }
        scanner.close();
    }
    private void lerArquivoVeiculos(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        String str = "";
        String[] strTok;
        scanner.nextLine(); // Ignora primeira linha
        
        while(scanner.hasNext()) {
            Veiculo vei = null;
            str = scanner.nextLine();
            strTok = str.split(";");
            if(strTok.length != 4 && strTok.length != 5)
                throw new IllegalArgumentException("Sigla;Nome;Tipo;Impacto;ISSN|" + strTok.length);
            strTok[3] = strTok[3].replace(',', '.');    // Trata a vírgula
            switch(strTok[2]) {
                case "c":
                case "C":
                    vei = new Conferencia(strTok[1], strTok[0], Double.parseDouble(strTok[3]));
                break;
                case "p":
                case "P":
                    vei = new Periodico(strTok[1], strTok[0], Double.parseDouble(strTok[3]), strTok[4]);
                break;
                default:
                    throw new IllegalArgumentException(strTok[2] + " unrecognized on " + fileName);
            }
            this.setVeiculos(strTok[0], vei);
        }
        scanner.close();
    }
    private void lerArquivoPublicacoes(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        String str = "";
        String[] strTok;
        scanner.nextLine(); // Ignora primeira linha
        Publicacao pub;
        Veiculo vei;
        TreeMap<Long, Docente> docentes;
        Integer numero = null;

        while(scanner.hasNext()) {
            str = scanner.nextLine();
            strTok = str.split(";");
            if(strTok.length != 9)
                throw new IllegalArgumentException("Length '" + strTok.length + "'' not 9");
            switch(strTok[6]) {
                case "":
                    vei = this.getVeiculos().get(strTok[1]);
                    docentes = new TreeMap<Long, Docente>();
                    for(String s : strTok[3].split(",")) {
                        s = s.replace(" ", "");
                        long key = Long.parseLong(s);
                        docentes.put(key, this.getDocentes().get(key));
                    }
                    pub = new PubPeriodico(Integer.parseInt(strTok[0]), vei, strTok[2], docentes, Integer.parseInt(strTok[4]), Integer.parseInt(strTok[5]), Integer.parseInt(strTok[7]), Integer.parseInt(strTok[8]));
                break;
                default:
                    vei = this.getVeiculos().get(strTok[1]);
                    docentes = new TreeMap<Long, Docente>();
                    for(String s : strTok[3].split(",")) {
                        long key = Long.parseLong(s);
                        docentes.put(key, this.getDocentes().get(key));
                    }
                    numero = Integer.parseInt(strTok[4]);
                    pub = new PubConferencia(Integer.parseInt(strTok[0]), vei, strTok[2], docentes, numero, strTok[6], Integer.parseInt(strTok[7]), Integer.parseInt(strTok[8]));
            }
            this.setPublicacoes(numero, pub);
            vei.setPublicacao(numero.intValue(), pub);
        }
        scanner.close();
    }
    private void lerArquivoQualis(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        TreeMap<String, Veiculo> veiculos = this.getVeiculos();
        String str = "";
        String[] strTok;
        scanner.nextLine(); // Ignora primeira linha

        while(scanner.hasNext()) {
            str = scanner.nextLine();
            strTok = str.split(";");
            if(strTok.length != 3)
                throw new IllegalArgumentException("Length '" + strTok.length + "'' not 9");
            if(veiculos.get(strTok[1]) != null)
                veiculos.get(strTok[1]).setQualis(Integer.parseInt(strTok[0]), strTok[2]);
        }
        scanner.close();
    }
    private void lerArquivoRegras(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
    }

    // Força a chamada das leituras na ordem correta.
    public void lerArquivos(String fileDocentes, String fileVeiculos, String filePublicacoes, String fileQualis, String fileRegras) throws IOException, FileNotFoundException, IllegalArgumentException {
        this.lerArquivoDocentes(fileDocentes);
        this.lerArquivoVeiculos(fileVeiculos);
        this.lerArquivoPublicacoes(filePublicacoes);
        this.lerArquivoQualis(fileQualis);
    }

    // Reports
    public void printarRelatorioRecredenciamento(String filename) {
    }
    public void printarRelatorioPublicacoes(String filename) {
    }
    public void printarEstatisticas(String filename) {
    }
}