import domainModel.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Andrey on 30.03.2018.
 */
public class domainModelTests extends Assert  {
    private Engine engine;
    private Sound noise;
    private FordAndArthur passengers;
    private Air air;
    private BlackEmptines space;

    @Before
    public void beforeClass() throws InterruptedException {
        engine = new Engine();
        engine.StartTheEngine();
        noise = engine.getNoise();
        passengers = engine.getPassengers();
        air = noise.getAir();
        space = air.getSpace();
        try {
            File testLog = new File("testLog.txt");
            System.setOut(new PrintStream(testLog));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Starting the engine when it is already running
    @Test(expected = IllegalStateException.class)
    public void testEngineAlreadyRunning() throws IllegalStateException, InterruptedException {
        engine.StartTheEngine();
    }

    // Repeated sound change
    @Test(expected = IllegalStateException.class)
    public void testTypeNoiseAlreadyRoaring() throws IllegalStateException, InterruptedException {
       noise.SwitchNoise();
    }

    // Going into space when they are already in space
    @Test(expected = IllegalStateException.class)
    public void testFordAndArthurAlreadyInSpace() throws IllegalStateException {
        passengers.goInSpace();
    }

    // Create Engine. Engine disable
    @Test
    public void testCreateEngine(){
        Engine engine = new Engine();
        assertFalse(engine.getEnable());
    }

    // Create Engine. Not sound
    @Test
    public void testCreateEngineNotSound(){
        Engine engine = new Engine();
        assertNull(engine.getNoise());
    }

    // Start Engine. Engine enable
    @Test
    public void testStartEngine() throws InterruptedException {
        Engine engine = new Engine();
        engine.StartTheEngine();
        assertTrue(engine.getEnable());
    }

    // Start Engine. Yes sound
    @Test
    public void testCreateEngineYesSound() throws InterruptedException {
        Engine engine = new Engine();
        engine.StartTheEngine();
        assertNotNull(engine.getNoise());
    }

    // Create noise. Type noise = whistling
    @Test
    public void testCreateNoiseWhistling(){
        Sound noise = new Sound();
        assertEquals(noise.getNoise(), TypeNoise.WHISTLING);
    }

    // Create noise. There is no air in space.
    @Test
    public void testCreateNoiseNotAir(){
        Sound noise = new Sound();
        assertNull(noise.getAir());
    }

    // Switch noise. Type noise = roaring
    @Test
    public void testSwitchNoiseRoaring(){
        Sound noise = new Sound();
        noise.SwitchNoise();
        assertEquals(noise.getNoise(), TypeNoise.ROARING);
    }

    // Switch noise. The air is in space.
    @Test
    public void testSwitchNoiseYesAir(){
        Sound noise = new Sound();
        noise.SwitchNoise();
        assertNotNull(noise.getAir());
    }

    // Create Air. Air is not in space.
    @Test
    public void testCreateAir(){
        Air air = new Air(new Sound());
        assertNull(air.getSpace());
    }

    // Air Breaks In. Air is in space.
    @Test
    public void testAirBreaksIn(){
        Air air = new Air(new Sound());
        air.AirBreaksIn();
        assertNotNull(air.getSpace());
    }

    // Create BlackEmptines. stars in space.
    @Test
    public void testCreateBlackEmptines(){
        BlackEmptines space = new BlackEmptines(new Air(new Sound()));
        assertNotNull(space.getLuminousDots());
    }

    // Create FordAndArthur. People are not in space.
    @Test
    public void testCreateFordAndArthur(){
        FordAndArthur people = new FordAndArthur();
        assertFalse(people.getInspace());
    }

    // Go In Space. People are in space.
    @Test
    public void testGoInSpace(){
        FordAndArthur people = new FordAndArthur();
        people.goInSpace();
        assertTrue(people.getInspace());
    }


    // Verifying the final state in the system.
    @Test
    public void testEngineStatus() {
        assertTrue(engine.getEnable());
    }
    @Test
    public void testNoiseStatus(){
        assertEquals(noise.getNoise(), TypeNoise.ROARING);
    }
    @Test
    public void testFordAndArthurStatus(){
        assertTrue(passengers.getInspace());
    }

}
