package prog2.model;

public class BungalowPremium extends Bungalow {
    //Atribut Bungalow Premium
    private boolean serveisExtra_;
    private String codiWifi_;

    //Constructor
    public BungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv,
                           boolean aireFred, boolean serveisExtra_, String codiWifi_) {
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra_ = serveisExtra_;
        this.codiWifi_ = codiWifi_;
    }

    //Mètodes
    public boolean correcteFuncionament() {
        return (isAireFred()) && (codiWifi_.length() >= 8 && codiWifi_.length() <= 16);
    }

    public boolean isServeisExtra(){
        return serveisExtra_;
    }

    public String getCodiWifi(){
        return codiWifi_;
    }

    public void setServeisExtra(boolean serveisExtra_) {
        this.serveisExtra_ = serveisExtra_;
    }

    public void setCodiWifi(String codiWifi_) {
        this.codiWifi_ = codiWifi_;
    }

    //Declara primer un Bungalow i seguidament afageix un llistat "ServeisPreium"
    @Override
    public String toString() {
        return super.toString() + "ServeisPremium{serveisExtra=" + serveisExtra_ + ", codiWifi=" + codiWifi_ + "}";
    }
}
