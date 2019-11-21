package sistema.util;

import sistema.Publicacao;

/**
  * Exception customizada para o Sistema PPGI.
 * (Basicamente um macro de mensagem, sim.)
 * @author Henrique Layber
 *
 */
public class InconsistenciaCodigoDocente extends Exception {
    public InconsistenciaCodigoDocente(Publicacao pub, String sigla) {
        super("Código de docente não definido usado na publicação não foi definido na planilha de publicação “" + pub.getTitulo() + "”: " + sigla + ".");
    }
}