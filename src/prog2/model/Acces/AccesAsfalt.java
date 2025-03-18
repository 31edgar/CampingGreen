package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;

import java.util.ArrayList;

public abstract class AccesAsfalt extends Acces{
    //Atributs
    private int metresQuadratsAsfalt_;

    //Constructor
    AccesAsfalt(String nom, boolean accessibilitat, boolean estat, ArrayList<Allotjament> accesAllotjaments,
                int metresQuadratsAsfalt){
        super(nom, accessibilitat, estat, accesAllotjaments);
        this.metresQuadratsAsfalt_ = metresQuadratsAsfalt;
    }

    public String toString(){
        return super.toString()+(" Acces d'asfalt{Metres quadrats d'asfalt: "+metresQuadratsAsfalt_+"}");
    }

    //Getter i Setter
    public int getMetresQuadratsAsfalt(){return metresQuadratsAsfalt_;}
    public void setMetresQuadratsAsfalt(int metresQuadratsAsfalt){this.metresQuadratsAsfalt_=metresQuadratsAsfalt;}
}
