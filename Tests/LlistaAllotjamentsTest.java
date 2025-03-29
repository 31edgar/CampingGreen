import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.Allotjament.Allotjament;
import prog2.model.LlistaAllotjaments;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

/**
 * Classe de test per a {@link LlistaAllotjaments}.
 * <p>
 * Conté tests unitaris per verificar la gestió de llistes d'allotjaments,
 * incloent afegir, llistar i cercar allotjaments.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @see LlistaAllotjaments
 * @see ExcepcioCamping
 * @since 1.0
 */
class LlistaAllotjamentsTest {
    private LlistaAllotjaments llistaAllotjaments;
    private Allotjament allotjamentOperatiu;
    private Allotjament allotjamentNoOperatiu;

    /**
     * Implementació concreta de {@link Allotjament} per a testing.
     */
    private static class AllotjamentTest extends Allotjament {
        public AllotjamentTest(String nom, String id, boolean estat) {
            super(nom, id, 2, 1, estat, "100%");
        }
        @Override
        public boolean correcteFuncionament() {
            return getEstatAllotjament();
        }
    }

    /**
     * Configuració inicial executada abans de cada test.
     */
    @BeforeEach
    void setUp() {
        llistaAllotjaments = new LlistaAllotjaments();
        allotjamentOperatiu = new AllotjamentTest("Bungalow Premium", "ALL1", true);
        allotjamentNoOperatiu = new AllotjamentTest("Bungalow Normal", "ALL2", false);
    }

    /* -------------------- Tests per mètodes bàsics -------------------- */

    /**
     * Test per verificar l'afegiment correcte d'un allotjament.
     * @throws ExcepcioCamping si l'allotjament ja existeix
     */
    @Test
    void testAfegirAllotjament() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        assertEquals(1, llistaAllotjaments.getAllotjaments().size());
        assertTrue(llistaAllotjaments.contains(allotjamentOperatiu));
    }

    /**
     * Test per verificar que no es pot afegir un allotjament duplicat.
     */
    @Test
    void testAfegirAllotjamentDuplicat() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        });
    }

    /**
     * Test per verificar el buidat de la llista.
     */
    @Test
    void testBuidar() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        llistaAllotjaments.buidar();
        assertTrue(llistaAllotjaments.getAllotjaments().isEmpty());
    }

    /* -------------------- Tests per llistar allotjaments -------------------- */

    /**
     * Test per verificar el llistat de tots els allotjaments.
     * @throws ExcepcioCamping si no hi ha allotjaments
     */
    @Test
    void testLlistarAllotjamentsTots() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        llistaAllotjaments.afegirAllotjament(allotjamentNoOperatiu);

        String resultat = llistaAllotjaments.llistarAllotjaments("Tots");
        assertTrue(resultat.contains("Bungalow Premium"));
        assertTrue(resultat.contains("Bungalow Normal"));
    }

    /**
     * Test per verificar el llistat d'allotjaments operatius.
     * @throws ExcepcioCamping si no hi ha allotjaments operatius
     */
    @Test
    void testLlistarAllotjamentsOperatius() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        llistaAllotjaments.afegirAllotjament(allotjamentNoOperatiu);

        String resultat = llistaAllotjaments.llistarAllotjaments("Operatiu");
        assertTrue(resultat.contains("Bungalow Premium"));
        assertFalse(resultat.contains("Bungalow Normal"));
    }

    /**
     * Test per verificar l'excepció quan no hi ha allotjaments amb l'estat sol·licitat.
     */
    @Test
    void testLlistarAllotjamentsSenseResultats() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAllotjaments.llistarAllotjaments("No operatiu");
        });
    }

    /* -------------------- Tests per consultes -------------------- */

    /**
     * Test per verificar la cerca d'un allotjament existent.
     * @throws ExcepcioCamping si l'allotjament no existeix
     */
    @Test
    void testGetAllotjament() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        Allotjament resultat = llistaAllotjaments.getAllotjament("ALL1");
        assertEquals(allotjamentOperatiu, resultat);
    }

    /**
     * Test per verificar l'excepció en cercar un allotjament inexistent.
     */
    @Test
    void testGetAllotjamentInexistent() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAllotjaments.getAllotjament("BUN99");
        });
    }

    /**
     * Test per verificar la presència d'allotjaments operatius.
     */
    @Test
    void testContainsAllotjamentOperatiu() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);
        assertTrue(llistaAllotjaments.containsAllotjamentOperatiu());

        llistaAllotjaments.buidar();
        llistaAllotjaments.afegirAllotjament(allotjamentNoOperatiu);
        assertFalse(llistaAllotjaments.containsAllotjamentOperatiu());
    }

    /* -------------------- Tests per setters i getters -------------------- */

    /**
     * Test per verificar el setter i getter de la llista d'allotjaments.
     */
    @Test
    void testSetGetAllotjaments() {
        ArrayList<Allotjament> novaLista = new ArrayList<>();
        novaLista.add(allotjamentOperatiu);
        novaLista.add(allotjamentNoOperatiu);

        llistaAllotjaments.setAllotjaments(novaLista);
        assertEquals(2, llistaAllotjaments.getAllotjaments().size());
    }
}