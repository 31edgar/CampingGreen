package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public class CarreteraAsfalt extends AccesAsfalt{
    //Atributs
    private int pesMaxim_;

    //Constructor
    CarreteraAsfalt(String nom, boolean accessibilitat, boolean estat, ArrayList<Allotjament> accesAllotjaments,
               int metreQuadratsAsfalt, int pesMaxim){
        super(nom, accessibilitat, estat, accesAllotjaments, metreQuadratsAsfalt);
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
    public int getPesMaxim(){return pesMaxim_;}
    public void setPesMaxim(int pesMaxim){this.pesMaxim_=pesMaxim;}
}