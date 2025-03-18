package prog2.model.Allotjament;

import prog2.model.Incidencia;
import prog2.model.Interficies.InAllotjament;

public abstract class Allotjament implements InAllotjament {
    // Atributs classe Allotjament
    private String nom_;
    private String idAllotjament_;
    private long estadaMinimaALTA_;
    private long estadaMinimaBAIXA_;
    private String estatAllotjament_; // NOUS ATRIBUTS
    private String estatIluminacio_; // NOUS ATRIBUTS

    //Constructor comú
    public Allotjament(String nom_, String idAllotjament_, long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.nom_ = nom_;
        this.idAllotjament_ = idAllotjament_;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
        this.estatAllotjament_ = "Operatiu";
        this.estatIluminacio_ = "100%";
    }

    //Mètodes
    public String getNom() {
        return nom_;
    }

    public void setNom(String nom) {
        this.nom_ = nom;
    }

    public String getId() {
        return idAllotjament_;
    }

    public void setId(String id) {
        this.idAllotjament_ = id;
    }

    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.valueOf("ALTA")){
            return estadaMinimaALTA_;
        }
        if (temp == Temp.valueOf("BAIXA")){
            return estadaMinimaBAIXA_;
        }
        return 0;
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    public String getEstatAllotjament() {
        return estatAllotjament_;
    }

    public String getEstatIluminacio() {
        return estatIluminacio_;
    }

    public abstract boolean correcteFuncionament(); // SEGURAMENT L'ESBORRAREM

    @Override
    public String toString() {
        return "Nom=" + nom_ + ", Id=" + idAllotjament_ + ", estada mínima en temp ALTA= " + estadaMinimaALTA_ +
                ", estada mínima en temp BAIXA= " + estadaMinimaBAIXA_ + ", estatAllotjament= " +
                estatAllotjament_ + ", estatIluminacio= " + estatIluminacio_ + ".";
    }

    public void tancarAllotjament(Incidencia in) {
        estatAllotjament_ = "No operatiu"; // Declarem l'allotjament com a No operatiu
        estatIluminacio_ = in.getIluminacioAllotjament(); // Modifiquem la il·luminació segons el tipus d'incidència
    }

    public void obrirAllotjament() {
        estatAllotjament_ = "Operatiu";
        estatIluminacio_ = "100%";
    }


    // Necessitem sobreescriure el mètode equals, perquè puguem comparar allotjaments de forma més fàcil
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allotjament allotjament = (Allotjament) o;
        return idAllotjament_.equals(allotjament.idAllotjament_);
    }

}
