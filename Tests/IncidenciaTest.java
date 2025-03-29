import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.Allotjament.Allotjament;
import prog2.model.Incidencia;
import prog2.model.Incidencia.TipusIncidencia;

/**
 * Classe de test per a la classe {@link Incidencia}.
 * <p>
 * Conté tests unitaris per verificar el funcionament dels mètodes de la classe Incidencia,
 * incloent la gestió de tipus d'incidències, dates i il·luminació associada.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @see Incidencia
 * @see TipusIncidencia
 * @since 1.0
 */
class IncidenciaTest {

    private Incidencia incidencia;
    private Allotjament allotjament;

    /**
     * Implementació concreta de {@link Allotjament} per a propòsits de testing.
     */
    private static class AllotjamentTest extends Allotjament {
        public AllotjamentTest(String nom, String id, long estadaAlta, long estadaBaixa,
                               boolean estat, String iluminacio) {
            super(nom, id, estadaAlta, estadaBaixa, estat, iluminacio);
        }

        @Override
        public boolean correcteFuncionament() {
            return true;
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
        allotjament = new AllotjamentTest("Allotjament", "ALL2", 2, 1, true, "100%");
        incidencia = new Incidencia(1, TipusIncidencia.Neteja, allotjament, "15/05/2023");
    }

    /* -------------------- Tests per mètodes bàsics -------------------- */

    /**
     * Test per verificar el correcte funcionament del constructor.
     */
    @Test
    void testConstructor() {
        assertEquals(1, incidencia.getNumeroIncidencia());
        assertEquals(TipusIncidencia.Neteja, incidencia.getTipusIncidencia());
        assertEquals(allotjament, incidencia.getAllotjament());
        assertEquals("15/05/2023", incidencia.getData());
    }

    /**
     * Test per verificar els mètodes getters i setters.
     */
    @Test
    void testGettersSetters() {
        incidencia.setNumeroIncidencia(2);
        assertEquals(2, incidencia.getNumeroIncidencia());

        incidencia.setTipusIncidencia(TipusIncidencia.Reparacio);
        assertEquals(TipusIncidencia.Reparacio, incidencia.getTipusIncidencia());

        Allotjament nouAllotjament = new AllotjamentTest("nouAllotjament", "ALL3", 3, 2, true, "100%");
        incidencia.setAllotjament(nouAllotjament);
        assertEquals(nouAllotjament, incidencia.getAllotjament());

        incidencia.setData("20/05/2023");
        assertEquals("20/05/2023", incidencia.getData());
    }

    /* -------------------- Tests per tipus d'incidències -------------------- */

    /**
     * Test per verificar el mètode getIluminacioAllotjament amb diferents tipus d'incidència.
     */
    @Test
    void testGetIluminacioAllotjament() {
        // Cas 1: Incidència de neteja (50%)
        assertEquals("50%", incidencia.getIluminacioAllotjament());

        // Cas 2: Incidència de reparació (100%)
        incidencia.setTipusIncidencia(TipusIncidencia.Reparacio);
        assertEquals("100%", incidencia.getIluminacioAllotjament());

        // Cas 3: Incidència de tancament (0%)
        incidencia.setTipusIncidencia(TipusIncidencia.Tancament);
        assertEquals("0%", incidencia.getIluminacioAllotjament());
    }

    /* -------------------- Tests per representació -------------------- */

    /**
     * Test per verificar la representació en cadena (toString).
     */
    @Test
    void testToString() {
        String resultat = incidencia.toString();
        assertTrue(resultat.contains("NumeroIncidencia= 1"));
        assertTrue(resultat.contains("Allotjament= Nom=Allotjament, Id=ALL2, estada mínima en temp ALTA= 2, estada mínima en temp BAIXA= 1, estatAllotjament= Operatiu, estatIluminacio= 100%."));
        assertTrue(resultat.contains("Data= 15/05/2023"));
        assertTrue(resultat.contains("TipusIncidencia= Neteja"));
    }
}