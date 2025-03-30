package prog2.model;
import prog2.model.Allotjament.Allotjament;
import prog2.model.Interficies.InLlistaIncidencies;
import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que representa una llista d'incidències registrades al camping.
 * <p>
 * Aquesta classe gestiona una col·lecció d'incidències, permetent afegir,
 * eliminar, buscar i llistar incidències. Implementa la interfície
 * InLlistaIncidencies i és serializable.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see InLlistaIncidencies
 * @see Incidencia
 * @since 1.0
 */
public class LlistaIncidencies implements InLlistaIncidencies, Serializable {

    // Atribut
    private ArrayList<Incidencia> incidencias;

    /**
     * Constructor que inicialitza una llista d'incidències buida.
     */
    public LlistaIncidencies() {
        this.incidencias = new ArrayList<>();
    }

    /**
     * Afegeix una nova incidència a la llista.
     * <p>
     * Abans d'afegir-la, comprova que no existeixi ja una incidència
     * amb el mateix número o per al mateix allotjament.
     * </p>
     *
     * @param num Número d'identificació de la incidència
     * @param tipus Tipus d'incidència (Reparacio, Neteja o Tancament)
     * @param allotjament Allotjament afectat per la incidència
     * @param data Data de registre de la incidència
     * @throws ExcepcioCamping Si ja existeix una incidència amb el mateix número
     *                        o per al mateix allotjament
     */
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        for (Incidencia incidencia : incidencias) {
            if (incidencia.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("ERROR: Allotjament especificat ja té una incidènicia");
            }
            if (incidencia.getNumeroIncidencia() == num) {
                throw new ExcepcioCamping("ERROR: Ja existeix una incidència amb aquest número");
            }
        }

        Incidencia in = new Incidencia(num, Incidencia.TipusIncidencia.valueOf(tipus), allotjament, data);
        incidencias.add(in);
        allotjament.tancarAllotjament(in);
    }

    /**
     * Elimina una incidència de la llista.
     * <p>
     * Quan s'elimina una incidència, l'allotjament associat es reobre
     * automàticament.
     * </p>
     *
     * @param in Incidència a eliminar
     * @throws ExcepcioCamping Si la incidència no existeix a la llista
     */
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        if (!incidencias.isEmpty()) {
            for (Incidencia incidencia : incidencias) {
                if (incidencia.equals(in)) {
                    incidencias.remove(incidencia);
                    incidencia.getAllotjament().obrirAllotjament();
                    return;
                }
            }
        }
        throw new ExcepcioCamping("ERROR: La incidència especificada no existeix");
    }

    /**
     * Llista totes les incidències registrades.
     *
     * @return String amb la informació de totes les incidències
     * @throws ExcepcioCamping Si la llista d'incidències està buida
     */
    public String llistarIncidencies() throws ExcepcioCamping {
        if(incidencias.isEmpty()){
            throw new ExcepcioCamping("ERROR: La llista d'incidències és buida");
        }

        StringBuilder str = new StringBuilder();

        for (Incidencia incidencia : incidencias) {
            str.append("Incidencia ").append(incidencia.getNumeroIncidencia()).append(": ")
                    .append("Tipus: ").append(incidencia.getTipusIncidencia())
                    .append(" Allotjament: ").append(incidencia.getAllotjament())
                    .append(" Data: ").append(incidencia.getData()).append("\n");
        }
        return str.toString();
    }

    /**
     * Obté una incidència pel seu número d'identificació.
     *
     * @param num Número de la incidència a buscar
     * @return La incidència trobada
     * @throws ExcepcioCamping Si no existeix cap incidència amb el número especificat
     */
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        for (Incidencia incidencia : incidencias) {
            if (incidencia.getNumeroIncidencia() == num){
                return incidencia;
            }
        }
        throw new ExcepcioCamping("ERROR: No hi ha cap incidència amb el número especificat");
    }

    /**
     * Obté la llista completa d'incidències.
     *
     * @return ArrayList amb totes les incidències
     */
    public ArrayList<Incidencia> getIncidencias(){
        return incidencias;
    }

    /**
     * Estableix la llista d'incidències.
     *
     * @param incidencias_ Nova llista d'incidències
     */
    public void setIncidencias(ArrayList<Incidencia> incidencias_){
        this.incidencias = incidencias_;
    }
}