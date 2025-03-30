package prog2.vista;

import prog2.model.Camping;
import prog2.model.Menu;
import java.util.Scanner;

/**
 * Classe que representa la vista del sistema de gestió del càmping.
 * <p>
 * Aquesta classe s'encarrega de la interacció amb l'usuari i la visualització
 * de les dades del càmping. Implementa un menú interactiu amb diferents opcions
 * per gestionar allotjaments, accessos i incidències.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Camping
 * @see Menu
 * @since 1.0
 */
public class VistaCamping {
    // Atributs
    private Camping camping;

    /**
     * Enumeració que representa les opcions del menú principal
     */
    static private enum OpcionsMenuPrincipal {
        LLISTAR_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLLISTAR_ACCESSOS_TANCATS,
        LLISTAR_INCIDENCIES_ACTUALS,
        AFEGIR_INCIDENCIA,
        ELIMINAR_INCIDENCIA,
        CALCULAR_NTOTAL_ACCESSOS_COTXE,
        CALCULAR_NTOTAL_MQUADRATS_ASFALT,
        GUARDAR_CAMPING,
        RECUPERAR_CAMPING,
        SORTIR
    };

    /**
     * Descripcions personalitzades per a les opcions del menú principal
     */
    static private String[] descMenuPrincipal = {
            "Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius",
            "Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts",
            "Llistar la informació dels accessos tancats",
            "Llistar la informació de les incidències actuals",
            "Afegir una incidència",
            "Eliminar una incidència",
            "Calcular i mostrar el número total d'accessos que proporcionen accessibilitat amb cotxe",
            "Calcular i mostrar el número total de metres quadrats d'asfalt dels accessos asfaltats",
            "Guardar càmping",
            "Recuperar càmping",
            "Sortir de l'aplicació"};

    /**
     * Constructor de la vista del càmping.
     *
     * @param nomCamping Nom del càmping que es mostrarà a la interfície
     */
    public VistaCamping(String nomCamping) {
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }

    /**
     * Mètode principal que gestiona el menú i les operacions del càmping.
     * <p>
     * Mostra un menú interactiu amb diferents opcions i gestiona les accions
     * corresponents a cada selecció de l'usuari.
     * </p>
     */
    public void gestioCamping() {
        Scanner sc = new Scanner(System.in);
        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Menu Principal", OpcionsMenuPrincipal.values());
        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenuPrincipal opcio = null;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch(opcio) {
                case LLISTAR_ALLOTJAMENTS:
                    try {
                        System.out.println(camping.llistarAllotjaments("Tots"));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                    try {
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    try {
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case LLISTAR_ACCESSOS_OBERTS:
                    try {
                        System.out.println(camping.llistarAccessos("Obert"));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case LLLISTAR_ACCESSOS_TANCATS:
                    try {
                        System.out.println(camping.llistarAccessos("Tancat"));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case LLISTAR_INCIDENCIES_ACTUALS:
                    try {
                        System.out.println(camping.llistarIncidencies());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case AFEGIR_INCIDENCIA:
                    try {
                        System.out.println("Escriu el número de la incidència: ");
                        int num = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Escriu l'ID de l'allotjament amb aquesta incidencia:");
                        String idAllotjament = sc.nextLine();

                        System.out.println("Escriu el tipus d'incidència que s'ha produit: (Reparacio, Neteja, Tancament)");
                        String tipus = sc.nextLine();

                        System.out.println("Escriu la data de la incidència: (dd/mm/aaaa)");
                        String data = sc.nextLine();

                        camping.afegirIncidencia(num, tipus, idAllotjament, data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case ELIMINAR_INCIDENCIA:
                    try {
                        camping.llistarIncidencies();
                        System.out.println("\nEscriu el número de la incidencia que vols eliminar: ");
                        int numIncidencia = sc.nextInt();
                        camping.eliminarIncidencia(numIncidencia);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case CALCULAR_NTOTAL_ACCESSOS_COTXE:
                    try {
                        System.out.println("El nombre total d'accessos que proporcionen accessibilitat amb cotxe és de: " +
                                camping.calculaAccessosAccessibles());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case CALCULAR_NTOTAL_MQUADRATS_ASFALT:
                    try {
                        System.out.println("El nombre total de metres quadrats d'asfalt dels accessos asfaltats és de: " +
                                camping.calculaMetresQuadratsAsfalt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case GUARDAR_CAMPING:
                    try {
                        camping.save("DadesCamping.dat");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case RECUPERAR_CAMPING:
                    try {
                        Camping.load("DadesCamping.dat");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio != OpcionsMenuPrincipal.SORTIR);
    }
}