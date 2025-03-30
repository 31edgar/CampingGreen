package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;
import java.io.Serializable;

/**
 * Classe que representa un camí de terra dins del camping.
 * <p>
 * Aquesta classe implementa un tipus concret d'accés no asfaltat,
 * especialitzant les característiques bàsiques d'un accés de terra.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see AccesTerra
 * @since 1.0
 */
public class CamiTerra extends AccesTerra implements Serializable {

    /**
     * Constructor principal per a un camí de terra.
     *
     * @param nom Nom descriptiu del camí
     * @param accessibilitat Indica si el camí és accessible per a persones amb mobilitat reduïda
     * @param longitud Longitud del camí en metres
     */
    public CamiTerra(String nom, boolean accessibilitat, float longitud) {
        super(nom, accessibilitat, longitud);
    }

    /**
     * Determina l'accessibilitat del camí de terra.
     * <p>
     * En aquesta implementació, els camins de terra no són accessibles
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