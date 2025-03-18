package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public class CamiTerra extends AccesTerra{

    //Constructor
    CamiTerra(String nom, boolean accessibilitat, boolean estat, ArrayList<Allotjament> accesAllotjaments,
                    int longitud){
        super(nom, accessibilitat, estat, accesAllotjaments, longitud);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}