package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public class CarreteraTerra extends AccesTerra{
    //Atributs
    private int amplada_;

    //Constructor
    CarreteraTerra(String nom, boolean accessibilitat, boolean estat, ArrayList<Allotjament> accesAllotjaments,
                    int longitud, int amplada){
        super(nom, accessibilitat, estat, accesAllotjaments, longitud);
        this.amplada_=amplada;
    }

    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+"Carretera{Amplada: "+amplada_+"}";
    }

    //Getter i Setter
    public int getAmplada(){return amplada_;}
    public void setAmplada(int amplada){this.amplada_=amplada;}
}