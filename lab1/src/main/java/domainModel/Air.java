package domainModel;

/**
 * Created by Acer on 24.03.2018.
 */
public class Air {
    public BlackEmptines space;
    public Sound noise;
    Air(Sound noise){
        this.noise=noise;
    }
    void AirBreaksIn(){
        System.out.print("вырывающегося ");
        space = new BlackEmptines(this);
    }
}
