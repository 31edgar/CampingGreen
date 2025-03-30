package prog2.model.Allotjament;

import java.io.Serializable;

/**
 * Classe que representa una Parcela al camping.
 * <p>
 * Aquesta classe hereta de {@link Allotjament} i afegeix característiques
 * específiques de les parcel·les com ara la mida en metres quadrats
 * i la disponibilitat de connexió elèctrica.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Allotjament
 * @since 1.0
 */
public class Parcela extends Allotjament implements Serializable {
    //Atributs Parcela
    private float metres_;
    private boolean connexioElectrica_;

    /**
     * Constructor principal per a una Parcela.
     *
     * @param nom_ Nom descriptiu de la parcel·la
     * @param idAllotjament Identificador únic de la parcel·la
     * @param estatAllotjament Estat operatiu de la parcel·la
     * @param estatIluminacio Nivell d'il·luminació de la parcel·la
     * @param metres_ Mida en metres quadrats de la parcel·la
     * @param connexioElectrica_ Indica si la parcel·la té connexió elèctrica
     */
    public Parcela(String nom_, String idAllotjament, boolean estatAllotjament,
                   String estatIluminacio, float metres_, boolean connexioElectrica_) {
        super(nom_, idAllotjament, 4, 2, estatAllotjament, estatIluminacio);
        this.metres_ = metres_;
        this.connexioElectrica_ = connexioElectrica_;
    }

    /**
     * Comprova el funcionament correcte de la Parcela.
     * <p>
     * El criteri de funcionament correcte és que tingui connexió elèctrica.
     * </p>
     *
     * @return true si la parcel·la funciona correctament (té connexió elèctrica),
     *         false en cas contrari
     */
    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica_;
    }

    /**
     * Obté la mida de la parcel·la en metres quadrats.
     *
     * @return Mida en metres quadrats
     */
    public float getMida() {
        return metres_;
    }

    /**
     * Estableix la mida de la parcel·la.
     *
     * @param metres_ Nova mida en metres quadrats
     */
    public void setMida(float metres_) {
        this.metres_ = metres_;
    }

    /**
     * Indica si la parcel·la té connexió elèctrica.
     *
     * @return true si té connexió elèctrica, false en cas contrari
     */
    public boolean isConnexioElectrica() {
        return connexioElectrica_;
    }

    /**
     * Estableix l'estat de la connexió elèctrica de la parcel·la.
     *
     * @param connexioElectrica_ true per indicar que té connexió elèctrica,
     *                          false en cas contrari
     */
    public void setConnexioElectrica(boolean connexioElectrica_) {
        this.connexioElectrica_ = connexioElectrica_;
    }

    /**
     * Retorna una representació en format String de la Parcela.
     * <p>
     * Inclou la informació de la classe pare més els atributs específics
     * de la parcel·la (mida i connexió elèctrica).
     * </p>
     *
     * @return String amb tota la informació de la parcel·la
     */
    @Override
    public String toString() {
        return super.toString() + "Parcela{metres=" + metres_ +
                ", connexioElectrica=" + connexioElectrica_ + "}";
    }
}