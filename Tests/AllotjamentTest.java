import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.Incidencia;
import prog2.model.Allotjament.Allotjament;
import prog2.model.Interficies.InAllotjament.Temp;

/**
 * Classe de test per a la classe abstracta {@link Allotjament}.
 * <p>
 * Conté tests unitaris per verificar el funcionament dels mètodes de la classe Allotjament,
 * incloent la gestió d'estades mínimes, estats i incidències.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @see Allotjament
 * @see Incidencia
 * @since 1.0
 */
class AllotjamentTest {
    private Allotjament allotjament;
    private Incidencia incidencia;

    /**
     * Implementació concreta de {@link Allotjament} per a propòsits de testing.
     */
    private static class AllotjamentConcret extends Allotjament {
        /**
         * Constructor que inicialitza un allotjament amb els paràmetres bàsics.
         */
        public AllotjamentConcret(String nom, String id, long estadaAlta, long estadaBaixa,
                                  boolean estat, String iluminacio) {
            super(nom, id, estadaAlta, estadaBaixa, estat, iluminacio);
        }

        /**
         * Implementació del mètode abstracte que determina si l'allotjament funciona correctament.
         * @return true si l'allotjament està operatiu i amb il·luminació al 100%, false altrament
         */
        @Override
        public boolean correcteFuncionament() {
            return this.getEstatAllotjament() && "100%".equals(this.getEstatIluminacio());
        }
    }

    /**
     * Configuració inicial executada abans de cada test.
     * <p>
     * Inicialitza un allotjament de prova i una incidència per utilitzar en els tests.
     * </p>
     */
    @BeforeEach
    void setUp() {
        allotjament = new AllotjamentConcret("Allotjament", "ALL2", 3, 1, true, "100%");
        incidencia = new Incidencia(1176, Incidencia.TipusIncidencia.Neteja, allotjament, "22/07/2025");
    }

    /* -------------------- Tests pels mètodes bàsics -------------------- */

    /**
     * Test per verificar el correcte funcionament del constructor.
     */
    @Test
    void testConstructor() {
        assertEquals("Allotjament", allotjament.getNom());
        assertEquals("ALL2", allotjament.getId());
        assertTrue(allotjament.getEstatAllotjament());
        assertEquals("100%", allotjament.getEstatIluminacio());
    }

    /**
     * Test per verificar els mètodes getters i setters bàsics.
     */
    @Test
    void testGettersSettersBasics() {
        allotjament.setNom("Allotjament nou");
        assertEquals("Allotjament nou", allotjament.getNom());

        allotjament.setId("ALL7");
        assertEquals("ALL7", allotjament.getId());
    }

    /* -------------------- Tests per estades mínimes -------------------- */

    /**
     * Test per verificar el getter d'estada mínima en temporada ALTA.
     */
    @Test
    void testGetEstadaMinimaAlta() {
        assertEquals(3, allotjament.getEstadaMinima(Temp.ALTA));
    }

    /**
     * Test per verificar el getter d'estada mínima en temporada BAIXA.
     */
    @Test
    void testGetEstadaMinimaBaixa() {
        assertEquals(1, allotjament.getEstadaMinima(Temp.BAIXA));
    }

    /**
     * Test per verificar l'actualització d'estades mínimes.
     */
    @Test
    void testSetEstadaMinima() {
        allotjament.setEstadaMinima(5, 2);
        assertEquals(5, allotjament.getEstadaMinima(Temp.ALTA));
        assertEquals(2, allotjament.getEstadaMinima(Temp.BAIXA));
    }

    /* -------------------- Tests per estats i incidències -------------------- */

    /**
     * Test per verificar el tancament d'allotjament amb incidència.
     */
    @Test
    void testTancarAllotjament() {
        allotjament.tancarAllotjament(incidencia);
        assertFalse(allotjament.getEstatAllotjament());
        assertEquals("50%", allotjament.getEstatIluminacio());

        incidencia.setTipusIncidencia(Incidencia.TipusIncidencia.Reparacio);
        allotjament.tancarAllotjament(incidencia);
        assertEquals("100%", allotjament.getEstatIluminacio());

        incidencia.setTipusIncidencia(Incidencia.TipusIncidencia.Tancament);
        allotjament.tancarAllotjament(incidencia);
        assertEquals("0%", allotjament.getEstatIluminacio());
    }

    /**
     * Test per verificar la reobertura d'allotjament.
     */
    @Test
    void testObrirAllotjament() {
        allotjament.tancarAllotjament(incidencia);
        allotjament.obrirAllotjament();
        assertTrue(allotjament.getEstatAllotjament());
        assertEquals("100%", allotjament.getEstatIluminacio());
    }

    /* -------------------- Tests per mètodes abstractes -------------------- */

    /**
     * Test per verificar el mètode abstracte correcteFuncionament.
     */
    @Test
    void testCorrecteFuncionament() {
        assertTrue(allotjament.correcteFuncionament());

        allotjament.tancarAllotjament(incidencia);
        assertFalse(allotjament.correcteFuncionament());
    }

    /* -------------------- Tests per igualtat i representació -------------------- */

    /**
     * Test per verificar el mètode equals.
     */
    @Test
    void testEquals() {
        Allotjament altre = new AllotjamentConcret("Diferent", "ALL1", 2, 1, true, "100%");
        assertFalse(allotjament.equals(altre));

        Allotjament diferent = new AllotjamentConcret("Igual", "ALL2", 3, 1, true, "100%");
        assertTrue(allotjament.equals(diferent));
    }

    /**
     * Test per verificar la representació en cadena (toString).
     */
    @Test
    void testToString() {
        String resultat = allotjament.toString();
        assertTrue(resultat.contains("Allotjament"));
        assertTrue(resultat.contains("ALL2"));
        assertTrue(resultat.contains("Operatiu"));
        assertTrue(resultat.contains("100%"));
    }
}