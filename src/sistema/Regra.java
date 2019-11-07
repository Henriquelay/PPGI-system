package sistema;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Regra implements Comparable, Serializable {
    private int anosAvaliados;
    private float multPeriodicos;
    private float pontuacaoMinima;
    private Date dataInicio;
    private Date dataFinal;
    private Map<String,Integer> pontos;

    public int getAnosAvaliados() {return this.anosAvaliados;}
    public float getMultPeriodicos() {return this.multPeriodicos;}
    public float getPontuacaoMinima() {return this.pontuacaoMinima;}
    public Date getDataInicio() {return this.dataInicio;}
    public Date getDataFinal() {return this.dataFinal;}
    public Map<String,Integer> getPontos() {return this.pontos;}
    private void setAnosAvaliados(int anosAvaliados) {this.anosAvaliados = anosAvaliados;}
    private void setMultPeriodicos(float multPeriodicos) {this.multPeriodicos = multPeriodicos;}
    private void setPontuacaoMinima(float pontuacaoMinima) {this.pontuacaoMinima = pontuacaoMinima;}
    private void setDataInicio(Date dataInicio) {this.dataInicio = dataInicio;}
    private void setDataFinal(Date dataFinal) {this.dataFinal = dataFinal;}
    private void setPontos(Map<String,Integer> pontos) {this.pontos = pontos;}

    // To compare Regras. It returns the comparation of this dataInicio
    @Override public int compareTo(Object o) {
        return this.dataInicio.compareTo(((Regra)o).dataInicio);
    }

    // To print with standard function
    @Override public String toString() {
        String str = "Data Início: " + this.dataInicio.toString() + " Data final: " + this.dataFinal.toString() + "\nPontuação mínima: " + this.pontuacaoMinima + "\nMultiplicador de periódicos: " + this.multPeriodicos + "\nAnos Avaliados: " + this.anosAvaliados + "\nPontos: ";

        // Iterating through the map
        for(Map.Entry<String,Integer> e : this.pontos.entrySet()) {
            str.concat(e.getKey() + ":" + e.getValue());
        }
        return str;
    }

    // Constructor
    public Regra(Date dataInicio, Date dataFinal, int anosAvaliados, float multPeriodicos, float pontuacaoMinima, Map<String,Integer> pontos) {
        this.setDataInicio(dataInicio);
        this.setDataFinal(dataFinal);
        this.setAnosAvaliados(anosAvaliados);
        this.setMultPeriodicos(multPeriodicos);
        this.setPontuacaoMinima(pontuacaoMinima);
        this.setPontos(pontos);
    }
}