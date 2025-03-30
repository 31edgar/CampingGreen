package prog2.model.Allotjament;

import java.io.Serializable;

/**
 * Classe abstracta que representa una casa al camping.
 * <p>
 * Aquesta classe abstracta hereta de Allotjament i afegeix característiques
 * específiques de les cases com ara mida, habitacions i capacitat de persones.
 * Serveix com a base per a tipus d'allotjaments que són cases (bungalows, etc.).
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Allotjament
 * @since 1.0
 */
public abstract class Casa extends Allotjament implements Serializable {
    //Atributs Casa
    private float mida_;
    private int habitacions_;
    private int placesPersones_;

    /**
     * Constructor principal per a una casa.
     *
     * @param nom Nom descriptiu de la casa
     * @param idAllotjament Identificador únic de la casa
     * @param estadaMinimaALTA Estada mínima en temporada alta (en dies)
     * @param estadaMinimaBAIXA Estada mínima en temporada baixa (en dies)
     * @param estatAllotjament Estat operatiu de la casa
     * @param estatIluminacio Nivell d'il·luminació de la casa
     * @param mida Mida de la casa en metres quadrats
     * @param habitacions Nombre d'habitacions de la casa
     * @param placesPersones Capacitat de persones de la casa
     */
    public Casa(String nom, String idAllotjament, long estadaMinimaALTA,
                long estadaMinimaBAIXA, boolean estatAllotjament,
                String estatIluminacio, float mida, int habitacions,
                int placesPersones) {
        super(nom, idAllotjament, estadaMinimaALTA, estadaMinimaBAIXA,
                estatAllotjament, estatIluminacio);
        this.mida_ = mida;
        this.habitacions_ = habitacions;
        this.placesPersones_ = placesPersones;
    }

    // Mètodes accessors

    /**
     * Obté la mida de la casa.
     * @return Mida en metres quadrats
     */
    public float getMida() {
        return mida_;
    }

    /**
     * Estableix la mida de la casa.
     * @param mida Nova mida en metres quadrats
     */
    public void setMida(float mida) {
        this.mida_ = mida;
    }

    /**
     * Obté el nombre d'habitacions de la casa.
     * @return Nombre d'habitacions
     */
    public int getHabitacions() {
        return habitacions_;
    }

    /**
     * Estableix el nombre d'habitacions de la casa.
     * @param habitacions Nou nombre d'habitacions
     */
    public void setHabitacions(int habitacions) {
        this.habitacions_ = habitacions;
    }

    /**
     * Obté la capacitat de persones de la casa.
     * @return Nombre de places per a persones
     */
    public int getPlacesPersones() {
        return placesPersones_;
    }

    /**
     * Estableix la capacitat de persones de la casa.
     * @param placesPersones Nova capacitat de persones
     */
    public void setPlacesPersones(int placesPersones) {
        this.placesPersones_ = placesPersones;
    }

    /**
     * Retorna una representació en format String de la casa.
     * @return String amb tota la informació de la casa
     */
    @Override
    public String toString() {
        return super.toString() + "Casa{mida=" + mida_ + ", habitacions=" +
                habitacions_ + ", placesPersones=" + placesPersones_ + "}";
    }
}