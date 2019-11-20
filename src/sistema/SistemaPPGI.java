package sistema;

import sistema.util.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
            try{
                str = scanner.nextLine();
                strTok = str.split(";");
                if(strTok.length != 4 && strTok.length != 5)
                    throw new IllegalArgumentException("Erro de formatação");
                for(String s : strTok)
                    s = s.trim();   // Remove whitespace from beggining and end. Both spaces and tab will be removed.

                long key = Long.parseLong(strTok[0]);
                if(this.getDocentes().containsKey(key))    // If key is already inserted
                    throw new InconsistenciaCodigo("Docente", Long.toString(key));
                Docente docente = new Docente(strTok[1], key, strTok[2], strTok[3], strTok.length == 5);
                this.getDocentes().put(new Long(key), docente);
            } catch (InconsistenciaCodigo e) {
                System.out.println(e);
            }
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
            try{
                Veiculo vei = null;
                str = scanner.nextLine();
                strTok = str.split(";");
                if(strTok.length != 4 && strTok.length != 5)
                    throw new IllegalArgumentException("Erro de formatação");
            for(String s : strTok)
                s = s.trim();   // Remove whitespace from beggining and end. Both spaces and tab will be removed.
            
                if(this.getVeiculos().containsKey(strTok[0]))
                    throw new InconsistenciaCodigo("Veículo", strTok[0]);
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
                    throw new InconsistenciaTipo(strTok[0], strTok[2]);
            }
            this.getVeiculos().put(strTok[0], vei);
            } catch (InconsistenciaCodigo e) {
                System.out.println(e);
            } catch (InconsistenciaTipo e) {
                System.out.println(e);
            }
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
            try {
                str = scanner.nextLine();
                strTok = str.split(";");
                if(strTok.length != 9)
                throw new IllegalArgumentException("Erro de formatação");
                for(String s : strTok)
                s = s.trim();   // Remove whitespace from beggining and end. Both spaces and tab will be removed.
                
                docentes = new TreeMap<Long, Docente>();
                vei = this.getVeiculos().get(strTok[1]);
                if(vei == null)
                throw new InconsistenciaSiglaVeiculoPublicacao(strTok[2], strTok[1]);
                for(String s : strTok[3].split(",")) {
                    s.trim();
                    long key = Long.parseLong(s);
                    docentes.put(key, this.getDocentes().get(key));
                }
                numero = Integer.parseInt(strTok[4]);
                switch(strTok[6]) {
                    case "":
                    pub = new PubPeriodico(Integer.parseInt(strTok[0]), vei, strTok[2], docentes, numero, Integer.parseInt(strTok[5]), Integer.parseInt(strTok[7]), Integer.parseInt(strTok[8]));
                    break;
                    default:
                    pub = new PubConferencia(Integer.parseInt(strTok[0]), vei, strTok[2], docentes, numero, strTok[6], Integer.parseInt(strTok[7]), Integer.parseInt(strTok[8]));
                }
                this.getPublicacoes().put(numero, pub);
                vei.getPublicacoes().put(numero, pub);
            } catch (InconsistenciaSiglaVeiculoPublicacao e) {
                System.out.println(e);
            }
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
            try{
                str = scanner.nextLine();
                strTok = str.split(";");
                if(strTok.length != 3)
                    throw new IllegalArgumentException("Erro de formatação");
                for(String s : strTok)
                    s = s.trim();   // Remove whitespace from beggining and end. Both spaces and tab will be removed.
                
                if(!this.getVeiculos().containsKey(strTok[1]))
                    throw new InconsistenciaSiglaVeiculoQualis(strTok[0], strTok[1]);
                if(!isValidQualis(strTok[2]))
                    throw new InconsistenciaQualisVeiculo(strTok[1], Integer.parseInt(strTok[0]), strTok[2]);
                veiculos.get(strTok[1]).getQualis().put(Integer.parseInt(strTok[0]), strTok[2]);
            } catch (InconsistenciaSiglaVeiculoQualis e) {
                System.out.println(e);
            } catch (InconsistenciaQualisVeiculo e) {
                System.out.println(e);
            }
        }
        scanner.close();
    }
    private void lerArquivoRegras(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        String str = "";
        String[] strTok;
        scanner.nextLine(); // Ignora primeira linha
        
        while(scanner.hasNext()) {
            try {
                str = scanner.nextLine();
                strTok = str.split(";");
                if(strTok.length != 7)
                    throw new IllegalArgumentException("Erro de formatação");
                for(String s : strTok)
                    s = s.trim();   // Remove whitespace from beggining and end. Both spaces and tab will be removed.
                strTok[4] = strTok[4].replace(",", ".");    // To read as double
                TreeMap<String, Integer> pontos = new TreeMap<String,Integer>();
                String[] qualis = strTok[2].split(",");
                String[] valorPontos = strTok[3].split(",");
                if(qualis.length != valorPontos.length)
                    throw new IllegalArgumentException("Erro de formatação");
                for(String s : qualis)
                    s = s.trim();
                for(String s : valorPontos)
                    s = s.trim();
                for(int i = 0; i < qualis.length; i++) {
                    if(!isValidQualis(qualis[i]))
                        throw new InconsistenciaQualisRegra(strTok[0], qualis[i]);
                    pontos.put(qualis[i], new Integer(Integer.parseInt(valorPontos[i])));
                }
                this.getRegras().put(MyCalendar.toDate(strTok[0]), new Regra(strTok[0], strTok[1], Integer.parseInt(strTok[5]), Double.parseDouble(strTok[4]), Double.parseDouble(strTok[6]), pontos));
            } catch (InconsistenciaQualisRegra e) {
                System.out.println(e);
            }
        }
        scanner.close();
    }
    
    // Força a chamada das leituras na ordem correta.
    public void lerArquivos(String fileDocentes, String fileVeiculos, String filePublicacoes, String fileQualis, String fileRegras) throws IOException, FileNotFoundException, IllegalArgumentException {
        this.lerArquivoDocentes(fileDocentes);
        this.lerArquivoVeiculos(fileVeiculos);
        this.lerArquivoPublicacoes(filePublicacoes);
        this.lerArquivoQualis(fileQualis);
        this.lerArquivoRegras(fileRegras);
    }
    
    // Reports
    public void printarRelatorioRecredenciamento(String fileName, int ano) throws IOException {
        FileWriter fw = new FileWriter(fileName);

        for(Map.Entry<Long,Docente> e : this.getDocentes().entrySet()) {
            fw.append((e.getValue()).toString() + "\n");
        }
        fw.close();
    }

    public void printarRelatorioPublicacoes(String fileName, int ano) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        LinkedList<Publicacao> ll = new LinkedList<Publicacao>();

        for(Map.Entry<Integer,Publicacao> e : this.getPublicacoes().entrySet())
            ll.add(e.getValue());

        ll.sort(Publicacao.ComparadorPublicacao);
        for(Publicacao p : ll) {
            fw.append(p.toCSV(ano));
        }
        fw.close();
    }

    public void printarEstatisticas(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);

        for(Map.Entry<Long,Docente> e : this.getDocentes().entrySet()) {
            fw.append((e.getValue()).toString() + "\n");
        }
        fw.close();
    }

    public void printarTodosArquivos(String fileNameRecred, String fileNamePub, String fileNameEst, int ano) throws IOException {
        this.printarRelatorioRecredenciamento(fileNameRecred, ano);
        this.printarRelatorioPublicacoes(fileNamePub, ano);
        this.printarEstatisticas(fileNameEst);
    }

    public void printarTodosArquivos(int ano) throws IOException {
        this.printarTodosArquivos("1-recredenciamento.csv", "2-publicacoes.csv", "3-estatisticas.csv", ano);
    }

    private static boolean isValidQualis(String s) {
        switch(s){
            case "A1":
            case "A2":
            case "B1":
            case "B2":
            case "B3":
            case "B4":
            case "B5":
            case "C":
                return true;
            default:
                return false;
        }
    }
}