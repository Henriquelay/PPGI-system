package sistema.util;

import java.io.IOException;
import sistema.Publicacao;

public class InconsistenciaCodigoDocente extends IOException {
    private String titulo;
    private String sigla;

    @Override
    public String toString() {
        return "Código de docente não definido usado na publicação não foi definido na planilha de publicação “" + this.titulo + "”: " + this.sigla + ".";
    }

    public InconsistenciaCodigoDocente(Publicacao pub, String sigla) {
        this.titulo = pub.getTitulo();
        this.sigla = sigla;       
    }
}