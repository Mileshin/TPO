package domainModel;

/**
 * Created by Acer on 24.03.2018.
 */

public class Sound {
    private TypeNoise noise = TypeNoise.WHISTLING;
    public Air air;
    public void SwitchNoise() {
        noise=TypeNoise.ROARING;
        System.out.print(" Тоненький свист перерос в рев воздуха, ");
        air = new Air(this);
        air.AirBreaksIn();
    }
}
