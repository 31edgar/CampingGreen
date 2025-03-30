package prog2.model.Allotjament;

import java.io.Serializable;

/**
 * Classe que representa un bungalow al camping.
 * <p>
 * Aquesta classe hereta de Casa i afegeix característiques específiques
 * dels bungalows com places de pàrquing, terrassa i equipaments.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Casa
 * @since 1.0
 */
public class Bungalow extends Casa implements Serializable {
    //Atributs Bungalow
    private int placesParquing_;
    private boolean terrassa_;
    private boolean tv_;
    private boolean aireFred_;

    /**
     * Constructor principal per a un bungalow.
     *
     * @param nom Nom descriptiu del bungalow
     * @param idAllotjament Identificador únic del bungalow
     * @param estatAllotjament Estat operatiu del bungalow
     * @param estatIluminacio Nivell d'il·luminació del bungalow
     * @param mida Mida del bungalow en metres quadrats
     * @param habitacions Nombre d'habitacions del bungalow
     * @param placesPersones Capacitat de persones del bungalow
     * @param placesParquing Places de pàrquing disponibles
     * @param terrassa Indica si té terrassa
     * @param tv Indica si té televisió
     * @param aireFred Indica si té aire condicionat
     */
    public Bungalow(String nom, String idAllotjament, boolean estatAllotjament,
                    String estatIluminacio, float mida, int habitacions,
                    int placesPersones, int placesParquing, boolean terrassa,
                    boolean tv, boolean aireFred) {
        super(nom, idAllotjament, 7, 4, estatAllotjament, estatIluminacio,
                mida, habitacions, placesPersones);
        this.placesParquing_ = placesParquing;
        this.terrassa_ = terrassa;
        this.tv_ = tv;
        this.aireFred_ = aireFred;
    }

    /**
     * Comprova el funcionament correcte del bungalow.
     * <p>
     * En aquesta implementació, un bungalow funciona correctament
     * si té aire condicionat en bon estat.
     * </p>
     *
     * @return true si l'aire condicionat funciona, false en cas contrari
     */
    @Override
    public boolean correcteFuncionament() {
        return aireFred_;
    }

    // Getters i setters

    /**
     * Obté les places de pàrquing del bungalow.
     * @return Nombre de places de pàrquing
     */
    public int getPlacesParquing() {
        return placesParquing_;
    }

    /**
     * Indica si el bungalow té terrassa.
     * @return true si té terrassa, false en cas contrari
     */
    public boolean isTerrassa() {
        return terrassa_;
    }

    /**
     * Indica si el bungalow té televisió.
     * @return true si té televisió, false en cas contrari
     */
    public boolean isTv() {
        return tv_;
    }

    /**
     * Indica si el bungalow té aire condicionat.
     * @return true si té aire condicionat, false en cas contrari
     */
    public boolean isAireFred() {
        return aireFred_;
    }

    /**
     * Estableix les places de pàrquing del bungalow.
     * @param placesParquing Nou nombre de places de pàrquing
     */
    public void setPlacesParquing(int placesParquing) {
        this.placesParquing_ = placesParquing;
    }

    /**
     * Estableix si el bungalow té terrassa.
     * @param terrassa true si té terrassa, false en cas contrari
     */
    public void setTerrassa(boolean terrassa) {
        this.terrassa_ = terrassa;
    }

    /**
     * Estableix si el bungalow té televisió.
     * @param tv true si té televisió, false en cas contrari
     */
    public void setTv(boolean tv) {
        this.tv_ = tv;
    }

    /**
     * Estableix si el bungalow té aire condicionat.
     * @param aireFred true si té aire condicionat, false en cas contrari
     */
    public void setAireFred(boolean aireFred) {
        this.aireFred_ = aireFred;
    }

    /**
     * Retorna una representació en format String del bungalow.
     * @return String amb tota la informació del bungalow
     */
    @Override
    public String toString() {
        return super.toString() + "Bungalow{placesParquing=" + placesParquing_ +
                ", terrassa=" + terrassa_ + ", tv=" + tv_ +
                ", aireFred=" + aireFred_ + "}";
    }
}