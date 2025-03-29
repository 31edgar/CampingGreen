import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.vista.ExcepcioCamping;
import prog2.model.Camping;
import java.io.File;

/**
 * Classe de test per a {@link Camping}.
 * <p>
 * Conté tests unitaris per verificar la gestió del càmping,
 * incloent llistats, incidències i persistència de dades.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @see Camping
 * @see ExcepcioCamping
 * @since 1.0
 */
class CampingTest {
    private Camping camping;
    private static final String TEST_FILE = "test_camping.dat";

    /**
     * Configuració inicial executada abans de cada test.
     */
    @BeforeEach
    void setUp() {
        camping = new Camping("Camping de Test");
        camping.inicialitzaDadesCamping();
    }

    /* -------------------- Tests per mètodes bàsics -------------------- */

    /**
     * Test per verificar el constructor i getter del nom.
     */
    @Test
    void testConstructorIGetNom() {
        assertEquals("Camping de Test", camping.getNomCamping());
    }

    /* -------------------- Tests per llistats -------------------- */

    /**
     * Test per verificar el llistat d'allotjaments.
     * @throws ExcepcioCamping si no hi ha allotjaments
     */
    @Test
    void testLlistarAllotjaments() throws ExcepcioCamping {
        String resultat = camping.llistarAllotjaments("Tots");
        assertTrue(resultat.contains("Parcel·la Nord"));
        assertTrue(resultat.contains("Bungalow Nord"));
        assertTrue(resultat.contains("Glamping Nord"));
    }

    /**
     * Test per verificar el llistat d'accessos.
     * @throws ExcepcioCamping si no hi ha accessos
     */
    @Test
    void testLlistarAccessos() throws ExcepcioCamping {
        String resultat = camping.llistarAccessos("Obert");
        assertTrue(resultat.contains("A1"));
        assertTrue(resultat.contains("A12"));
    }

    /* -------------------- Tests per gestió d'incidències -------------------- */

    /**
     * Test per verificar l'afegiment d'incidència.
     * @throws ExcepcioCamping si l'incidència no existeix
     */
    @Test
    void testAfegirIncidencia() throws ExcepcioCamping {
        camping.afegirIncidencia(1, "Reparacio", "ALL1", "15/05/2023");
        String resultat = camping.llistarIncidencies();
        assertTrue(resultat.contains("Incidencia 1"));
        assertTrue(resultat.contains("ALL1"));
    }

    /**
     * Test per verificar l'eliminació d'incidència.
     * @throws ExcepcioCamping si l'incidència ja existeix
     */
    @Test
    void testEliminarIncidencia() throws ExcepcioCamping {
        camping.afegirIncidencia(1, "Reparacio", "ALL1", "15/05/2023");
        camping.eliminarIncidencia(1);
        assertThrows(ExcepcioCamping.class, () -> {
            camping.llistarIncidencies();
        });
    }

    /* -------------------- Tests per càlculs -------------------- */

    /**
     * Test per verificar el càlcul d'accessos accessibles.
     */
    @Test
    void testCalculaAccessosAccessibles() {
        int accessibles = camping.calculaAccessosAccessibles();
        assertTrue(accessibles > 0);
    }

    /**
     * Test per verificar el càlcul de metres quadrats d'asfalt.
     */
    @Test
    void testCalculaMetresQuadratsAsfalt() {
        float metres = camping.calculaMetresQuadratsAsfalt();
        assertTrue(metres > 0);
    }

    /* -------------------- Tests per persistència -------------------- */

    /**
     * Test per verificar el guardat i carregat del càmping.
     * @throws ExcepcioCamping si hi ha error en fitxer
     */
    @Test
    void testSaveAndLoad() throws ExcepcioCamping {
        // Guardar
        camping.save(TEST_FILE);

        // Carregar
        Camping campingCarregat = Camping.load(TEST_FILE);

        // Verificar
        assertEquals(camping.getNomCamping(), campingCarregat.getNomCamping());
        assertTrue(campingCarregat.llistarAllotjaments("Tots").contains("Parcel·la Nord"));

        // Netejar
        new File(TEST_FILE).delete();
    }

    /**
     * Test per verificar l'excepció en carregar fitxer inexistent.
     */
    @Test
    void testLoadFitxerInexistent() {
        assertThrows(ExcepcioCamping.class, () -> {
            Camping.load("fitxer_inexistent.dat");
        });
    }

    /* -------------------- Tests per inicialització -------------------- */

    /**
     * Test per verificar la inicialització de dades.
     */
    @Test
    void testInicialitzaDadesCamping() {
        // Ja s'executa al setUp()
        assertDoesNotThrow(() -> {
            camping.llistarAllotjaments("Tots");
            camping.llistarAccessos("Obert");
        });
    }
}