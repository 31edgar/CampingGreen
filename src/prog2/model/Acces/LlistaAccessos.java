package prog2.model.Acces;

import prog2.model.Interficies.InLlistaAccessos;
import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos, Serializable {

    //Atribut
    private ArrayList<Acces> accessos;
    //Constructor
    public LlistaAccessos() {
        this.accessos = new ArrayList<>();
    }

    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        //Comprovacions
        for (Acces acces : accessos){
            if (acces.equals(acc)){throw new ExcepcioCamping("ERROR: L'accés especificat ja existeix.");}
        }
        accessos.add(acc);
    }

    public void buidar() {
        accessos.clear();
    }

    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        // Variables
        StringBuilder accessosLlistats = new StringBuilder();

        //Comprovem els acessos que corresponen amb l'estat escollit
        for (Acces acces : accessos) {
            if (acces.getEstat() == estat) {
                accessosLlistats.append(accessos.toString()).append("\n");
            }
        }

        if (accessosLlistats.isEmpty()) {
            throw new ExcepcioCamping("ERROR: No hi ha cap acces amb l'estat: " + ((estat)? "Obert" : "Tancat") + ".");
        }
        else {
            return accessosLlistats.toString();
        }
    }

    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        if(accessos.isEmpty()){
            throw new ExcepcioCamping("ERROR: La llista d'accessos és buida");
        }

        for (Acces acces : accessos){
            //Tanca els accessos si no té cap accés a un allotjament.
            acces.setEstat(!acces.getAccesAllotjament().isEmpty());
        }
    }

    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int contador = 0;

        if(accessos.isEmpty()){
            throw new ExcepcioCamping("ERROR: La llista d'accessos és buida");
        }

        for (Acces acces : accessos){
            if (acces.getEstat()){contador++;}
        }
        return contador;
    }

    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        float metresQuadratsAsfalt = 0;

        if(accessos.isEmpty()){
            throw new ExcepcioCamping("ERROR: La llista d'accessos és buida");
        }

        for (Acces acces : accessos){
            //Agafem els accessos de tipus AccesAsfalt i fem un casting per convertir-los en tal i utilitzar
            //el mètode getMetresQuadratsAsfalt (ignorar el warning)
            if (acces instanceof AccesAsfalt){
                AccesAsfalt asfalt = (AccesAsfalt) acces;
                metresQuadratsAsfalt += asfalt.getMetresQuadratsAsfalt();
            }
        }

        return metresQuadratsAsfalt;
    }

    //getter i setter
    public ArrayList<Acces> getLListaAcessos(){
        return accessos;
    }
    public void getLlistaAcessos(ArrayList<Acces> accessos_){
        this.accessos = accessos_;
    }
}
