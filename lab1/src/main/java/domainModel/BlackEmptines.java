package domainModel;

import java.util.ArrayList;

/**
 * Created by Acer on 24.03.2018.
 */
public class BlackEmptines {
    private static final int N = 200000;
    private ArrayList<Star> luminousDots;
    private Air air;

    public ArrayList<Star> getLuminousDots(){ return luminousDots; }

    public BlackEmptines(Air incomingAir) {
        System.out.print( "в черную пустоту, усеянную невероятно яркими светящимися точками.");
        air = incomingAir;
        luminousDots = new ArrayList<>();
        for (int i=0; i<N; i++){
            luminousDots.add(new Star());
        }
    }
}
