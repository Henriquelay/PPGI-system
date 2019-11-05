import java.util.Date;
import java.util.Map;

public class Regra implements Comparable {
    private int anosAvaliados;
    private float multPeriodicos;
    private float pontuacaoMinima;
    private Date dataInicio;
    private Date dataFinal;
    private Map<String,Integer> pontos;

    @Override public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override public String toString() {
        String str = "Data Início: " + this.dataInicio.toString() + " Data final: " + this.dataFinal.toString() + "\nPontuação mínima: " + this.pontuacaoMinima + "\nMultiplicador de periódicos: " + this.multPeriodicos + "\nAnos Avaliados: " + this.anosAvaliados + "\nPontos: ";

        for(Map.Entry<String,Integer> e : this.pontos.entrySet()) {
            str.concat(e.getKey() + ":" + e.getValue());
        }
        return str;
    }
}