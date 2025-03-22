package prog2.model.Allotjament;

public abstract class Casa extends Allotjament{
    //Atributs Casa
    private float mida_;
    private int habitacions_;
    private int placesPersones_;

    //Constructor Comú
    public Casa(String nom_, String idAllotjament, long estadaMinimaALTA_, long estadaMinimaBAIXA_, boolean estatAllotjament, String estatIluminacio, float
            mida_, int habitacions_, int placesPersones_){
        super(nom_,idAllotjament,estadaMinimaALTA_,estadaMinimaBAIXA_, estatAllotjament, estatIluminacio);
        this.mida_ = mida_;
        this.habitacions_ = habitacions_;
        this.placesPersones_ = placesPersones_;
    }

    //Mètodes
    //No és necessari redefinir "correcte funcionament" ja que és una classe abstracte
    public float getMida() {return mida_;}

    public void setMida(float mida_) {this.mida_ = mida_;}

    public int getHabitacions() {return habitacions_;}

    public void setHabitacions(int habitacions_) {this.habitacions_ = habitacions_;}

    public int getPlacesPersones() {return placesPersones_;}

    public void setPlacesPersones(int placesPersones_) {this.placesPersones_ = placesPersones_;}

    @Override
    public String toString(){
        return super.toString() + "Casa{mida=" + mida_ + ", habitacions=" + habitacions_ + ", placesPersones=" + placesPersones_ + "}";
    }
}
