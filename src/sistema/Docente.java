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
    private void setDataNascimento(MyCalendar dataNascimento) {this.dataNascimento = dataNascimento;}
    private void setDataIngresso(MyCalendar dataIngresso) {this.dataIngresso = dataIngresso;}
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
        return "Nome: " + getNome() +
            "\nCodigo: " + getCodigo() +
            "\nData de nascimento: " + getDataNascimento() +
            "\nData de ingresso: " + getDataIngresso() +
            "\nCoodenador? " + isIsCoodenador();
    }
    
    // Constructor
    public Docente(String nome, int codigo, MyCalendar dataNascimento, MyCalendar dataIngresso, boolean isCoodenador) {
        this.nome = nome;
        this.codigo = codigo;
        this.dataNascimento = dataNascimento;
        this.dataIngresso = dataIngresso;
        this.isCoodenador = isCoodenador;
    }
}