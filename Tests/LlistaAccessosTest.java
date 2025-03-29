import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.Acces.Acces;
import prog2.model.Acces.AccesAsfalt;
import prog2.model.Acces.LlistaAccessos;
import prog2.vista.ExcepcioCamping;

/**
 * Classe de test per a {@link LlistaAccessos}.
 * <p>
 * Conté tests unitaris per verificar el funcionament de la gestió de llistes d'accessos.
 * </p>
 */
class LlistaAccessosTest {
    private LlistaAccessos llistaAccessos;
    private Acces accesNormal;
    private Acces accesAsfalt;

    /**
     * Implementació concreta de {@link Acces} per a testing.
     */
    private static class AccesTest extends Acces {
        public AccesTest(String nom, boolean accessibilitat) {
            super(nom, accessibilitat);
        }
        @Override
        public boolean isAccessibilitat() {
            return true;
        }
    }

    /**
     * Implementació concreta de {@link AccesAsfalt} per a testing.
     */
    private static class AccesAsfaltTest extends AccesAsfalt {
        public AccesAsfaltTest(String nom, boolean accessibilitat, float metres) {
            super(nom, accessibilitat, metres);
        }
        @Override
        public boolean isAccessibilitat() {
            return true;
        }
    }

    @BeforeEach
    void setUp() throws ExcepcioCamping {
        llistaAccessos = new LlistaAccessos();
        accesNormal = new AccesTest("Acces", true);
        accesAsfalt = new AccesAsfaltTest("AccesAsfalt", true, 50.5f);

        llistaAccessos.afegirAcces(accesNormal);
        llistaAccessos.afegirAcces(accesAsfalt);
    }

    @Test
    void testCalculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        assertEquals(50.5f, llistaAccessos.calculaMetresQuadratsAsfalt(), 0.001);

        Acces nouAsfalt = new AccesAsfaltTest("Camí", true, 30.2f);
        llistaAccessos.afegirAcces(nouAsfalt);
        assertEquals(80.7f, llistaAccessos.calculaMetresQuadratsAsfalt(), 0.001);
    }

    /**
     * Test per verificar el comportament amb llista buida en càlculs.
     */
    @Test
    void testCalculsAmbLlistaBuida() {
        LlistaAccessos llistaBuida = new LlistaAccessos();
        assertThrows(ExcepcioCamping.class, () -> {
            llistaBuida.calculaAccessosAccessibles();
        });
        assertThrows(ExcepcioCamping.class, () -> {
            llistaBuida.calculaMetresQuadratsAsfalt();
        });
    }
}