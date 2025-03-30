package prog2.model.Acces;

import prog2.model.Allotjament.Allotjament;
import prog2.model.Interficies.InAcces;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe abstracta que representa un accés genèric al camping.
 * <p>
 * Aquesta classe serveix com a base per als diferents tipus d'accessos al camping.
 * Gestiona la informació bàsica de cada accés i els allotjaments associats.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see InAcces
 * @see Allotjament
 * @since 1.0
 */
public abstract class Acces implements InAcces, Serializable {
    //Atributs
    private String nom_;
    private boolean accessibilitat_;
    private boolean estat_;
    //Cada accés te la seva llista d'allotjaments, no és la mateixa ArrayList que a LlistaAllotjaments
    private ArrayList<Allotjament> accesAllotjaments_ = new ArrayList<>();

    /**
     * Constructor principal de la classe Accés.
     *
     * @param nom Nom descriptiu de l'accés
     * @param accessibilitat Indica si l'accés és accessible per a persones amb mobilitat reduïda
     */
    public Acces(String nom, boolean accessibilitat){
        this.nom_ = nom;
        this.accessibilitat_ = accessibilitat;
        // Per defecte, l'estat s'inicialitza com true
        this.estat_ = true;
    }

    /**
     * Afegeix un allotjament a la llista d'allotjaments accessibles des d'aquest accés.
     *
     * @param allotjament L'allotjament a afegir
     */
    public void afegirAllotjament(Allotjament allotjament) {
        accesAllotjaments_.add(allotjament);
    }

    /**
     * Tanca l'accés, marcant-lo com a no accessible.
     */
    public void tancarAcces() {
        setAccessibilitat(false);
    }

    /**
     * Obre l'accés, marcant-lo com a accessible.
     */
    public void obrirAcces() {
        setAccessibilitat(true);
    }

    /**
     * Mètode abstracte per comprovar l'accessibilitat de l'accés.
     * @return true si l'accés és accessible, false en cas contrari
     */
    public abstract boolean isAccessibilitat();

    /**
     * Retorna una representació en format String de l'accés.
     * @return String amb la informació de l'accés
     */
    public String toString(){
        return ("Acces{"+"Nom: "+nom_+" Accessibilitat: "+accessibilitat_+" Estat: "+estat_+" Accés a: "+accesAllotjaments_);
    }

    //Getters i Setters

    /**
     * Obté el nom de l'accés.
     * @return El nom de l'accés
     */
    public String getNom(){return nom_;}

    /**
     * Estableix el nom de l'accés.
     * @param nom El nou nom de l'accés
     */
    public void setNom(String nom) {
        this.nom_ = nom;
    }

    /**
     * Obté l'estat d'accessibilitat de l'accés.
     * @return true si l'accés és accessible, false en cas contrari
     */
    public boolean getAccessibilitat(){return accessibilitat_;}

    /**
     * Estableix l'accessibilitat de l'accés.
     * @param accessibilitat Nou estat d'accessibilitat
     */
    public void setAccessibilitat(boolean accessibilitat) {
        this.accessibilitat_ = accessibilitat;
    }

    /**
     * Obté l'estat actual de l'accés (obert/tancat).
     * @return true si l'accés està obert, false si està tancat
     */
    public boolean getEstat(){return estat_;}

    /**
     * Estableix l'estat de l'accés.
     * @param estat Nou estat de l'accés
     */
    public void setEstat(boolean estat) {
        this.estat_ = estat;
    }

    /**
     * Obté la llista d'allotjaments accessibles des d'aquest accés.
     * @return Llista d'allotjaments
     */
    public ArrayList<Allotjament> getAccesAllotjament(){return accesAllotjaments_;}

    /**
     * Estableix la llista d'allotjaments accessibles des d'aquest accés.
     * @param accesAllotjaments Nova llista d'allotjaments
     */
    public void setAccesAllotjaments(ArrayList<Allotjament> accesAllotjaments) {
        this.accesAllotjaments_ = accesAllotjaments;
    }
}