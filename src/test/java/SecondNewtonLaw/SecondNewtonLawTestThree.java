package SecondNewtonLaw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Piotr on 2016-04-30.
 */

@RunWith(Parameterized.class)
public class SecondNewtonLawTestThird {
    //given
    SecondNewtonLaw secondNewtonLaw = new SecondNewtonLaw();

    private double force;
    private int acceleration;
    private double expected;

    public SecondNewtonLawTestThird(double force, int acceleration, double expected) {
        this.force = force;
        this.acceleration = acceleration;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2.0, 1, 2.0 },
                { 3.0, 2, 1.5  },
                { 50.0, 5, 10.0  },
                { 15.0, 30, 0.5  }
        });
    }


    @Test
    public void testMass(){
        //when
        double givenEqual = secondNewtonLaw.massWithGivenForceAndAcceleration(acceleration, force);
        //then
        assertEquals(expected, givenEqual);
    }
}
