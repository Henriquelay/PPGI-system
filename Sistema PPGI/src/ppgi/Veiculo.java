package ppgi;

/**
 * Classe abstrata para implementação dos veículos
 */
public abstract class Veiculo {
    protected String titulo;
    protected String sigla;
    protected float fatorDeImpacto;

    public String getTitulo() {return this.titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getSigla() {return this.sigla;}
    public void setSigla(String sigla) {this.sigla = sigla;}
    public float getFatorDeImpacto() {return this.fatorDeImpacto;}
    public void setFatorDeImpacto(float fatorDeImpacto) {this.fatorDeImpacto = fatorDeImpacto;}

    @Override public String toString() {
        return "Título: " + this.getTitulo() + "\nSigla: " + this.getSigla() + "\nFator de Impacto: " + this.fatorDeImpacto;
    }
}