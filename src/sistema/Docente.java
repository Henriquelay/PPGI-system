package sistema;

import java.io.Serializable;
import sistema.util.*;
import java.util.Objects;

/**
 * Classe para implementação dos docentes PPGI
 * @author Henrique Layber
 * @version 1.0
 */
public class Docente implements Serializable {
    private String nome;
    private int codigo;
    private MyCalendar dataNascimento;
    private MyCalendar dataIngresso;
    private boolean isCoodenador;

    // Getters and Setters
    public String getNome() {return this.nome;}
    public int getCodigo() {return this.codigo;}
    public MyCalendar getDataNascimento() {return this.dataNascimento;}
    public MyCalendar getDataIngresso() {return this.dataIngresso;}
    public boolean getIsCoodenador() {return this.isCoodenador;}
    private void setNome(String nome) {this.nome = nome;}
    private void setCodigo(int codigo) {this.codigo = codigo;}
    private void setDataIngresso(MyCalendar dataIngresso) {this.dataIngresso = dataIngresso;}
    private void setDataNascimento(MyCalendar dataNascimento) {this.dataNascimento = dataNascimento;}
    private void setDataIngresso(String dataIngresso) throws IllegalArgumentException{this.setDataIngresso(MyCalendar.toDate(dataIngresso));}
    private void setDataNascimento(String dataNascimento) throws IllegalArgumentException{this.setDataNascimento(MyCalendar.toDate(dataNascimento));}
    private boolean isIsCoodenador() {return this.isCoodenador;}
    private void setIsCoodenador(boolean isCoodenador) {this.isCoodenador = isCoodenador;}
    
    // To compare with standard function
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
            if (!(o instanceof Docente)) {
            return false;
        }
        Docente docente = (Docente) o;
        return Objects.equals(nome, docente.nome) && codigo == docente.codigo && Objects.equals(dataNascimento, docente.dataNascimento) && Objects.equals(dataIngresso, docente.dataIngresso) && isCoodenador == docente.isCoodenador;
    }

    // To print with standard function
    @Override
    public String toString() {
        return "Nome: " + this.getNome() +
            "\n╠Codigo: " + this.getCodigo() +
            "\n╠Data de nascimento: " + this.getDataNascimento() +
            "\n╠Data de ingresso: " + this.getDataIngresso() +
            "\n╚Coodenador? " + this.isIsCoodenador();
    }
    
    // Constructor
    /**
     * @deprecated
     * @param nome string
     * @param codigo int
     * @param dataNascimento MyCalendar
     * @param dataIngresso MyCalendar
     * @param isCoodenador bool
     */
    public Docente(String nome, int codigo, MyCalendar dataNascimento, MyCalendar dataIngresso, boolean isCoodenador) {
        this.setNome(nome);
        this.setCodigo(codigo);
        this.setDataNascimento(dataNascimento);
        this.setDataIngresso(dataIngresso);
        this.setIsCoodenador(isCoodenador);
    }

    /**
     * @param nome String
     * @param codigo int
     * @param dataNascimento String
     * @param dataIngresso String
     * @param isCoodenador bool
     */
    public Docente(String nome, int codigo, String dataNascimento, String dataIngresso, boolean isCoodenador) {
        this.setNome(nome);
        this.setCodigo(codigo);
        this.setDataNascimento(dataNascimento);
        this.setDataIngresso(dataIngresso);
        this.setIsCoodenador(isCoodenador);
    }
}