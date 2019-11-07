package sistema;

import sistema.Veiculo;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe para implementação dos veículos tipo periódicos
 * @author Henrique Layber
 * @version 1.0
 */
public class Periodico extends Veiculo implements Serializable {
    private String issn;
    private int pagInicial;
    private int pagFinal;
    private int volume;

    // Getters and Setters
    public String getIssn() {return this.issn;}
    public int getPagInicial() {return this.pagInicial;}
    public int getPagFinal() {return this.pagFinal;}
    public int getVolume() {return this.volume;}
    private void setIssn(String issn) {this.issn = issn;}
    private void setVolume(int volume) {this.volume = volume;}
    // ? Blank means package-private.
    void setPagInicial(int pagInicial) {this.pagInicial = pagInicial;}
    void setPagFinal(int pagFinal) {this.pagFinal = pagFinal;}

    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Periodico)) {
            return false;
        }
        Periodico periodico = (Periodico) o;
        return Objects.equals(issn, periodico.issn) && pagInicial == periodico.pagInicial && pagFinal == periodico.pagFinal && volume == periodico.volume;
    }

    // To print with standard function
    @Override
    public String toString() {
        return super.toString() +
            " issn='" + getIssn() + "'" +
            ", pagInicial='" + getPagInicial() + "'" +
            ", pagFinal='" + getPagFinal() + "'" +
            ", volume='" + getVolume() + "'" +
            "}";
    }

    
    public Periodico(String titulo, String sigla, float fatorDeImpacto, String issn, int pagInicial, int pagFinal, int volume) {
        super(titulo, sigla, fatorDeImpacto);
        this.setIssn(issn);
        this.setPagInicial(pagInicial);
        this.setPagFinal(pagFinal);
        this.setVolume(volume);
    }
}