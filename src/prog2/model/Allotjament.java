package prog2.model;

public abstract class Allotjament implements InAllotjament {
    // Atributs classe Allotjament
    private String nom_;
    private String idAllotjament_;
    private long estadaMinimaALTA_;
    private long estadaMinimaBAIXA_;

    //Constructor comú
    public Allotjament(String nom_, String idAllotjament_, long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.nom_ = nom_;
        this.idAllotjament_ = idAllotjament_;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    //Altre constructor
    public Allotjament(String nom, String idAllotjament) {
        this.nom_ = nom;
        this.idAllotjament_ = idAllotjament;
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

    public abstract boolean correcteFuncionament();

    @Override
    public String toString() {
        return "Nom=" + nom_ + ", Id=" + idAllotjament_ + ", estada mínima en temp ALTA: " + estadaMinimaALTA_ + ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA_ + ".";
    }
}
