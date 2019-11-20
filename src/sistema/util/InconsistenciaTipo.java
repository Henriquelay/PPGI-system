package sistema.util;

public class InconsistenciaTipo extends Exception {
    public InconsistenciaTipo(String sigla, String tipo) {
        super("Tipo de veículo desconhecido para veículo " + sigla + "”: " + tipo + ".");     
    }
}