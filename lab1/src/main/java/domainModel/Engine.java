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

    public  void StartTheEngine() throws IllegalStateException, InterruptedException {
        if (Enable){
            throw new IllegalStateException();
        } else {
            System.out.print("Зажужжал мотор.");
            noise = new Sound();
            Thread.sleep(200);
            noise.SwitchNoise();
            passengers = new FordAndArthur();
            if(passengers.getInspace()) {
                throw new IllegalStateException();
            } else {
                passengers.goInSpace();
            }
        }

    }
}
