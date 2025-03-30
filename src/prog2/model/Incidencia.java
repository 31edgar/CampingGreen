package prog2.model;

import prog2.model.Allotjament.Allotjament;
import java.io.Serializable;

/**
 * Classe que representa una incidència registrada en un allotjament del camping.
 * <p>
 * Aquesta classe conté informació sobre incidències que poden afectar els allotjaments,
 * com ara reparacions, neteges o tancaments. Cada incidència té associat un tipus,
 * una data, un número identificatiu i l'allotjament afectat.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Allotjament
 * @since 1.0
 */
public class Incidencia implements Serializable {

    /**
     * Enumeració que representa els diferents tipus d'incidències possibles.
     */
    public enum TipusIncidencia {
        /** Incidència de tipus reparació */
        Reparacio,
        /** Incidència de tipus neteja */
        Neteja,
        /** Incidència de tipus tancament */
        Tancament
    }

    // Atributs
    private int numeroIncidencia_;
    private Allotjament allotjament_;
    private String data_;
    private TipusIncidencia tipusIncidencia_;

    /**
     * Constructor principal per a una incidència.
     *
     * @param numeroIncidencia Número identificatiu de la incidència
     * @param tipusIncidencia Tipus d'incidència (Reparacio, Neteja o Tancament)
     * @param allotjament Allotjament afectat per la incidència
     * @param data Data en què es registra la incidència
     */
    public Incidencia(int numeroIncidencia, TipusIncidencia tipusIncidencia,
                      Allotjament allotjament, String data) {
        numeroIncidencia_ = numeroIncidencia;
        tipusIncidencia_ = tipusIncidencia;
        allotjament_ = allotjament;
        data_ = data;
    }

    /**
     * Obté el número identificatiu de la incidència.
     * @return Número de la incidència
     */
    public int getNumeroIncidencia() {
        return numeroIncidencia_;
    }

    /**
     * Obté l'allotjament afectat per la incidència.
     * @return Allotjament associat a la incidència
     */
    public Allotjament getAllotjament() {
        return allotjament_;
    }

    /**
     * Obté la data de registre de la incidència.
     * @return Data de la incidència
     */
    public String getData() {
        return data_;
    }

    /**
     * Obté el tipus d'incidència.
     * @return TipusIncidencia (Reparacio, Neteja o Tancament)
     */
    public TipusIncidencia getTipusIncidencia() {
        return tipusIncidencia_;
    }

    /**
     * Estableix el número identificatiu de la incidència.
     * @param numeroIncidencia Nou número per a la incidència
     */
    public void setNumeroIncidencia(int numeroIncidencia) {
        numeroIncidencia_ = numeroIncidencia;
    }

    /**
     * Estableix l'allotjament afectat per la incidència.
     * @param allotjament Nou allotjament associat
     */
    public void setAllotjament(Allotjament allotjament) {
        allotjament_ = allotjament;
    }

    /**
     * Estableix la data de registre de la incidència.
     * @param data Nova data per a la incidència
     */
    public void setData(String data) {
        data_ = data;
    }

    /**
     * Estableix el tipus d'incidència.
     * @param tipus Nou tipus d'incidència
     */
    public void setTipusIncidencia(TipusIncidencia tipus) {
        tipusIncidencia_ = tipus;
    }

    /**
     * Retorna una representació en format String de la incidència.
     * @return String amb tota la informació de la incidència
     */
    @Override
    public String toString(){
        return "NumeroIncidencia= " + numeroIncidencia_ + ", Allotjament= " + allotjament_ +
                ", Data= " + data_ + ", TipusIncidencia= " + tipusIncidencia_ + ".";
    }

    /**
     * Determina el nivell d'il·luminació de l'allotjament segons el tipus d'incidència.
     * <p>
     * Els valors retornats són:
     * <ul>
     *   <li>100% per a incidències de tipus Reparacio</li>
     *   <li>50% per a incidències de tipus Neteja</li>
     *   <li>0% per a incidències de tipus Tancament</li>
     * </ul>
     * @return String amb el percentatge d'il·luminació corresponent
     */
    public String getIluminacioAllotjament() {
        return switch (tipusIncidencia_) {
            case Reparacio -> "100%";
            case Neteja -> "50%";
            case Tancament -> "0%";
        };
    }
}