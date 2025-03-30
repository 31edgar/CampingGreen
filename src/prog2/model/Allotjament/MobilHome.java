package prog2.model.Allotjament;

import java.io.Serializable;

/**
 * Classe que representa un MobilHome al camping.
 * <p>
 * Aquesta classe hereta de {@link Casa} i afegeix característiques
 * específiques dels MobilHome com la disponibilitat de terrassa amb barbacoa.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Casa
 * @since 1.0
 */
public class MobilHome extends Casa implements Serializable {
    //Atributs MobilHome
    private boolean terrasaBarbacoa_;

    /**
     * Constructor principal per a un MobilHome.
     *
     * @param nom_ Nom descriptiu del MobilHome
     * @param idAllotjament_ Identificador únic del MobilHome
     * @param estatAllotjament Estat operatiu del MobilHome
     * @param estatIluminacio Nivell d'il·luminació del MobilHome
     * @param mida Mida en metres quadrats del MobilHome
     * @param habitacions Nombre d'habitacions del MobilHome
     * @param placesPersones Capacitat de persones del MobilHome
     * @param terrasaBarbacoa_ Indica si disposa de terrassa amb barbacoa
     */
    public MobilHome(String nom_, String idAllotjament_, boolean estatAllotjament,
                     String estatIluminacio, float mida, int habitacions,
                     int placesPersones, boolean terrasaBarbacoa_) {
        super(nom_, idAllotjament_, 5, 3, estatAllotjament, estatIluminacio,
                mida, habitacions, placesPersones);
        this.terrasaBarbacoa_ = terrasaBarbacoa_;
    }

    /**
     * Comprova el funcionament correcte del MobilHome.
     * <p>
     * En aquest cas, el funcionament correcte depèn de la disponibilitat
     * de terrassa amb barbacoa.
     * </p>
     *
     * @return true si el MobilHome funciona correctament (té terrassa amb barbacoa),
     *         false en cas contrari
     */
    @Override
    public boolean correcteFuncionament() {
        return terrasaBarbacoa_;
    }

    /**
     * Indica si el MobilHome té terrassa amb barbacoa.
     *
     * @return true si té terrassa amb barbacoa, false en cas contrari
     */
    public boolean isTerrasaBarbacoa(){
        return terrasaBarbacoa_;
    }

    /**
     * Estableix si el MobilHome té terrassa amb barbacoa.
     *
     * @param terrasaBarbacoa_ true per indicar que té terrassa amb barbacoa,
     *                        false en cas contrari
     */
    public void setTerrasaBarbacoa(boolean terrasaBarbacoa_) {
        this.terrasaBarbacoa_ = terrasaBarbacoa_;
    }

    /**
     * Retorna una representació en format String del MobilHome.
     * <p>
     * Inclou la informació de la classe pare i l'estat de la terrassa amb barbacoa.
     * </p>
     *
     * @return String amb tota la informació del MobilHome
     */
    @Override
    public String toString() {
        return super.toString() + "MobilHome{terrasaBarbacoa=" + terrasaBarbacoa_ + "}";
    }
}