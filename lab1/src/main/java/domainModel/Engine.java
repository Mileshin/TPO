package domainModel;

/**
 * Created by Andrey on 24.03.2018.
 */
public class Engine {
    private boolean Enable=false;
    private FordAndArthur passengers;
    private Sound noise;

    public boolean getEnable() { return Enable; }
    public Sound getNoise() { return noise; }
    public FordAndArthur getPassengers(){ return passengers; }

    public  void StartTheEngine() throws IllegalStateException, InterruptedException {
        if (Enable){
            throw new IllegalStateException();
        } else {
            Enable = true;
            System.out.print("Зажужжал мотор.");

            noise = new Sound();
            Thread.sleep(200);
            noise.SwitchNoise();

            passengers = new FordAndArthur();
            passengers.goInSpace();
        }
    }
}
