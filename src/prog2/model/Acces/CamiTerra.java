package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public class CamiTerra extends AccesTerra{

    //Constructor
    public CamiTerra(String nom, boolean accessibilitat, float longitud){
        super(nom, accessibilitat, longitud);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}