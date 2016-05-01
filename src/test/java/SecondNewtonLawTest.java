import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Szymon on 2016-04-30.
 */

@RunWith(Parameterized.class)
public class SecondNewtonLawTest {


    private double mass;
    private int force;
    private double expected;

    public SecondNewtonLawTest(double mass, int force, double expected) {
        this.mass = mass;
        this.force = force;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2.0, 1, 0.5 },
                { 2.5, 3, 1.2  },
                { 5.0, 45, 9.0  },
                { 4.5, 9, 2.0  }
        });
    }


    @Test
    public void test(){
        //given
        SecondNewtonLaw secondNewtonLaw = new SecondNewtonLaw();
        //when
        double as = secondNewtonLaw.accelerationWithGivenMassAndForce(mass, force);
        //then
        assertEquals(expected, as);
    }
}
