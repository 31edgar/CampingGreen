package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.io.Serializable;
import java.util.ArrayList;

public class CamiTerra extends AccesTerra implements Serializable {

    //Constructor
    public CamiTerra(String nom, boolean accessibilitat, float longitud){
        super(nom, accessibilitat, longitud);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}