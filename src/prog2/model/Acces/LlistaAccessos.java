package prog2.model.Acces;

import prog2.model.Interficies.InLlistaAccessos;
import prog2.vista.ExcepcioCamping;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que gestiona una llista d'accessos al camping.
 * <p>
 * Aquesta classe implementa les operacions bàsiques per gestionar
 * els accessos al camping, incloent afegir, eliminar, llistar
 * i actualitzar accessos.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see InLlistaAccessos
 * @see Acces
 * @since 1.0
 */
public class LlistaAccessos implements InLlistaAccessos, Serializable {

    //Atribut
    private ArrayList<Acces> accessos;

    /**
     * Constructor que inicialitza una llista buida d'accessos.
     */
    public LlistaAccessos() {
        this.accessos = new ArrayList<>();
    }

    /**
     * Afegeix un accés a la llista.
     *
     * @param acc Accés a afegir
     * @throws ExcepcioCamping Si l'accés ja existeix a la llista
     */
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        //Comprovacions
        for (Acces acces : accessos){
            if (acces.equals(acc)){
                throw new ExcepcioCamping("ERROR: L'accés especificat ja existeix.");
            }
        }
        accessos.add(acc);
    }

    /**
     * Buida completament la llista d'accessos.
     */
    public void buidar() {
        accessos.clear();
    }

    /**
     * Llista els accessos segons el seu estat (oberts o tancats).
     *
     * @param estat Estat dels accessos a llistar (true = oberts, false = tancats)
     * @return String amb la informació dels accessos
     * @throws ExcepcioCamping Si no hi ha accessos amb l'estat especificat
     */
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        StringBuilder accessosLlistats = new StringBuilder();

        for (Acces acces : accessos) {
            if (acces.getEstat() == estat) {
                accessosLlistats.append(acces.toString()).append("\n");
            }
        }

        if (accessosLlistats.isEmpty()) {
            throw new ExcepcioCamping("ERROR: No hi ha cap acces amb l'estat: " +
                    ((estat)? "Obert" : "Tancat") + ".");
        }
        return accessosLlistats.toString();
    }

    /**
     * Actualitza l'estat dels accessos en funció dels allotjaments associats.
     *
     * @throws ExcepcioCamping Si la llista d'accessos està buida
     */
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        if(accessos.isEmpty()){
            throw new ExcepcioCamping("ERROR: La llista d'accessos és buida");
        }

        for (Acces acces : accessos){
            acces.setEstat(!acces.getAccesAllotjament().isEmpty());
        }
    }

    /**
     * Calcula el nombre d'accessos actualment accessibles (oberts).
     *
     * @return Nombre d'accessos accessibles
     * @throws ExcepcioCamping Si la llista d'accessos està buida
     */
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        if(accessos.isEmpty()){
            throw new ExcepcioCamping("ERROR: La llista d'accessos és buida");
        }

        int contador = 0;
        for (Acces acces : accessos){
            if (acces.getEstat()){
                contador++;
            }
        }
        return contador;
    }

    /**
     * Calcula els metres quadrats totals d'asfalt dels accessos.
     *
     * @return Metres quadrats totals d'asfalt
     * @throws ExcepcioCamping Si la llista d'accessos està buida
     */
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        if(accessos.isEmpty()){
            throw new ExcepcioCamping("ERROR: La llista d'accessos és buida");
        }

        float metresQuadratsAsfalt = 0;
        for (Acces acces : accessos){
            if (acces instanceof AccesAsfalt){
                AccesAsfalt asfalt = (AccesAsfalt) acces;
                metresQuadratsAsfalt += asfalt.getMetresQuadratsAsfalt();
            }
        }
        return metresQuadratsAsfalt;
    }

    //getter i setter

    /**
     * Obté la llista completa d'accessos.
     *
     * @return Llista d'accessos
     */
    public ArrayList<Acces> getLListaAcessos(){
        return accessos;
    }

    /**
     * Estableix la llista d'accessos.
     *
     * @param accessos_ Nova llista d'accessos
     */
    public void setLlistaAccessos(ArrayList<Acces> accessos_){
        this.accessos = accessos_;
    }
}