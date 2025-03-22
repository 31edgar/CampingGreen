package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public abstract class AccesAsfalt extends Acces{
    //Atributs
    private float metresQuadratsAsfalt_;

    //Constructor
    AccesAsfalt(String nom, boolean accessibilitat, float metresQuadratsAsfalt){
        super(nom, accessibilitat);
        this.metresQuadratsAsfalt_ = metresQuadratsAsfalt;
    }

    public String toString(){
        return super.toString()+(" Acces d'asfalt{Metres quadrats d'asfalt: "+metresQuadratsAsfalt_+"}");
    }

    //Getter i Setter
    public float getMetresQuadratsAsfalt(){return metresQuadratsAsfalt_;}
    public void setMetresQuadratsAsfalt(int metresQuadratsAsfalt){this.metresQuadratsAsfalt_=metresQuadratsAsfalt;}
}
