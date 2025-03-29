import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.Allotjament.Allotjament;
import prog2.model.Incidencia;
import prog2.model.LlistaIncidencies;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

/**
 * Classe de test per a {@link LlistaIncidencies}.
 * <p>
 * Conté tests unitaris per verificar la gestió de llistes d'incidències,
 * incloent afegir, eliminar i llistar incidències.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @see LlistaIncidencies
 * @see ExcepcioCamping
 * @since 1.0
 */
class LlistaIncidenciesTest {
    private LlistaIncidencies llistaIncidencies;
    private Allotjament allotjament1;
    private Allotjament allotjament2;

    /**
     * Implementació concreta de {@link Allotjament} per a testing.
     */
    private static class AllotjamentTest extends Allotjament {
        public AllotjamentTest(String nom, String id) {
            super(nom, id, 2, 1, true, "100%");
        }
        @Override
        public boolean correcteFuncionament() {
            return true;
        }
    }

    /**
     * Configuració inicial executada abans de cada test.
     */
    @BeforeEach
    void setUp() {
        llistaIncidencies = new LlistaIncidencies();
        allotjament1 = new AllotjamentTest("Bungalow Premium", "BUN01");
        allotjament2 = new AllotjamentTest("Bungalow Estàndard", "BUN02");
    }

    /* -------------------- Tests per afegir incidències -------------------- */

    /**
     * Test per verificar l'afegiment correcte d'una incidència.
     * @throws ExcepcioCamping si l'incidència ja existeix
     */
    @Test
    void testAfegirIncidencia() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament1, "15/05/2023");
        assertEquals(1, llistaIncidencies.getIncidencias().size());
        assertFalse(allotjament1.getEstatAllotjament());
    }

    /**
     * Test per verificar que no es pot afegir una incidència duplicada per allotjament.
     */
    @Test
    void testAfegirIncidenciaDuplicadaPerAllotjament() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament1, "15/05/2023");
        assertThrows(ExcepcioCamping.class, () -> {
            llistaIncidencies.afegirIncidencia(2, "Neteja", allotjament1, "16/05/2023");
        });
    }

    /**
     * Test per verificar que no es pot afegir una incidència duplicada per número.
     */
    @Test
    void testAfegirIncidenciaDuplicadaPerNumero() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament1, "15/05/2023");
        assertThrows(ExcepcioCamping.class, () -> {
            llistaIncidencies.afegirIncidencia(1, "Neteja", allotjament2, "16/05/2023");
        });
    }

    /* -------------------- Tests per eliminar incidències -------------------- */

    /**
     * Test per verificar l'eliminació correcta d'una incidència.
     * @throws ExcepcioCamping si l'incidència no existeix
     */
    @Test
    void testEliminarIncidencia() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament1, "15/05/2023");
        Incidencia in = llistaIncidencies.getIncidencia(1);
        llistaIncidencies.eliminarIncidencia(in);
        assertTrue(llistaIncidencies.getIncidencias().isEmpty());
        assertTrue(allotjament1.getEstatAllotjament());
    }

    /**
     * Test per verificar l'excepció en eliminar una incidència inexistent.
     */
    @Test
    void testEliminarIncidenciaInexistent() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament1, "15/05/2023");
        Incidencia in = new Incidencia(2, Incidencia.TipusIncidencia.Neteja, allotjament2, "16/05/2023");
        assertThrows(ExcepcioCamping.class, () -> {
            llistaIncidencies.eliminarIncidencia(in);
        });
    }

    /* -------------------- Tests per llistar incidències -------------------- */

    /**
     * Test per verificar el llistat d'incidències.
     * @throws ExcepcioCamping si la llista és buida
     */
    @Test
    void testLlistarIncidencies() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament1, "15/05/2023");
        String resultat = llistaIncidencies.llistarIncidencies();
        assertTrue(resultat.contains("Incidencia 1"));
        assertTrue(resultat.contains("Tipus: Reparacio"));
        assertTrue(resultat.contains("Bungalow Premium"));
    }

    /**
     * Test per verificar l'excepció en llistar incidències amb llista buida.
     */
    @Test
    void testLlistarIncidenciesBuit() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaIncidencies.llistarIncidencies();
        });
    }

    /* -------------------- Tests per consultes -------------------- */

    /**
     * Test per verificar la cerca d'una incidència existent.
     * @throws ExcepcioCamping si l'incidència no existeix
     */
    @Test
    void testGetIncidencia() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament1, "15/05/2023");
        Incidencia resultat = llistaIncidencies.getIncidencia(1);
        assertEquals(1, resultat.getNumeroIncidencia());
        assertEquals(allotjament1, resultat.getAllotjament());
    }

    /**
     * Test per verificar l'excepció en cercar una incidència inexistent.
     */
    @Test
    void testGetIncidenciaInexistent() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaIncidencies.getIncidencia(99);
        });
    }

    /* -------------------- Tests per setters i getters -------------------- */

    /**
     * Test per verificar el setter i getter de la llista d'incidències.
     */
    @Test
    void testSetGetIncidencias() {
        ArrayList<Incidencia> novaLista = new ArrayList<>();
        novaLista.add(new Incidencia(1, Incidencia.TipusIncidencia.Reparacio, allotjament1, "15/05/2023"));

        llistaIncidencies.setIncidencias(novaLista);
        assertEquals(1, llistaIncidencies.getIncidencias().size());
    }
}