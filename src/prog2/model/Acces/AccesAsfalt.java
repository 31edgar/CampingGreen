package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;
import java.io.Serializable;

/**
 * Classe abstracta que representa un accés asfaltat al camping.
 * <p>
 * Aquesta classe especialitza la classe Accés afegint informació sobre
 * els metres quadrats d'asfalt que conté l'accés. És la classe base
 * per a accessos com carreteres i camins asfaltats.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Acces
 * @since 1.0
 */
public abstract class AccesAsfalt extends Acces implements Serializable {
    //Atributs
    private float metresQuadratsAsfalt_;

    /**
     * Constructor principal per a accessos asfaltats.
     *
     * @param nom Nom descriptiu de l'accés
     * @param accessibilitat Indica si l'accés és accessible per a persones amb mobilitat reduïda
     * @param metresQuadratsAsfalt Metres quadrats de superfície asfaltada
     */
    protected AccesAsfalt(String nom, boolean accessibilitat, float metresQuadratsAsfalt){
        super(nom, accessibilitat);
        this.metresQuadratsAsfalt_ = metresQuadratsAsfalt;
    }

    /**
     * Retorna una representació en format String de l'accés asfaltat.
     * @return String amb la informació de l'accés i els metres d'asfalt
     */
    @Override
    public String toString(){
        return super.toString()+(" Acces d'asfalt{Metres quadrats d'asfalt: "+metresQuadratsAsfalt_+"}");
    }

    //Getter i Setter

    /**
     * Obté els metres quadrats d'asfalt de l'accés.
     * @return Quantitat d'asfalt en metres quadrats
     */
    public float getMetresQuadratsAsfalt(){return metresQuadratsAsfalt_;}

    /**
     * Estableix els metres quadrats d'asfalt de l'accés.
     * @param metresQuadratsAsfalt Nova quantitat d'asfalt en metres quadrats
     */
    public void setMetresQuadratsAsfalt(int metresQuadratsAsfalt){
        this.metresQuadratsAsfalt_ = metresQuadratsAsfalt;
    }
}