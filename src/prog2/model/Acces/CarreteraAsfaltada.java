package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;
import java.io.Serializable;

/**
 * Classe que representa una carretera asfaltada dins del camping.
 * <p>
 * Aquesta classe implementa un tipus d'accés asfaltat amb capacitat
 * per a vehicles pesants, afegint la informació del pes màxim permès.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see AccesAsfalt
 * @since 1.0
 */
public class CarreteraAsfaltada extends AccesAsfalt implements Serializable {
    //Atributs
    private float pesMaxim_;

    /**
     * Constructor principal per a una carretera asfaltada.
     *
     * @param nom Nom descriptiu de la carretera
     * @param accessibilitat Indica si la carretera és accessible per a persones amb mobilitat reduïda
     * @param metreQuadratsAsfalt Metres quadrats de superfície asfaltada
     * @param pesMaxim Pes màxim permès en quilograms
     */
    public CarreteraAsfaltada(String nom, boolean accessibilitat, float metreQuadratsAsfalt, float pesMaxim) {
        super(nom, accessibilitat, metreQuadratsAsfalt);
        this.pesMaxim_ = pesMaxim;
    }

    /**
     * Determina l'accessibilitat de la carretera asfaltada.
     * <p>
     * En aquesta implementació, les carreteres asfaltades són sempre
     * accessibles per a persones amb mobilitat reduïda.
     * </p>
     *
     * @return Sempre retorna true, indicant que és accessible
     */
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    /**
     * Retorna una representació en format String de la carretera asfaltada.
     * @return String amb la informació de l'accés i el pes màxim permès
     */
    @Override
    public String toString() {
        return super.toString() + "Carretera{Pes màxim: " + pesMaxim_ + "}";
    }

    //Getter i Setter

    /**
     * Obté el pes màxim permès a la carretera.
     * @return Pes màxim en quilograms
     */
    public float getPesMaxim() {
        return pesMaxim_;
    }

    /**
     * Estableix el pes màxim permès a la carretera.
     * @param pesMaxim Nou pes màxim en quilograms
     */
    public void setPesMaxim(int pesMaxim) {
        this.pesMaxim_ = pesMaxim;
    }
}