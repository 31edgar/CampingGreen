package prog2.model;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    // Atributs
    ArrayList<Allotjament> allotjaments;

    // Constructor
    public LlistaAllotjaments() {
        allotjaments = new ArrayList<Allotjament>();
    }

    // Altres mètodes
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        // Cal mirar si l'allotjament ja està a la llista o no
        // CAL REVISAR SI HI HA ALGUNA MANERA MILLOR DE FER AQUEST MÈTODE

        for (Allotjament element : allotjaments) {
            if (element.equals(allotjament)) {
                throw new ExcepcioCamping("L'allotjament ja existeix");
            }
        }

        allotjaments.add(allotjament);
        System.out.println("Allotjament afegit correctament.");
    }

    public void buidar() {
        allotjaments.clear();
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        // Variables
        String allotjamentsLlistats = "";

        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getEstatAllotjament().equals(estat)) { // No se si canviar-ho a una forma més fàcil d'entendre
                allotjamentsLlistats += allotjament.toString() + "\n"; // el \n està posat per a que sigui més clara la informació, espero que no afecti al desenvolupament
            }
        }

        if (allotjamentsLlistats.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb l'estat: " + estat + ".");
        } else {
            return allotjamentsLlistats;
        }
    }

    public boolean containsAllotjamentOperatiu() {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getEstatAllotjament().equals("Operatiu")) {
                return true;
            }
        }

        return false;
    }

    public boolean contains(Allotjament allotjament) {
        for (Allotjament element : allotjaments) {
            if (element.equals(allotjament)) {
                return true;
            }
        }

        return false;
    }

    public Allotjament getAllotjament(String nom) throws ExcepcioCamping {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getNom().equals(nom)) {
                return allotjament;
            }
        }

        throw new ExcepcioCamping("L'allotjament no existeix.");
    }
}
