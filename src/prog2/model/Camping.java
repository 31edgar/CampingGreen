package prog2.model;
import prog2.model.Acces.*;
import prog2.model.Allotjament.*;
import prog2.model.Interficies.InAllotjament;
import prog2.model.Interficies.InCamping;
import prog2.vista.ExcepcioCamping;

public class Camping implements InCamping {

    public String getNomCamping() {
        return "";
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "";
    }

    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return "";
    }

    public String llistarIncidencies() throws ExcepcioCamping {
        return "";
    }

    public void afegirIncidencia(int num, String tipus, String idAllotjament, String data) throws ExcepcioCamping {

    }

    public void eliminarIncidencia(int num) throws ExcepcioCamping {

    }

    public int calculaAccessosAccessibles() {
        return 0;
    }

    public float calculaMetresQuadratsAsfalt() {
        return 0;
    }

    public void save(String camiDesti) throws ExcepcioCamping {

    }

    public void inicialitzaDadesCamping() {

    }
}
