package prog2.model;

public class Glamping extends Casa {
    //Atributs Glamping
    private String material_;
    private boolean casaMascota_;

    //Constructor
    public Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                    String material_, boolean casaMascota_) {
        super(nom_, idAllotjament_, 5, 3, mida, habitacions, placesPersones);
        this.material_ = material_;
        this.casaMascota_ = casaMascota_;
    }

    //Mètodes
    public boolean correcteFuncionament() {
        return casaMascota_;
    }

    public String getMaterial(){
        return material_;
    }

    public boolean isCasaMascota(){
        return casaMascota_;
    }

    public void setMaterial(String material_) {
        this.material_ = material_;
    }

    public void setCasaMascota(boolean casaMascota_) {
        this.casaMascota_ = casaMascota_;
    }

    @Override
    public String toString() {
        return super.toString() + "Glamping{material=" + material_ + ", casaMascota=" + casaMascota_ + "}";
    }
}
