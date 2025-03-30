package prog2.model;

import prog2.model.Allotjament.Allotjament;
import prog2.model.Interficies.InLlistaAllotjaments;
import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que representa una llista d'allotjaments del camping.
 * <p>
 * Aquesta classe gestiona una col·lecció d'allotjaments, permetent afegir,
 * eliminar, buscar i llistar allotjaments segons diferents criteris.
 * Implementa la interfície InLlistaAllotjaments i és serializable.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see InLlistaAllotjaments
 * @see Allotjament
 * @since 1.0
 */
public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    // Atributs
    private ArrayList<Allotjament> allotjaments;

    /**
     * Constructor que inicialitza una llista d'allotjaments buida.
     */
    public LlistaAllotjaments() {
        allotjaments = new ArrayList<Allotjament>();
    }

    /**
     * Afegeix un allotjament a la llista si no existeix prèviament.
     *
     * @param allotjament Allotjament a afegir
     * @throws ExcepcioCamping Si l'allotjament ja existeix a la llista
     */
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        for (Allotjament element : allotjaments) {
            if (element.equals(allotjament)) {
                throw new ExcepcioCamping("L'allotjament ja existeix");
            }
        }

        allotjaments.add(allotjament);
        System.out.println("Allotjament afegit correctament.");
    }

    /**
     * Buida completament la llista d'allotjaments.
     */
    public void buidar() {
        allotjaments.clear();
    }

    /**
     * Llista els allotjaments segons l'estat especificat.
     *
     * @param estat Estat dels allotjaments a llistar ("Tots", "Operatiu" o "No operatiu")
     * @return String amb la informació dels allotjaments que coincideixen amb l'estat
     * @throws ExcepcioCamping Si no hi ha allotjaments amb l'estat especificat
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        StringBuilder allotjamentsLlistats = new StringBuilder();

        if (estat.equals("Tots")) {
            for (Allotjament allotjament : allotjaments) {
                allotjamentsLlistats.append(allotjament.toString()).append("\n");
            }
        }
        else {
            for (Allotjament allotjament : allotjaments) {
                String estatAllotjament = (allotjament.getEstatAllotjament()) ? "Operatiu" : "No operatiu";

                if (estatAllotjament.equals(estat)) {
                    allotjamentsLlistats.append(allotjament.toString()).append("\n");
                }
            }
        }

        if (allotjamentsLlistats.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb l'estat: " + estat + ".");
        } else {
            return allotjamentsLlistats.toString();
        }
    }

    /**
     * Comprova si existeix almenys un allotjament operatiu a la llista.
     *
     * @return true si hi ha allotjaments operatius, false en cas contrari
     */
    public boolean containsAllotjamentOperatiu() {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getEstatAllotjament()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprova si un allotjament específic existeix a la llista.
     *
     * @param allotjament Allotjament a buscar
     * @return true si l'allotjament existeix, false en cas contrari
     */
    public boolean contains(Allotjament allotjament) {
        for (Allotjament element : allotjaments) {
            if (element.equals(allotjament)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obté un allotjament de la llista pel seu identificador.
     *
     * @param id Identificador de l'allotjament a buscar
     * @return L'allotjament trobat
     * @throws ExcepcioCamping Si no existeix cap allotjament amb l'ID especificat
     */
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getId().equals(id)) {
                return allotjament;
            }
        }
        throw new ExcepcioCamping("L'allotjament no existeix.");
    }

    /**
     * Obté la llista completa d'allotjaments.
     *
     * @return ArrayList amb tots els allotjaments
     */
    public ArrayList<Allotjament> getAllotjaments(){
        return allotjaments;
    }

    /**
     * Estableix la llista d'allotjaments.
     *
     * @param allotjaments_ Nova llista d'allotjaments
     */
    public void setAllotjaments(ArrayList<Allotjament> allotjaments_){
        this.allotjaments = allotjaments_;
    }
}