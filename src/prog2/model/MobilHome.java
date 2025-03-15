package prog2.model;

public class MobilHome extends Casa {
    //Atributs MobilHome
    private boolean terrasaBarbacoa_;

    //Constructor
    public MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                     boolean terrasaBarbacoa_) {
        super(nom_, idAllotjament_, 5, 3, mida, habitacions, placesPersones);
        this.terrasaBarbacoa_ = terrasaBarbacoa_;
    }

    //Mètodes
    public boolean correcteFuncionament() {
        return terrasaBarbacoa_;
    }

    public boolean isTerrasaBarbacoa(){
        return terrasaBarbacoa_;
    }

    public void setTerrasaBarbacoa(boolean terrasaBarbacoa_) {
        this.terrasaBarbacoa_ = terrasaBarbacoa_;
    }

    @Override
    public String toString() {
        return super.toString() + "MobilHome{terrasaBarbacoa=" + terrasaBarbacoa_ + "}";
    }
}

