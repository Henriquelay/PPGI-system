package sistema;

import sistema.Publicacao;
import java.util.TreeMap;

public class PubConferencia extends Publicacao {
    String local;

    // Getter e setter
    public String getLocal() {return this.local;}
    private void setLocal(String local) {this.local = local;}

    // Pra printar com função padrão
    @Override
    public String toString() {
        return super.toString() + 
            "\n╚Local:\t" + this.getLocal();
    }

    public PubConferencia(int ano, Veiculo veiculo, String titulo, int numero, String local, int pagInicial, int pagFinal) {
        super(ano, veiculo, titulo, numero, pagInicial, pagFinal);
        this.setLocal(local);
    }
    public PubConferencia(int ano, Veiculo veiculo, String titulo, TreeMap<Long, Docente> docentes, int numero, String local, int pagInicial, int pagFinal) {
        super(ano, veiculo, titulo, docentes, numero, pagInicial, pagFinal);
        this.setLocal(local);
    }
}