package sistema;

import java.util.Objects;

/**
 * Classe para implementação das publicação de docentes
 * @author Henrique Layber
 * @version 1.0
 */
public class Publicacao {
    private int ano;
    private String título;
    private int numero;

    // Getters e Setters
    public int getAno() {return this.ano;}
    public String getTítulo() {return this.título;}
    public void setAno(int ano) {this.ano = ano;}
    private int getNumero() {return this.numero;}
    private void setTítulo(String título) {this.título = título;}
    private void setNumero(int numero) {this.numero = numero;}

    // To compare with standard function
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Publicacao)) {
            return false;
        }
        Publicacao publicacao = (Publicacao) o;
        return ano == publicacao.ano && Objects.equals(título, publicacao.título) && numero == publicacao.numero;
    }

    // To print with standard function
    @Override
    public String toString() {
        return "{" +
            " ano='" + getAno() + "'" +
            ", título='" + getTítulo() + "'" +
            ", numero='" + getNumero() + "'" +
            "}";
    }

    // Constructor
    public Publicacao(int ano, String título, int numero) {
        this.setAno(ano);
        this.setTítulo(título);
        this.setNumero(numero);
    }
}