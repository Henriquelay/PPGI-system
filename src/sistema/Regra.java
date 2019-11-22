package sistema;

import sistema.util.MyCalendar;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe para implementação das Regras de avaliação PPGI
 * @author Henrique Layber
 *
 */
public class Regra implements Serializable {
    private int anosAvaliados;
    private double multPeriodicos;
    private double pontuacaoMinima;
    private MyCalendar dataInicio;
    private MyCalendar dataFinal;
    private TreeMap<String,Integer> pontos;


    public int getAnosAvaliados() {return this.anosAvaliados;}
    public double getMultPeriodicos() {return this.multPeriodicos;}
    public double getPontuacaoMinima() {return this.pontuacaoMinima;}
    public MyCalendar getDataInicio() {return this.dataInicio;}
    public MyCalendar getDataFinal() {return this.dataFinal;}
    public TreeMap<String,Integer> getPontos() {return this.pontos;}
    private void setAnosAvaliados(int anosAvaliados) {this.anosAvaliados = anosAvaliados;}
    private void setMultPeriodicos(double multPeriodicos) {this.multPeriodicos = multPeriodicos;}
    private void setPontuacaoMinima(double pontuacaoMinima) {this.pontuacaoMinima = pontuacaoMinima;}
    /**
     * @deprecated
     */
    private void setDataInicio(MyCalendar dataInicio) {this.dataInicio = dataInicio;}
    /**
     * @param dataInicio <code>dd/mm/aaaa</code>
     */
    private void setDataInicio(String dataInicio) throws IllegalArgumentException {this.setDataInicio(MyCalendar.toDate(dataInicio));}
    /**
     * @deprecated
     */
    private void setDataFinal(MyCalendar dataFinal) {this.dataFinal = dataFinal;}
    /**
     * @param dataFinal <code>dd/mm/aaaa</code>
     */
    private void setDataFinal(String dataFinal) throws IllegalArgumentException {this.setDataFinal(MyCalendar.toDate(dataFinal));}
    public void setPontos(String qualis, int pontos) {
        this.getPontos().put(qualis, new Integer(pontos));
    }

    /**
     *  To print with standard function
     */
    @Override
    public String toString() {
        String str = "Data Início:\t" + this.getDataInicio() + " Data final: " + this.getDataFinal() +
        "\n╠Pontuação mínima:\t" + this.getPontuacaoMinima() +
        "\n╠Mult. periódicos:\t" + this.getMultPeriodicos() +
        "\n╠Pontos";
        // Iterating through the Treemap
        for(Map.Entry<String,Integer> e : this.getPontos().entrySet()) {
            str += "\n╠═" + e.getKey() + ":" + e.getValue();
        }
        
        str += "\n╚Anos Avaliados:\t" + this.getAnosAvaliados();

        return str;
    }

    // Constructors
    /**
     * @deprecated
     * @param dataInicio <code>MyCalendar</code>
     * @param dataFinal <code>MyCalendar</code>
     * @param anosAvaliados int
     * @param multPeriodicos double
     * @param pontuacaoMinima double
     */
    public Regra(MyCalendar dataInicio, MyCalendar dataFinal, int anosAvaliados, double multPeriodicos, double pontuacaoMinima) {
        this.setDataInicio(dataInicio);
        this.setDataFinal(dataFinal);
        this.setAnosAvaliados(anosAvaliados);
        this.setMultPeriodicos(multPeriodicos);
        this.setPontuacaoMinima(pontuacaoMinima);
    }
    /**
     * 
     * @param dataInicio <code>"dd/mm/aaaa"</code>
     * @param dataFinal <code>"dd/mm/aaaa"</code>
     * @param anosAvaliados int
     * @param multPeriodicos double
     * @param pontuacaoMinima double
     * @param pontos TreeMap<String, Integer>
     */
    public Regra(String dataInicio, String dataFinal, int anosAvaliados, double multPeriodicos, double pontuacaoMinima, TreeMap<String, Integer> pontos) {
        this.setDataInicio(dataInicio);
        this.setDataFinal(dataFinal);
        this.setAnosAvaliados(anosAvaliados);
        this.setMultPeriodicos(multPeriodicos);
        this.setPontuacaoMinima(pontuacaoMinima);
        this.pontos = pontos;
    }
}