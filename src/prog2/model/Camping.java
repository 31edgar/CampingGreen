package prog2.model;
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping {
    // Atributs
    private String nom_;
    private ArrayList<Allotjament> llistaAllotjaments = new ArrayList<>();
    private ArrayList<Client> llistaClients = new ArrayList<>();
    private LlistaReserves llistaReserves = new LlistaReserves();

    // Constructor
    public Camping(String nom_) {
        this.nom_ = nom_;
    }

    // Mètodes
    // - Getters
    public String getNom() {
        return nom_;
    }

    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }

    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }

    public int getNumAllotjaments() {
        return llistaAllotjaments.size();
    }

    public int getNumReserves() {return llistaReserves.getNumReserves();}

    public int getNumClients() {
        return llistaClients.size();
    }

    // Mètodes per afegir
    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva {
        Client client = new Client(nom_, dni_);
        llistaClients.add(client);
    }

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaAllotjaments.add(parcela);
    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.add(bungalow);
    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                      int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(bungalowPremium);
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               String material, boolean casaMascota) {
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.add(glamping);
    }

    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                boolean terrassaBarbacoa) {
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.add(mobilHome);
    }

    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        // Busquem si el client existeix i si l'allotjament existeix
        Client client = buscarClient(dni_);
        Allotjament allotjament = buscarAllotjament(id_);
        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    public float calculMidaTotalParceles() {
        float midaTotal = 0;

        // Iterem per tota la llista d'allotjaments i per a totes les parceles, sumem la seva mida al total
        for (Allotjament allotjament : llistaAllotjaments) {
            if (allotjament instanceof Parcela) {
                Parcela parcela = (Parcela) allotjament; // Fem un cast al tipus parcela, per poder utilitzar el seu metode getMida()
                midaTotal += parcela.getMida();
            }
        }

        return midaTotal;
    }

    public int calculAllotjamentsOperatius() {
        int allotjamentsOperatius = 0;

        // Mirem el correcte funcionament per a cada tipus d'allotjament
        for (Allotjament allotjament : llistaAllotjaments) {
            if (allotjament instanceof Parcela) {
                Parcela parcela = (Parcela) allotjament;
                if (parcela.correcteFuncionament()) {
                    allotjamentsOperatius++;
                }
            }

            if (allotjament instanceof Bungalow) {
                Bungalow bungalow = (Bungalow) allotjament;
                if (bungalow.correcteFuncionament()) {
                    allotjamentsOperatius++;
                }
            }

            if (allotjament instanceof BungalowPremium) {
                BungalowPremium bungalowPremium = (BungalowPremium) allotjament;
                if (bungalowPremium.correcteFuncionament()) {
                    allotjamentsOperatius++;
                }
            }

            if (allotjament instanceof Glamping) {
                Glamping glamping = (Glamping) allotjament;
                if (glamping.correcteFuncionament()) {
                    allotjamentsOperatius++;
                }
            }

            if (allotjament instanceof MobilHome) {
                MobilHome mobilHome = (MobilHome) allotjament;
                if (mobilHome.correcteFuncionament()) {
                    allotjamentsOperatius++;
                }
            }
        }

        return allotjamentsOperatius;
    }

    public Allotjament getAllotjamentEstadaMesCurta() {
        long estadaMesCurta = 1000000;
        Allotjament allotjamentEstadaMesCurta = null;

        for (Allotjament allotjament : llistaAllotjaments) {
            long estada = allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA);
            if (estada < estadaMesCurta) {
                estadaMesCurta = estada;
                allotjamentEstadaMesCurta = allotjament;
            }
        }

        return allotjamentEstadaMesCurta;
    }

    public Client buscarClient(String dni_) throws ExcepcioReserva {
        for (Client client : llistaClients) {
            if (client.getDni().equals(dni_)) {
                return client;
            } else {
                throw new ExcepcioReserva("afegirReserva: buscarClient: dni " + dni_ + " no existeix a la llista de clients");
            }
        }
        return null;
    }

    public Allotjament buscarAllotjament(String id_) throws ExcepcioReserva{
        for (Allotjament allotjament : llistaAllotjaments) {
            if (allotjament.getId().equals(id_)) {
                return allotjament;
            } else {
                throw new ExcepcioReserva(("afegirReserva: buscarAllotjament: id " + id_ + " no existeix a la llista d'allotjaments"));
            }
        }
        return null;
    }

    public static InAllotjament.Temp getTemporada(LocalDate dataEntrada) {
        LocalDate _20marc = LocalDate.of(2025, 3, 20);
        LocalDate _21setembre = LocalDate.of(2025, 9, 21);
        InAllotjament.Temp temp = (dataEntrada.isAfter(_20marc) && dataEntrada.isBefore(_21setembre)) ? InAllotjament.Temp.ALTA : InAllotjament.Temp.BAIXA;

        return temp;
    }


}
