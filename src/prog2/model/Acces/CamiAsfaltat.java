package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public class CamiAsfaltat extends AccesAsfalt{

    //Constructor
    public CamiAsfaltat(String nom, boolean accessibilitat, float metreQuadratsAsfalt){
        super(nom, accessibilitat, metreQuadratsAsfalt);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}
