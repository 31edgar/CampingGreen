package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public class CarreteraAsfaltada extends AccesAsfalt{
    //Atributs
    private float pesMaxim_;

    //Constructor
    public CarreteraAsfaltada(String nom, boolean accessibilitat, float metreQuadratsAsfalt, float pesMaxim){
        super(nom, accessibilitat, metreQuadratsAsfalt);
        this.pesMaxim_=pesMaxim;
    }

    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+"Carretera{Pes màxim: "+pesMaxim_+"}";
    }

    //Getter i Setter
    public float getPesMaxim(){return pesMaxim_;}
    public void setPesMaxim(int pesMaxim){this.pesMaxim_=pesMaxim;}
}