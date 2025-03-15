package prog2.model;

public class Parcela extends Allotjament {
    //Atributs Parcela
    private float metres_;
    private boolean connexioElectrica_;

    //Constructor comú
    public Parcela(String nom_, String idAllotjament, float metres_, boolean connexioElectrica_){
        super(nom_, idAllotjament, 4, 2);
        this.metres_ = metres_;
        this.connexioElectrica_ = connexioElectrica_;
    }

    //Mètodes
    public boolean correcteFuncionament() {return connexioElectrica_;}

    public float getMida() {return metres_;}

    public void setMida(float metres_){
        this.metres_ = metres_;
    }

    public boolean isConnexioElectrica(){
        return connexioElectrica_;
    }

    public void setConnexioElectrica(boolean connexioElectrica_){
        this.connexioElectrica_ = connexioElectrica_;
    }

    @Override
    public String toString() {
        return super.toString() + "Parcela{metres=" + metres_ + ", connexioElectrica=" + connexioElectrica_ + "}";
    }
}


