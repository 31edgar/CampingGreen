package prog2.model;
import prog2.model.Allotjament.Allotjament;
import prog2.model.Interficies.InLlistaIncidencies;
import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaIncidencies implements InLlistaIncidencies {

    //Atribut
    private ArrayList<Incidencia> incidencias;
    //Constructor
    public LlistaIncidencies() {
        this.incidencias = new ArrayList<>();
    }

    //Mètodes
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        //Itera sobre la llista d'incidències i compara els allotjaments
        for (Incidencia incidencia : incidencias) {
            if (incidencia.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("ERROR: Allotjament especificat ja té una incidènicia");
            }
        }

        Incidencia in = new Incidencia(num,Incidencia.TipusIncidencia.valueOf(tipus),allotjament,data);
        incidencias.add(in);
        allotjament.tancarAllotjament(in);
    }

    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        //Comprova que la incidencia existeix dins la llista
        if (!incidencias.isEmpty())
            for (Incidencia incidencia : incidencias) {
                if (incidencia.equals(in)) {
                    incidencias.remove(incidencia);
                    incidencia.getAllotjament().obrirAllotjament();
                    break;
                }
            }
        throw new ExcepcioCamping("ERROR: La incidència especificada no existeix");
    }

    public String llistarIncidencies() throws ExcepcioCamping {
        if(incidencias.isEmpty()){
            throw new ExcepcioCamping("ERROR: La llista d'incidències és buida");
        }

        StringBuilder str = new StringBuilder();

        for (Incidencia incidencia : incidencias) {
            str.append("Incidencia ").append(incidencia.getNumeroIncidencia()).append(": ")
                    .append("Tipus: ").append(incidencia.getTipusIncidencia())
                    .append(" Allotjament: ").append(incidencia.getAllotjament())
                    .append(" Data: ").append(incidencia.getData()).append("\n");
        }
        return str.toString();
    }

    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        for (Incidencia incidencia : incidencias) {
            if (incidencia.getNumeroIncidencia() == num){
                return incidencia;
            }
        }
        throw new ExcepcioCamping("ERROR: No hi ha cap incidència amb el número especificat");
    }
}
