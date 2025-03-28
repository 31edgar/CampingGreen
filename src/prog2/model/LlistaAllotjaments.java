package prog2.model;
import prog2.model.Allotjament.Allotjament;
import prog2.model.Interficies.InLlistaAllotjaments;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    // Atributs
    private ArrayList<Allotjament> allotjaments;

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
        StringBuilder allotjamentsLlistats = new StringBuilder();

        // Cas Tots
        if (estat.equals("Tots")) {
            for (Allotjament allotjament : allotjaments) {
                allotjamentsLlistats.append(allotjament.toString()).append("\n");
            }
        } else {
            for (Allotjament allotjament : allotjaments) {
                // Com l'estat de la classe Allotjament es un boolean i no un string, utilitzarem l'operador ternari
                // Així podem decidir el valor del nostre String segons si l'estat és operatiu o no operatiu
                String estatAllotjament = (allotjament.getEstatAllotjament()) ? "Operatiu" : "No operatiu";

                // Tots els allotjaments que coincideixen amb l'estat donat, s'afegiran al string de la llista
                if (estatAllotjament.equals(estat)) {
                    allotjamentsLlistats.append(allotjament.toString()).append("\n");
                }
            }
        }

        // Cas excepció
        if (allotjamentsLlistats.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb l'estat: " + estat + ".");
        } else {
            return allotjamentsLlistats.toString();
        }
    }

    public boolean containsAllotjamentOperatiu() {
        for (Allotjament allotjament : allotjaments) {
            // Utilitzem la mateixa metodologia que a llistarAllotjaments()
            String estatAllotjament = (allotjament.getEstatAllotjament()) ? "Operatiu" : "No operatiu";

            if (estatAllotjament.equals("Operatiu")) {
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

    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getId().equals(id)) {
                return allotjament;
            }
        }

        throw new ExcepcioCamping("L'allotjament no existeix.");
    }

    //getter i setter
    public ArrayList<Allotjament> getAllotjaments(){
        return allotjaments;
    }

    public void setAllotjaments(ArrayList<Allotjament> allotjaments_){
        this.allotjaments = allotjaments_;
    }
}
