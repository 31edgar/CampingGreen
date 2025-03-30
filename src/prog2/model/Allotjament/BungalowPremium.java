package prog2.model.Allotjament;

import java.io.Serializable;

/**
 * Classe que representa un Bungalow Premium al camping.
 * <p>
 * Aquesta classe hereta de Bungalow i afegeix serveis exclusius
 * com a codi WiFi i serveis extra per als clients premium.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Bungalow
 * @since 1.0
 */
public class BungalowPremium extends Bungalow implements Serializable {
    //Atributs Bungalow Premium
    private boolean serveisExtra_;
    private String codiWifi_;

    /**
     * Constructor principal per a un Bungalow Premium.
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
     * @param serveisExtra Indica si té serveis extra
     * @param codiWifi Codi WiFi de l'allotjament (8-16 caràcters)
     */
    public BungalowPremium(String nom, String idAllotjament, boolean estatAllotjament,
                           String estatIluminacio, float mida, int habitacions,
                           int placesPersones, int placesParquing, boolean terrassa,
                           boolean tv, boolean aireFred, boolean serveisExtra,
                           String codiWifi) {
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, mida,
                habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra_ = serveisExtra;
        this.codiWifi_ = codiWifi;
    }

    /**
     * Comprova el funcionament correcte del Bungalow Premium.
     * <p>
     * Un Bungalow Premium funciona correctament si:
     * 1. L'aire condicionat està operatiu
     * 2. El codi WiFi té entre 8 i 16 caràcters
     * </p>
     *
     * @return true si compleix totes les condicions, false en cas contrari
     */
    @Override
    public boolean correcteFuncionament() {
        return (isAireFred()) && (codiWifi_.length() >= 8 && codiWifi_.length() <= 16);
    }

    // Getters i setters

    /**
     * Indica si el bungalow ofereix serveis extra.
     * @return true si té serveis extra, false en cas contrari
     */
    public boolean isServeisExtra() {
        return serveisExtra_;
    }

    /**
     * Obté el codi WiFi del bungalow.
     * @return Codi WiFi de l'allotjament
     */
    public String getCodiWifi() {
        return codiWifi_;
    }

    /**
     * Estableix si el bungalow ofereix serveis extra.
     * @param serveisExtra true si té serveis extra, false en cas contrari
     */
    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra_ = serveisExtra;
    }

    /**
     * Estableix el codi WiFi del bungalow.
     * @param codiWifi Nou codi WiFi (8-16 caràcters)
     */
    public void setCodiWifi(String codiWifi) {
        this.codiWifi_ = codiWifi;
    }

    /**
     * Retorna una representació en format String del Bungalow Premium.
     * @return String amb tota la informació del bungalow i els seus serveis premium
     */
    @Override
    public String toString() {
        return super.toString() + "ServeisPremium{serveisExtra=" + serveisExtra_ +
                ", codiWifi=" + codiWifi_ + "}";
    }
}