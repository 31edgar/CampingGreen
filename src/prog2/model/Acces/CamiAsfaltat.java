package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.io.Serializable;
import java.util.ArrayList;

public class CamiAsfaltat extends AccesAsfalt implements Serializable {

    //Constructor
    public CamiAsfaltat(String nom, boolean accessibilitat, float metreQuadratsAsfalt){
        super(nom, accessibilitat, metreQuadratsAsfalt);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}
