package prog2.model;
import prog2.model.Acces.*;
import prog2.model.Allotjament.*;
import prog2.model.Interficies.InCamping;
import prog2.vista.ExcepcioCamping;

import java.io.*;

/**
 * Classe principal que representa un camping i la seva gestió.
 * <p>
 * Aquesta classe implementa la interfície {@link InCamping} i s'encarrega
 * de gestionar tots els elements del camping: allotjaments, accessos
 * i incidències. També proporciona mètodes per a la persistència de dades.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see InCamping
 * @see LlistaAllotjaments
 * @see LlistaAccessos
 * @see LlistaIncidencies
 * @since 1.0
 */
public class Camping implements InCamping, Serializable {
    private String nom;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaIncidencies llistaIncidencies;

    /**
     * Constructor principal del camping.
     *
     * @param nom Nom del camping
     */
    public Camping(String nom) {
        this.nom = nom;
        llistaAllotjaments = new LlistaAllotjaments();
        llistaAccessos = new LlistaAccessos();
        llistaIncidencies = new LlistaIncidencies();
    }

    /**
     * Obté el nom del camping.
     *
     * @return Nom del camping
     */
    public String getNomCamping() {
        return nom;
    }

    /**
     * Llista els allotjaments segons l'estat especificat.
     *
     * @param estat Estat dels allotjaments a llistar ("Tots", "Oberts" o "Tancats")
     * @return String amb la llista d'allotjaments
     * @throws ExcepcioCamping Si hi ha un error en el filtratge
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return llistaAllotjaments.llistarAllotjaments(estat);
    }

    /**
     * Llista els accessos segons l'estat especificat.
     *
     * @param infoEstat Estat dels accessos a llistar ("Obert" o "Tancat")
     * @return String amb la llista d'accessos
     * @throws ExcepcioCamping Si hi ha un error en el filtratge
     */
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        boolean estat = infoEstat.equals("Obert");
        return llistaAccessos.llistarAccessos(estat);
    }

    /**
     * Llista totes les incidències registrades.
     *
     * @return String amb la llista d'incidències
     * @throws ExcepcioCamping Si hi ha un error en la llista
     */
    public String llistarIncidencies() throws ExcepcioCamping {
        return llistaIncidencies.llistarIncidencies();
    }

    /**
     * Afegeix una nova incidència al sistema.
     *
     * @param num Número d'incidència
     * @param tipus Tipus d'incidència
     * @param idAllotjament Identificador de l'allotjament afectat
     * @param data Data de l'incidència
     * @throws ExcepcioCamping Si l'allotjament no existeix o hi ha un error
     */
    public void afegirIncidencia(int num, String tipus, String idAllotjament, String data) throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(num, tipus, llistaAllotjaments.getAllotjament(idAllotjament), data);
    }

    /**
     * Elimina una incidència existent.
     *
     * @param num Número de l'incidència a eliminar
     * @throws ExcepcioCamping Si l'incidència no existeix
     */
    public void eliminarIncidencia(int num) throws ExcepcioCamping {
        Incidencia incidencia = llistaIncidencies.getIncidencia(num);
        llistaIncidencies.eliminarIncidencia(incidencia);
    }

    /**
     * Calcula el nombre d'accessos accessibles (oberts).
     *
     * @return Nombre d'accessos oberts
     */
    public int calculaAccessosAccessibles() {
        return llistaAccessos.calculaAccessosAccessibles();
    }

    /**
     * Calcula els metres quadrats totals de camins asfaltats.
     *
     * @return Metratge total asfaltat
     */
    public float calculaMetresQuadratsAsfalt() {
        return llistaAccessos.calculaMetresQuadratsAsfalt();
    }

    /**
     * Guarda l'estat actual del camping en un fitxer.
     *
     * @param camiDesti Ruta del fitxer on es guardarà l'estat
     * @throws ExcepcioCamping Si hi ha un error en el procés de guardat
     */
    public void save(String camiDesti) throws ExcepcioCamping {
        File fitxer = new File(camiDesti);

        try {
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            fout.close();
        } catch (IOException e) {
            throw new ExcepcioCamping("Error al guardar l'arxiu: " + e.getMessage());
        }
    }

    /**
     * Carrega un estat de camping des d'un fitxer.
     *
     * @param camiOrigen Ruta del fitxer a carregar
     * @return Instància de Camping carregada
     * @throws ExcepcioCamping Si hi ha un error en el procés de càrrega
     */
    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        try {
            FileInputStream fin = new FileInputStream(camiOrigen);
            ObjectInputStream ois = new ObjectInputStream(fin);
            Camping camping = (Camping)ois.readObject();
            fin.close();
            return camping;
        } catch (Exception e) {
            throw new ExcepcioCamping("Error al guardar l'arxiu");
        }
    }

    /**
     * Inicialitza les dades del camping amb valors per defecte.
     * <p>
     * Crea 12 accessos de diferents tipus i 6 allotjaments de diversos tipus,
     * establint les relacions entre ells.
     * </p>
     */
    public void inicialitzaDadesCamping() {
        llistaAccessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);
    }
}
