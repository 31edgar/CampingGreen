package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public abstract class AccesTerra extends Acces{
    //Atributs
    private float longitud_;

    //Constructor
    AccesTerra(String nom, boolean accessibilitat,
                float longitud){
        super(nom, accessibilitat);
        this.longitud_ = longitud;
    }

    public String toString(){
        return super.toString()+(" Acces de terra{Longitud: "+longitud_+"}");
    }

    //Getter i setter
    public float getLongitud(){return longitud_;}
    public void setLongitud(int longitud){this.longitud_=longitud;}
}
