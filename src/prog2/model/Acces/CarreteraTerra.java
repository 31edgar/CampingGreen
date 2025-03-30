package prog2.model.Acces;

import java.io.Serializable;

/**
 * Classe que representa una carretera de terra dins del camping.
 * <p>
 * Aquesta classe implementa un tipus d'accés no asfaltat amb informació
 * sobre la seva amplada, especialitzant les característiques bàsiques
 * d'un accés de terra.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see AccesTerra
 * @since 1.0
 */
public class CarreteraTerra extends AccesTerra implements Serializable {
    //Atributs
    private float amplada_;

    /**
     * Constructor principal per a una carretera de terra.
     *
     * @param nom Nom descriptiu de la carretera
     * @param accessibilitat Indica si la carretera és accessible per a persones amb mobilitat reduïda
     * @param longitud Longitud de la carretera en metres
     * @param amplada Amplada de la carretera en metres
     */
    public CarreteraTerra(String nom, boolean accessibilitat, float longitud, float amplada) {
        super(nom, accessibilitat, longitud);
        this.amplada_ = amplada;
    }

    /**
     * Determina l'accessibilitat de la carretera de terra.
     * <p>
     * En aquesta implementació, les carreteres de terra són sempre
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
     * Retorna una representació en format String de la carretera de terra.
     * @return String amb la informació de l'accés i la seva amplada
     */
    @Override
    public String toString() {
        return super.toString() + "Carretera{Amplada: " + amplada_ + "}";
    }

    //Getter i Setter

    /**
     * Obté l'amplada de la carretera de terra.
     * @return Amplada en metres
     */
    public float getAmplada() {
        return amplada_;
    }

    /**
     * Estableix l'amplada de la carretera de terra.
     * @param amplada Nova amplada en metres
     */
    public void setAmplada(int amplada) {
        this.amplada_ = amplada;
    }
}