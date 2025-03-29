import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.Allotjament.Allotjament;
import prog2.model.Allotjament.Bungalow;
import prog2.model.Allotjament.Parcela;
import prog2.model.Acces.Acces;

import java.util.ArrayList;

/**
 * Classe de test per a la classe {@link Acces}.
 * <p>
 * Conté tests unitaris per verificar el funcionament dels mètodes de la classe abstracta Acces,
 * incloent la gestió d'allotjaments i l'estat dels accessos al camping.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @see Acces
 * @see Bungalow
 * @see Parcela
 * @since 1.0
 */
class AccesTest {
    private Acces acces;
    private Bungalow bungalow;
    private Parcela parcela;

    /**
     * Implementació concreta de {@link Acces} per a propòsits de testing.
     * <p>
     * Proporciona una implementació del mètode abstracte {@code isAccessibilitat()}.
     * </p>
     */
    private static class AccesConcret extends Acces {
        /**
         * Constructor que inicialitza un accés amb nom i accessibilitat.
         *
         * @param nom Nom de l'accés
         * @param accessibilitat Estat d'accessibilitat inicial
         */
        public AccesConcret(String nom, boolean accessibilitat) {
            super(nom, accessibilitat);
        }

        /**
         * Implementació del mètode abstracte que determina si l'accés està accessible.
         *
         * @return true si l'accés està accessible i obert, false altrament
         */
        @Override
        public boolean isAccessibilitat() {
            return this.getAccessibilitat() && this.getEstat();
        }
    }

    /**
     * Configuració inicial executada abans de cada test.
     * <p>
     * Inicialitza un accés de prova i dos allotjaments (un bungalow i una parcel·la)
     * per utilitzar en els tests.
     * </p>
     */
    @BeforeEach
    void setUp() {
        acces = new AccesConcret("Porta Principal", true);
        bungalow = new Bungalow("Bungalow", "ALL1", true, "100%", 35.5f, 2, 4, 1, true, true, true);
        parcela = new Parcela("Parcela", "ALL2", true, "100%", 80.0f, true);
    }

    /* -------------------- Tests pels mètodes concrets -------------------- */

    /**
     * Test per verificar el correcte funcionament del constructor de {@link Acces}.
     * <p>
     * Comprova que els valors inicials dels atributs són els esperats després de la construcció.
     * </p>
     */
    @Test
    void testConstructor() {
        assertEquals("Porta Principal", acces.getNom());
        assertTrue(acces.getAccessibilitat());
        assertTrue(acces.getEstat());
        assertTrue(acces.getAccesAllotjament().isEmpty());
    }

    /**
     * Test per verificar l'addició d'allotjaments mitjançant {@link Acces#afegirAllotjament(Allotjament)}.
     * <p>
     * Comprova que s'afegeix correctament un allotjament a la llista interna.
     * </p>
     */
    @Test
    void testAfegirAllotjament() {
        acces.afegirAllotjament(bungalow);
        assertEquals(1, acces.getAccesAllotjament().size());
        assertSame(bungalow, acces.getAccesAllotjament().get(0));
    }

    /**
     * Test per verificar el canvi d'estat d'accés mitjançant {@link Acces#tancarAcces()} i {@link Acces#obrirAcces()}.
     * <p>
     * Comprova que els mètodes canvien correctament l'estat d'accessibilitat.
     * </p>
     */
    @Test
    void testTancarIObrirAcces() {
        acces.tancarAcces();
        assertFalse(acces.getAccessibilitat());

        acces.obrirAcces();
        assertTrue(acces.getAccessibilitat());
    }

    /**
     * Test per verificar els mètodes setters de {@link Acces}.
     * <p>
     * Comprova que els setters modifiquen correctament els valors dels atributs.
     * </p>
     */
    @Test
    void testSetters() {
        acces.setNom("Nova Porta");
        assertEquals("Nova Porta", acces.getNom());

        acces.setEstat(false);
        assertFalse(acces.getEstat());

        ArrayList<Allotjament> llista = new ArrayList<>();
        llista.add(bungalow);
        acces.setAccesAllotjaments(llista);
        assertEquals(1, acces.getAccesAllotjament().size());
    }

    /* -------------------- Tests pel mètode abstracte -------------------- */

    /**
     * Test per verificar el mètode abstracte {@link Acces#isAccessibilitat()}.
     * <p>
     * Comprova diferents combinacions d'estat i accessibilitat.
     * </p>
     */
    @Test
    void testIsAccessibilitat() {
        // Cas 1: Accés accessible i obert
        assertTrue(acces.isAccessibilitat());

        // Cas 2: Accés no accessible (però obert)
        acces.setAccessibilitat(false);
        assertFalse(acces.isAccessibilitat());

        // Cas 3: Accés accessible però tancat
        acces.setAccessibilitat(true);
        acces.setEstat(false);
        assertFalse(acces.isAccessibilitat());
    }

    /**
     * Test per verificar el mètode {@link Acces#toString()}.
     * <p>
     * Comprova que la representació en cadena conté la informació esperada.
     * </p>
     */
    @Test
    void testToString() {
        String result = acces.toString();
        assertTrue(result.contains("Porta Principal"));
        assertTrue(result.contains("Accessibilitat: true"));

        acces.afegirAllotjament(bungalow);
        assertTrue(acces.toString().contains("Bungalow"));
    }
}