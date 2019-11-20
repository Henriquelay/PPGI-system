package sistema.util;

import sistema.Publicacao;

/**
 * @author Henrique Coutinho Layber
 * @version 1.0
 * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 */
public class InconsistenciaCodigoDocente extends Exception {
    public InconsistenciaCodigoDocente(Publicacao pub, String sigla) {
        super("Código de docente não definido usado na publicação não foi definido na planilha de publicação “" + pub.getTitulo() + "”: " + sigla + ".");
    }
}