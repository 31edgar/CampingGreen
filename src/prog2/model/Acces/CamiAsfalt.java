package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public class CamiAsfalt extends AccesAsfalt{

    //Constructor
    CamiAsfalt(String nom, boolean accessibilitat, boolean estat, ArrayList<Allotjament> accesAllotjaments,
               int metreQuadratsAsfalt){
        super(nom, accessibilitat, estat, accesAllotjaments, metreQuadratsAsfalt);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}
