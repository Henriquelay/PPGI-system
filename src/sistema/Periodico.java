package sistema;

import sistema.Veiculo;

/**
 * Classe para implementação dos veículos tipo periódicos
 * @author Henrique Layber
 *
 */
public class Periodico extends Veiculo {
    private String issn;

    // Getters and Setters
    public char getTipo() {return 'P';}
    public String getIssn() {return this.issn;}
    private void setIssn(String issn) {this.issn = issn;}


    // To print with standard function
    @Override
    public String toString() {
        return super.toString() +
            "\n╚ISSN:\t\t" + this.getIssn();
    }

    
    public Periodico(String titulo, String sigla, double fatorDeImpacto, String issn) {
        super(titulo, sigla, fatorDeImpacto);
        this.setIssn(issn);
    }
}