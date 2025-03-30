package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;
import java.io.Serializable;

/**
 * Classe abstracta que representa un accés de terra al camping.
 * <p>
 * Aquesta classe especialitza la classe Accés afegint informació sobre
 * la longitud de l'accés de terra. És la classe base per a accessos
 * com camins i carreteres de terra.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Acces
 * @since 1.0
 */
public abstract class AccesTerra extends Acces implements Serializable {
    //Atributs
    private float longitud_;

    /**
     * Constructor principal per a accessos de terra.
     *
     * @param nom Nom descriptiu de l'accés
     * @param accessibilitat Indica si l'accés és accessible per a persones amb mobilitat reduïda
     * @param longitud Longitud de l'accés en metres
     */
    AccesTerra(String nom, boolean accessibilitat, float longitud) {
        super(nom, accessibilitat);
        this.longitud_ = longitud;
    }

    /**
     * Retorna una representació en format String de l'accés de terra.
     * @return String amb la informació de l'accés i la seva longitud
     */
    @Override
    public String toString() {
        return super.toString() + (" Acces de terra{Longitud: " + longitud_ + "}");
    }

    //Getter i setter

    /**
     * Obté la longitud de l'accés de terra.
     * @return Longitud de l'accés en metres
     */
    public float getLongitud() {
        return longitud_;
    }

    /**
     * Estableix la longitud de l'accés de terra.
     * @param longitud Nova longitud de l'accés en metres
     */
    public void setLongitud(int longitud) {
        this.longitud_ = longitud;
    }
}