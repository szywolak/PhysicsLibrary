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
public class SecondNewtonLawTestTwo {
    //given
    SecondNewtonLaw secondNewtonLaw = new SecondNewtonLaw();

    private double mass;
    private int acceleration;
    private double expected;

    public SecondNewtonLawTestTwo(double mass, int acceleration, double expected) {
        this.mass = mass;
        this.acceleration = acceleration;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2.0, 1, 2.0 },
                { 2.0, 3, 6.0  },
                { 5.0, 45, 225.0  },
                { 11.3, 9, 101.7  }
        });
    }


    @Test
    public void testForce(){
        //when
        double givenEqual = secondNewtonLaw.forceWithGivenMassAndAcceleration(mass, acceleration);
        //then
        assertEquals(expected, givenEqual);
    }
}