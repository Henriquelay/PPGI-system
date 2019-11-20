package sistema.util;

import sistema.Publicacao;

public class InconsistenciaCodigoDocente extends Exception {
    public InconsistenciaCodigoDocente(Publicacao pub, String sigla) {
        super("Código de docente não definido usado na publicação não foi definido na planilha de publicação “" + pub.getTitulo() + "”: " + sigla + ".");
    }
}