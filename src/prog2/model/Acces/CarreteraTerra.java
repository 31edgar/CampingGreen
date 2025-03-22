package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public class CarreteraTerra extends AccesTerra{
    //Atributs
    private float amplada_;

    //Constructor
    public CarreteraTerra(String nom, boolean accessibilitat, float longitud, float amplada){
        super(nom, accessibilitat, longitud);
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
    public float getAmplada(){return amplada_;}
    public void setAmplada(int amplada){this.amplada_=amplada;}
}