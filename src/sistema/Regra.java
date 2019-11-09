package sistema;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe para implementação das Regras de avaliação PPGI
 * @author Henrique Layber
 * @version 1.0
 */
public class Regra implements Comparable<Regra>, Serializable {
    private int anosAvaliados;
    private float multPeriodicos;
    private float pontuacaoMinima;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFinal;
    private TreeMap<String,Integer> pontos;


    public int getAnosAvaliados() {return this.anosAvaliados;}
    public float getMultPeriodicos() {return this.multPeriodicos;}
    public float getPontuacaoMinima() {return this.pontuacaoMinima;}
    public GregorianCalendar getDataInicio() {return this.dataInicio;}
    public GregorianCalendar getDataFinal() {return this.dataFinal;}
    public TreeMap<String,Integer> getPontos() {return this.pontos;}
    private void setAnosAvaliados(int anosAvaliados) {this.anosAvaliados = anosAvaliados;}
    private void setMultPeriodicos(float multPeriodicos) {this.multPeriodicos = multPeriodicos;}
    private void setPontuacaoMinima(float pontuacaoMinima) {this.pontuacaoMinima = pontuacaoMinima;}
    /**
     * 
     * @deprecated
     */
    private void setDataInicio(GregorianCalendar dataInicio) {this.dataInicio = dataInicio;}
    /**
     * 
     * @param dataInicio dd/mm/aaaa
     */
    private void setDataInicio(String dataInicio) throws IllegalArgumentException {
        String[] datePart = dataInicio.split("/");
        if(datePart.length != 3)
            throw new IllegalArgumentException(dataInicio);
        this.dataInicio = new GregorianCalendar(Integer.parseInt(datePart[2]), Integer.parseInt(datePart[1]), Integer.parseInt(datePart[0])) {
            @Override
            public String toString() {
                return this.get(Calendar.DAY_OF_MONTH) + "/" + this.get(Calendar.MONTH) + "/" + this.get(Calendar.YEAR);
            }
        };
    }
    /**
     * 
     * @deprecated
     */
    private void setDataFinal(GregorianCalendar dataFinal) {this.dataFinal = dataFinal;}
    /**
     * 
     * @param dataFinal dd/mm/aaaa
     */
    private void setDataFinal(String dataFinal) throws IllegalArgumentException {
        String[] datePart = dataFinal.split("/");
        if(datePart.length != 3)
            throw new IllegalArgumentException(dataFinal);
        this.dataFinal = new GregorianCalendar(Integer.parseInt(datePart[2]), Integer.parseInt(datePart[1]), Integer.parseInt(datePart[0])) {
            @Override
            public String toString() {
                return this.get(Calendar.DAY_OF_MONTH) + "/" + this.get(Calendar.MONTH) + "/" + this.get(Calendar.YEAR);
            }
        };
    }
    private void setPontos(String qualis, int pontos) {
        this.getPontos().put(qualis, new Integer(pontos));
    }

    // To compare Regras. It returns the comparation of this dataInicio
    @Override public int compareTo(Regra r) {
        return this.getDataInicio().compareTo(r.getDataInicio());
    }

    // To print with standard function
    @Override public String toString() {
        String str = "Data Início: " + this.getDataInicio().toString() +
        " Data final: " + this.getDataFinal().toString() +
        "\nPontuação mínima: " + this.getPontuacaoMinima() +
        "\nMultiplicador de periódicos: " + this.getMultPeriodicos() + "\nAnos Avaliados: " + this.getAnosAvaliados() + "\nPontos: ";

        // Iterating through the Treemap
        for(Map.Entry<String,Integer> e : this.getPontos().entrySet()) {
            str.concat(e.getKey() + ":" + e.getValue());
        }
        return str;
    }

    // Constructor
    /**
     * @deprecated
     */
    public Regra(GregorianCalendar dataInicio, GregorianCalendar dataFinal, int anosAvaliados, float multPeriodicos, float pontuacaoMinima) {
        this.setDataInicio(dataInicio);
        this.setDataFinal(dataFinal);
        this.setAnosAvaliados(anosAvaliados);
        this.setMultPeriodicos(multPeriodicos);
        this.setPontuacaoMinima(pontuacaoMinima);
    }
    public Regra(String dataInicio, String dataFinal, int anosAvaliados, float multPeriodicos, float pontuacaoMinima) {
        this.setDataInicio(dataInicio);
        this.setDataFinal(dataFinal);
        this.setAnosAvaliados(anosAvaliados);
        this.setMultPeriodicos(multPeriodicos);
        this.setPontuacaoMinima(pontuacaoMinima);
        this.pontos = new TreeMap<String,Integer>();
    }
}