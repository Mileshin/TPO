package domainModel;

import java.util.ArrayList;

/**
 * Created by Acer on 24.03.2018.
 */
public class BlackEmptines {
    private static final int N = 200000;
    public ArrayList<Star> luminousDots;
    public Air air;
    BlackEmptines(Air incomingAir) {
        System.out.print( "в черную пустоту, усеянную невероятно яркими светящимися точками.");
        luminousDots = new ArrayList<>();
        air = incomingAir;
        for (int i=0; i<N; i++){
            luminousDots.add(new Star());
        }
    }
}
