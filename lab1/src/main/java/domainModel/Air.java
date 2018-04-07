package domainModel;

/**
 * Created by Acer on 24.03.2018.
 */
public class Air {
    private BlackEmptines space;
    private Sound noise;

    public BlackEmptines getSpace(){
        return space;
    }
    public Sound getNoise(){
        return noise;
    }

    public Air(Sound noise){
        this.noise=noise;
    }

    public void AirBreaksIn(){
        System.out.print("вырывающегося ");
        space = new BlackEmptines(this);
    }
}
