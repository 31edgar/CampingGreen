package prog2.model;

import prog2.model.Allotjament.Allotjament;

import java.io.Serializable;

public class Incidencia implements Serializable {
    public enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    }

    // Atributs
    private int numeroIncidencia_;
    private Allotjament allotjament_;
    private String data_;
    private TipusIncidencia tipusIncidencia_;

    // Constructor
    public Incidencia(int numeroIncidencia, TipusIncidencia tipusIncidencia, Allotjament allotjament, String data) {
        numeroIncidencia_ = numeroIncidencia;
        tipusIncidencia_ = tipusIncidencia;
        allotjament_ = allotjament;
        data_ = data;
    }

    // Getters
    public int getNumeroIncidencia() {
        return numeroIncidencia_;
    }

    public Allotjament getAllotjament() {
        return allotjament_;
    }

    public String getData() {
        return data_;
    }

    public TipusIncidencia getTipusIncidencia() {
        return tipusIncidencia_;
    }

    // Setters
    public void setNumeroIncidencia(int numeroIncidencia) {
        numeroIncidencia_ = numeroIncidencia;
    }

    public void setAllotjament(Allotjament allotjament) {
        allotjament_ = allotjament;
    }

    public void setData(String data) {
        data_ = data;
    }

    public void setTipusIncidencia(TipusIncidencia tipus) {
        tipusIncidencia_ = tipus;
    }

    // To string
    @Override
    public String toString(){
        return "NumeroIncidencia= " + numeroIncidencia_ + ", Allotjament= " + allotjament_ + ", Data= " + data_ +
                ", TipusIncidencia= " + tipusIncidencia_ + ".";
    }

    // Iluminació segons tipus incidència
    public String getIluminacioAllotjament() {
        // Retornarà 100%, 50% o 0% segons el tipus d'incidència
        return switch (tipusIncidencia_) {
            case Reparacio -> "100%";
            case Neteja -> "50%";
            case Tancament -> "0%";
        };
    }
}


