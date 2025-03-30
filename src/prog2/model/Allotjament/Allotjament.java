package prog2.model.Allotjament;

import prog2.model.Incidencia;
import prog2.model.Interficies.InAllotjament;
import java.io.Serializable;

/**
 * Classe abstracta que representa un allotjament genèric al camping.
 * <p>
 * Aquesta classe conté les característiques bàsiques de qualsevol
 * allotjament del camping, com ara el nom, identificador, estades mínimes
 * i estats d'operativitat i il·luminació.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see InAllotjament
 * @since 1.0
 */
public abstract class Allotjament implements InAllotjament, Serializable {
    // Atributs classe Allotjament
    private String nom_;
    private String idAllotjament_;
    private long estadaMinimaALTA_;
    private long estadaMinimaBAIXA_;
    private boolean estatAllotjament_;
    private String estatIluminacio_;

    /**
     * Constructor principal per a un allotjament.
     *
     * @param nom Nom descriptiu de l'allotjament
     * @param idAllotjament Identificador únic de l'allotjament
     * @param estadaMinimaALTA Estada mínima requerida en temporada alta (en dies)
     * @param estadaMinimaBAIXA Estada mínima requerida en temporada baixa (en dies)
     * @param estatAllotjament Estat operatiu de l'allotjament
     * @param estatIluminacio Nivell d'il·luminació de l'allotjament
     */
    public Allotjament(String nom, String idAllotjament, long estadaMinimaALTA,
                       long estadaMinimaBAIXA, boolean estatAllotjament,
                       String estatIluminacio) {
        this.nom_ = nom;
        this.idAllotjament_ = idAllotjament;
        this.estadaMinimaALTA_ = estadaMinimaALTA;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA;
        this.estatAllotjament_ = estatAllotjament;
        this.estatIluminacio_ = estatIluminacio;
    }

    /**
     * Obté el nom de l'allotjament.
     * @return Nom de l'allotjament
     */
    public String getNom() {
        return nom_;
    }

    /**
     * Estableix el nom de l'allotjament.
     * @param nom Nou nom per a l'allotjament
     */
    public void setNom(String nom) {
        this.nom_ = nom;
    }

    /**
     * Obté l'identificador de l'allotjament.
     * @return Identificador únic de l'allotjament
     */
    public String getId() {
        return idAllotjament_;
    }

    /**
     * Estableix l'identificador de l'allotjament.
     * @param id Nou identificador per a l'allotjament
     */
    public void setId(String id) {
        this.idAllotjament_ = id;
    }

    /**
     * Obté l'estada mínima requerida segons la temporada.
     * @param temp Temporada (ALTA o BAIXA)
     * @return Estada mínima en dies
     */
    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.valueOf("ALTA")){
            return estadaMinimaALTA_;
        }
        if (temp == Temp.valueOf("BAIXA")){
            return estadaMinimaBAIXA_;
        }
        return 0;
    }

    /**
     * Estableix les estades mínimes per temporada.
     * @param estadaMinimaALTA Estada mínima en temporada alta (en dies)
     * @param estadaMinimaBAIXA Estada mínima en temporada baixa (en dies)
     */
    public void setEstadaMinima(long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.estadaMinimaALTA_ = estadaMinimaALTA;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA;
    }

    /**
     * Obté l'estat operatiu de l'allotjament.
     * @return true si l'allotjament està operatiu, false en cas contrari
     */
    public boolean getEstatAllotjament() {
        return estatAllotjament_;
    }

    /**
     * Obté l'estat d'il·luminació de l'allotjament.
     * @return Nivell d'il·luminació en percentatge
     */
    public String getEstatIluminacio() {
        return estatIluminacio_;
    }

    /**
     * Mètode abstracte per comprovar el funcionament correcte de l'allotjament.
     * @return true si l'allotjament funciona correctament, false en cas contrari
     */
    public abstract boolean correcteFuncionament();

    /**
     * Retorna una representació en format String de l'allotjament.
     * @return String amb tota la informació de l'allotjament
     */
    @Override
    public String toString() {
        return "Nom=" + nom_ + ", Id=" + idAllotjament_ + ", estada mínima en temp ALTA= " + estadaMinimaALTA_ +
                ", estada mínima en temp BAIXA= " + estadaMinimaBAIXA_ + ", estatAllotjament= " +
                ((estatAllotjament_)?"Operatiu" : "No operatiu") + ", estatIluminacio= " + estatIluminacio_ + ".";
    }

    /**
     * Tanca l'allotjament i actualitza la il·luminació segons la incidència.
     * @param in Incidència que provoca el tancament
     */
    public void tancarAllotjament(Incidencia in) {
        estatAllotjament_ = false;
        estatIluminacio_ = in.getIluminacioAllotjament();
    }

    /**
     * Obre l'allotjament i restableix la il·luminació al 100%.
     */
    public void obrirAllotjament() {
        estatAllotjament_ = true;
        estatIluminacio_ = "100%";
    }

    /**
     * Compara dos allotjaments per igualtat basant-se en el seu ID.
     * @param o Objecte a comparar
     * @return true si són iguals, false en cas contrari
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allotjament allotjament = (Allotjament) o;
        return idAllotjament_.equals(allotjament.idAllotjament_);
    }
}