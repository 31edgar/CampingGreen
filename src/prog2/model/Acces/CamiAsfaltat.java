package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;
import java.io.Serializable;

/**
 * Classe que representa un camí asfaltat dins del camping.
 * <p>
 * Aquesta classe implementa un tipus concret d'accés asfaltat,
 * especialitzant les característiques bàsiques d'un accés.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see AccesAsfalt
 * @since 1.0
 */
public class CamiAsfaltat extends AccesAsfalt implements Serializable {

    /**
     * Constructor principal per a un camí asfaltat.
     *
     * @param nom Nom descriptiu del camí
     * @param accessibilitat Indica si el camí és accessible per a persones amb mobilitat reduïda
     * @param metreQuadratsAsfalt Metres quadrats de superfície asfaltada del camí
     */
    public CamiAsfaltat(String nom, boolean accessibilitat, float metreQuadratsAsfalt) {
        super(nom, accessibilitat, metreQuadratsAsfalt);
    }

    /**
     * Determina l'accessibilitat del camí asfaltat.
     * <p>
     * En aquesta implementació, els camins asfaltats no són accessibles
     * per a persones amb mobilitat reduïda.
     * </p>
     *
     * @return Sempre retorna false, indicant que no és accessible
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}