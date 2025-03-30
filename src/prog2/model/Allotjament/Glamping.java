package prog2.model.Allotjament;

import java.io.Serializable;

/**
 * Classe que representa un Glamping (acampada de luxe) al camping.
 * <p>
 * Aquesta classe hereta de Casa i afegeix característiques específiques
 * dels glamplings com el material de construcció i la possibilitat
 * d'allotjar mascotes.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Casa
 * @since 1.0
 */
public class Glamping extends Casa implements Serializable {
    //Atributs Glamping
    private String material_;
    private boolean casaMascota_;

    /**
     * Constructor principal per a un Glamping.
     *
     * @param nom Nom descriptiu del glamping
     * @param idAllotjament Identificador únic del glamping
     * @param estatAllotjament Estat operatiu del glamping
     * @param estatIluminacio Nivell d'il·luminació del glamping
     * @param mida Mida del glamping en metres quadrats
     * @param habitacions Nombre d'habitacions del glamping
     * @param placesPersones Capacitat de persones del glamping
     * @param material Material principal de construcció
     * @param casaMascota Indica si permet l'allotjament de mascotes
     */
    public Glamping(String nom, String idAllotjament, boolean estatAllotjament,
                    String estatIluminacio, float mida, int habitacions,
                    int placesPersones, String material, boolean casaMascota) {
        super(nom, idAllotjament, 5, 3, estatAllotjament, estatIluminacio,
                mida, habitacions, placesPersones);
        this.material_ = material;
        this.casaMascota_ = casaMascota;
    }

    /**
     * Comprova el funcionament correcte del Glamping.
     * <p>
     * En aquesta implementació, un Glamping funciona correctament
     * si permet l'allotjament de mascotes.
     * </p>
     *
     * @return true si permet mascotes, false en cas contrari
     */
    @Override
    public boolean correcteFuncionament() {
        return casaMascota_;
    }

    // Getters i setters

    /**
     * Obté el material de construcció del Glamping.
     * @return Material principal del glamping
     */
    public String getMaterial() {
        return material_;
    }

    /**
     * Indica si el Glamping permet mascotes.
     * @return true si permet mascotes, false en cas contrari
     */
    public boolean isCasaMascota() {
        return casaMascota_;
    }

    /**
     * Estableix el material de construcció del Glamping.
     * @param material Nou material del glamping
     */
    public void setMaterial(String material) {
        this.material_ = material;
    }

    /**
     * Estableix si el Glamping permet mascotes.
     * @param casaMascota true si permet mascotes, false en cas contrari
     */
    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota_ = casaMascota;
    }

    /**
     * Retorna una representació en format String del Glamping.
     * @return String amb tota la informació del glamping
     */
    @Override
    public String toString() {
        return super.toString() + "Glamping{material=" + material_ +
                ", casaMascota=" + casaMascota_ + "}";
    }
}