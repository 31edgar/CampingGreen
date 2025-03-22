package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;
import prog2.model.Interficies.InAcces;

import java.util.ArrayList;

public abstract class Acces implements InAcces {
    //Atributs
    private String nom_;
    private boolean accessibilitat_;
    private boolean estat_;
    //Cada accés te la seva llista d'allotjaments, no és la mateixa ArrayList que a LlistaAllotjaments
    private ArrayList<Allotjament> accesAllotjaments_ = new ArrayList<>();

    //Constructor
    public Acces(String nom, boolean accessibilitat){
        this.nom_ = nom;
        this.accessibilitat_ = accessibilitat;
        // Per defecte, l'estat s'inicialitza com true
        this.estat_ = true;
    }

    public void afegirAllotjament(Allotjament allotjament) {
        accesAllotjaments_.add(allotjament);
    }

    public void tancarAcces() {
        setAccessibilitat(false);
    }

    public void obrirAcces() {
        setAccessibilitat(true);
    }

    public abstract boolean isAccessibilitat();

    public String toString(){
        return ("Acces{"+"Nom: "+nom_+" Accessibilitat: "+accessibilitat_+" Estat: "+estat_+" Accés a: "+accesAllotjaments_);
    }

    //Setters
    public void setNom(String nom) {
        this.nom_ = nom;
    }
    public void setAccessibilitat(boolean accessibilitat) {
        this.accessibilitat_ = accessibilitat;
    }
    public void setEstat(boolean estat) {
        this.estat_ = estat;
    }
    public void setAccesAllotjaments(ArrayList<Allotjament> accesAllotjaments) {
        this.accesAllotjaments_ = accesAllotjaments;
    }

}
