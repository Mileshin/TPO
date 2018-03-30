import domainModel.Engine;
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

    @Before
    public void beforeClass() throws InterruptedException {
        engine = new Engine();
        engine.StartTheEngine();
        try {
            File testLog = new File("testLog.txt");
            System.setOut(new PrintStream(testLog));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCreate() throws IllegalStateException, InterruptedException {
        Engine test = new Engine();
        assertFalse(test.getEnable());
        test.StartTheEngine();
    }


   /* @Before
    public void beforeClass() {
        ford = new Ford();
        ford.seekTheSwitch();
        shadows = ford.getTerrifyingShadows();
        arthur = shadows.getArthur();
        try {
            File testLog = new File("testLog");
            System.setOut(new PrintStream(testLog));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = IllegalStateException.class)
    public void testHasSwitchAndTryFindMore() throws IllegalStateException {
        ford.seekTheSwitch();
    }
*/

}
