package domainModel;

/**
 * Created by Acer on 24.03.2018.
 */

public class Sound {
    private TypeNoise noise = TypeNoise.WHISTLING;
    private Air air;

    public TypeNoise getNoise() { return noise;}
    public Air getAir() { return air;}

    public void SwitchNoise() {
        if (noise == TypeNoise.ROARING) {
            throw new IllegalStateException();
        } else {
            noise = TypeNoise.ROARING;
            System.out.print(" Тоненький свист перерос в рев воздуха, ");
            air = new Air(this);
            air.AirBreaksIn();
        }
    }
}
