package prog2.model;

public class Bungalow extends Casa {
    //Atribut Bungalow
    private int placesParquing_;
    private boolean terrassa_;
    private boolean tv_;
    private boolean aireFred_;

    //Constructor comú
    public Bungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                    int placesParquing_, boolean terrassa_, boolean tv_, boolean aireFred_) {
        super(nom_, idAllotjament_, 7, 4,mida,habitacions,placesPersones);
        this.placesParquing_ = placesParquing_;
        this.terrassa_ = terrassa_;
        this.tv_ = tv_;
        this.aireFred_ = aireFred_;
    }

    //Mètodes
    public boolean correcteFuncionament() {return aireFred_;}

    public int getPlacesParquing(){
        return placesParquing_;
    }

    public boolean isTerrassa(){
        return terrassa_;
    }

    public boolean isTv(){
        return tv_;
    }

    public boolean isAireFred(){
        return aireFred_;
    }

    public void setPlacesParquing(int placesParquing_) {
        this.placesParquing_ = placesParquing_;
    }

    public void setTerrassa(boolean terrassa_) {
        this.terrassa_ = terrassa_;
    }

    public void setTv(boolean tv_) {
        this.tv_ = tv_;
    }

    public void setAireFred(boolean aireFred_) {
        this.aireFred_ = aireFred_;
    }

    @Override
    public String toString() {
        return super.toString() + "Bungalow{placesParquing=" + placesParquing_ + ", terrassa=" + terrassa_ + ", tv=" + tv_ + ", aireFred=" + aireFred_ + "}";
    }
}
