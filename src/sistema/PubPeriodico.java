package sistema;

import sistema.Publicacao;
import java.util.TreeMap;

/**
 * Classe para implementação das publicação em periódicos de docentes
 * @author Henrique Layber
 *
 */
public class PubPeriodico extends Publicacao {
    int volume;

    // Getter e setter
    public int getVolume() {return this.volume;}
    @Override
    public char getTipo() {return 'P';}
    private void setVolume(int volume) {this.volume = volume;}

    // Pra printar com função padrão
    @Override
    public String toString() {
        return super.toString() + 
            "\n╚Volume:\t" + this.getVolume();
    }

    public PubPeriodico(int ano, Veiculo veiculo, String titulo, int numero, int volume, int pagInicial, int pagFinal) {
        super(ano, veiculo, titulo, numero, pagInicial, pagFinal);
        this.setVolume(volume);
    }
    public PubPeriodico(int ano, Veiculo veiculo, String titulo, TreeMap<Long, Docente> docentes, int numero, int volume, int pagInicial, int pagFinal) {
        super(ano, veiculo, titulo, docentes, numero, pagInicial, pagFinal);
        this.setVolume(volume);
    }
}