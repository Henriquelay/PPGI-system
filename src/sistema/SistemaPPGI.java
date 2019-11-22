package sistema;

import sistema.util.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
* Classe para implementação do sistema de controle PPGI.
* É aqui que o pau quebra, o espaguete acontece, o compilador chora e mãe não vê.
* @author Henrique Layber
* 
*/
public class SistemaPPGI implements Serializable {
    // Relations
    private TreeMap<Integer, Regra> regras;    // Ano início, Regras
    private TreeMap<String, Veiculo> veiculos;  // Sigla, Veiculos
    private TreeMap<Long, Docente> docentes; // Código docente, Docentes
    private TreeMap<String, Publicacao> publicacoes; // Título, Publicacao
    
    // Getters e Setters
    public TreeMap<Integer,Regra> getRegras() {return this.regras;}
    public TreeMap<String,Veiculo> getVeiculos() {return this.veiculos;}
    public TreeMap<Long,Docente> getDocentes() {return this.docentes;}
    public TreeMap<String,Publicacao> getPublicacoes() {return this.publicacoes;}
    
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
        for(Map.Entry<String, Publicacao> e : this.getPublicacoes().entrySet())
        str += e.getValue().toString() + "\n";
        str += "\n=-=-=-=-=-=-=- Imprimindo Regras =-=-=-=-=-=-=-\n\n";
        for(Map.Entry<Integer, Regra> e : this.getRegras().entrySet())
        str += e.getValue().toString() + "\n";
        return str;
    }
    
    // Constructor
    public SistemaPPGI() {
        this.regras = new TreeMap<Integer, Regra>();
        this.veiculos = new TreeMap<String, Veiculo>();
        this.docentes = new TreeMap<Long, Docente>();
        this.publicacoes = new TreeMap<String, Publicacao>();
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            } catch (InconsistenciaTipo e) {
                System.out.println(e.getMessage());
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
                switch(strTok[6]) {
                    case "":
                        pub = new PubPeriodico(Integer.parseInt(strTok[0]), vei, strTok[2], docentes, Integer.parseInt(strTok[4]), Integer.parseInt(strTok[5]), Integer.parseInt(strTok[7]), Integer.parseInt(strTok[8]));
                    break;
                    default:
                        pub = new PubConferencia(Integer.parseInt(strTok[0]), vei, strTok[2], docentes, Integer.parseInt(strTok[4]), strTok[6], Integer.parseInt(strTok[7]), Integer.parseInt(strTok[8]));
                }
                this.getPublicacoes().put(strTok[2], pub);
                vei.getPublicacoes().put(strTok[2], pub);
                for(Map.Entry<Long,Docente> e : docentes.entrySet()) {
                    e.getValue().getPublicacoes().put(strTok[2], pub);
                }
                strTok = null;
            } catch (InconsistenciaSiglaVeiculoPublicacao e) {
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            } catch (InconsistenciaQualisVeiculo e) {
                System.out.println(e.getMessage());
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
                this.getRegras().put(new Integer(strTok[0].split("/")[2]), new Regra(strTok[0], strTok[1], Integer.parseInt(strTok[5]), Double.parseDouble(strTok[4]), Double.parseDouble(strTok[6]), pontos));
            } catch (InconsistenciaQualisRegra e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
    
    // Força a chamada das leituras na ordem correta.
    public void lerArquivos(String fileDocentes, String fileVeiculos, String filePublicacoes, String fileQualis, String fileRegras, int opMode) throws IOException, FileNotFoundException, IllegalArgumentException {
        if(opMode == 2) return;
        this.lerArquivoDocentes(fileDocentes);
        this.lerArquivoVeiculos(fileVeiculos);
        this.lerArquivoPublicacoes(filePublicacoes);
        this.lerArquivoQualis(fileQualis);
        this.lerArquivoRegras(fileRegras);
        
        // Serialization
        if(opMode == 1) {
            try {
                FileOutputStream fos = new FileOutputStream("SistemaPPGI.ser");
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(this);
                out.close();
                fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Reports
    public void printarRelatorioRecredenciamento(String fileName, int anoRegra) throws IOException {
        FileWriter fw = new FileWriter(fileName);

        LinkedList<Docente> lld = new LinkedList<Docente>(this.getDocentes().values());
        lld.sort(Docente.ComparadorDocente);

        fw.append("Docente;Pontuação;Recredenciado?\n");

        for(Docente doc : lld) {
            fw.append(doc.getNome() + ";");

            // Pontos {
            double pontosdoc = 0;
            Regra regra = this.selectRegra(anoRegra);
            if(regra != null) {
                for(Publicacao pub : doc.getPublicacoes().values()) {
                    if(pub.getAno() < anoRegra - regra.getAnosAvaliados() || pub.getAno() > anoRegra)
                        continue;
                    String qualis = pub.getVeiculo().getQualis().floorEntry(anoRegra).getValue();
                    double pontospub = regra.getPontos().floorEntry(qualis).getValue();
                    if(pub.getTipo() == 'P')
                        pontospub *= regra.getMultPeriodicos();
                    pontosdoc += pontospub;
                }
                String pontos = String.format("%.1f", pontosdoc);
                fw.append(pontos.replace(".", ",") + ";");
            }
            // } Pontos
            // Resultado {
            if(doc.getIsCoodenador()) {
                fw.append("Coordenador\n");
            } else {
                if(anoRegra - doc.getDataIngresso().get(MyCalendar.YEAR) < 3) {
                    fw.append("PPJ\n");
                } else {
                    if(anoRegra - doc.getDataNascimento().get(MyCalendar.YEAR) >= 60) {
                        fw.append("PPS\n");
                    } else {
                        if(pontosdoc >= regra.getPontuacaoMinima())
                            fw.append("Sim\n");
                        else
                            fw.append("Não\n");
                    }
                }
            }


        }
        fw.close();
    }

    public void printarRelatorioPublicacoes(String fileName, int ano) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        LinkedList<Publicacao> ll = new LinkedList<Publicacao>();
        fw.append("Ano;Sigla Veículo;Veículo;Qualis;Fator de Impacto;Título;Docentes\n");

        for(Map.Entry<String,Publicacao> e : this.getPublicacoes().entrySet())
            ll.add(e.getValue());

        ll.sort(Publicacao.ComparadorPublicacao);

        for(Publicacao p : ll)
            fw.append(p.toCSV(ano));

        fw.close();
    }

    public void printarEstatisticas(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);

        TreeMap<String,LinkedList<Publicacao>> data = new TreeMap<String,LinkedList<Publicacao>>();
        // <Qualis,<Publicacao>>

        fw.append("Qualis;Qtd. Artigos;Média Artigos / Docente\n");
        // Data structure filling
        for(Map.Entry<String,Veiculo> eV : this.getVeiculos().entrySet()) {
            for(Map.Entry<Integer,String> eQ : eV.getValue().getQualis().entrySet()) {
                LinkedList<Publicacao> ll = new LinkedList<Publicacao>();
                ll.addAll(eV.getValue().getPublicacoes().values());
                if(data.containsKey(eQ.getValue())) {
                    data.get(eQ.getValue()).addAll(ll);
                } else {
                    data.put(eQ.getValue(), ll);
                }
            }
        }

        // Print
        for(Map.Entry<String,LinkedList<Publicacao>> e : data.entrySet()) {
            LinkedList<Publicacao> llP = e.getValue();
            int qtdArtigos = llP.size();
            fw.append(e.getKey() + ";" + qtdArtigos + ";");
            double artigosPorDocente = 0;
            for(Publicacao p : llP) {
                artigosPorDocente += (double) 1 / (double) p.getDocentes().size();
            }
            fw.append(String.format("%.2f", artigosPorDocente).replace(".", ",") + "\n");
        }

        fw.close();
    }

    public void printarTodosArquivos(String fileNameRecred, String fileNamePub, String fileNameEst, int ano, int opMode) throws IOException {
        if(opMode == 1) return;
        SistemaPPGI sys = this;

        // Serialization
        if(opMode == 2) {
            String filepath = "SistemaPPGI.ser";
            try {
                FileInputStream fis = new FileInputStream(filepath);
                ObjectInputStream in = new ObjectInputStream(fis);
                sys = (SistemaPPGI) in.readObject();
                in.close();
                fis.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException c) {
                System.out.println("SistemaPPGI não encontrado em " + filepath);
                return;
            }
        }

        sys.printarRelatorioRecredenciamento(fileNameRecred, ano);
        sys.printarRelatorioPublicacoes(fileNamePub, ano);
        sys.printarEstatisticas(fileNameEst);
    }

    public void printarTodosArquivos(int ano, int opMode) throws IOException {
        if(opMode == 1) return;
        this.printarTodosArquivos("1-recredenciamento.csv", "2-publicacoes.csv", "3-estatisticas.csv", ano, opMode);
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

    /**
     * Seleciona a Regra em vigência para o ano passado.
     * Considerações:
     * As datas de início e fim da regra são o início e o fim do ano;
     * @author Henrique Layber
     * @param anoInt
     * @return
     */
    private Regra selectRegra(int anoInt) {
        Map.Entry<Integer,Regra> selected = this.getRegras().floorEntry(anoInt);
        if(selected == null)
            return null;
        if(selected.getValue().getDataFinal().get(MyCalendar.YEAR) >= anoInt)
            return selected.getValue();
        return null;
    }

}